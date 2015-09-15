package xyz.yhsj.okvolleylibary;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import xyz.yhsj.okvolleylibary.cache.LruBitmapCache;
import xyz.yhsj.okvolleylibary.cookie.PersistentCookieStore;
import xyz.yhsj.okvolleylibary.file.BaseHttp;
import xyz.yhsj.okvolleylibary.file.FileRequestListener;
import xyz.yhsj.okvolleylibary.handler.VolleyRespHandler;
import xyz.yhsj.okvolleylibary.request.OkHttpStack;
import xyz.yhsj.okvolleylibary.request.UTF8StringRequest;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public class OKVolley {
    /**
     * 默认的http请求超时时间为5秒
     */
    private static final int DEFAULT_HTTP_TIMEOUT = 5000;
    private static RequestQueue sRequestQueue;
    private static ImageLoader sImageLoader;
    private static OkHttpClient sOkHttpClient;

    private OKVolley() {
    }

    public static void init(Context context, boolean setCookie) {
        init(context, setCookie, LruBitmapCache.getCacheSize(context));
    }

    public static void init(Context context, boolean setCookie, int maxSize) {
        // 双重检测。由于最后初始化的sImageLoader，所以这里检测sImageLoader是否为空
        if (sImageLoader == null) {
            synchronized (OKVolley.class) {
                if (sImageLoader == null) {
                    initOkHttpClient();
                    initRequestQueue(context);
                    initImageLoader(maxSize);
                    if (setCookie) {
                        setCookieStore(context);
                    }
                }
            }
        }
    }

    private static void initOkHttpClient() {
        sOkHttpClient = new OkHttpClient();
        OKVolley.setConnectTimeout(DEFAULT_HTTP_TIMEOUT);
        OKVolley.setReadTimeout(DEFAULT_HTTP_TIMEOUT);
        OKVolley.setWriteTimeout(DEFAULT_HTTP_TIMEOUT);
    }

    private static void initRequestQueue(Context context) {
        sRequestQueue = Volley.newRequestQueue(context, new OkHttpStack(sOkHttpClient));
        sRequestQueue.start();
    }


    private static void initImageLoader(int maxSize) {
        sImageLoader = new ImageLoader(sRequestQueue, new LruBitmapCache(maxSize));
    }

    /**
     * 设置cookie本地存储
     *
     * @param context
     */
    public static void setCookieStore(Context context) {
        getOkHttpClient().setCookieHandler(new CookieManager(new PersistentCookieStore(context), CookiePolicy.ACCEPT_ALL));
    }

    /**
     * 如果有什么特殊的设置，通过该方法拿到OkHttpClient进行设置
     *
     * @return 返回全局唯一OkHttpClient示例
     */
    public static OkHttpClient getOkHttpClient() {
        if (sOkHttpClient != null) {
            return sOkHttpClient;
        } else {
            throw new IllegalStateException("OKVolley not initialized");
        }
    }

    public static void setConnectTimeout(long timeout) {
        getOkHttpClient().setConnectTimeout(timeout, TimeUnit.MILLISECONDS);
    }

    public static void setReadTimeout(long timeout) {
        getOkHttpClient().setReadTimeout(timeout, TimeUnit.MILLISECONDS);
    }

    public static void setWriteTimeout(long timeout) {
        getOkHttpClient().setWriteTimeout(timeout, TimeUnit.MILLISECONDS);
    }


    //================================================================================

    public static RequestQueue getRequestQueue() {
        if (sRequestQueue != null) {
            return sRequestQueue;
        } else {
            throw new IllegalStateException("OKVolley not initialized");
        }
    }

    public static ImageLoader getImageLoader() {
        if (sImageLoader != null) {
            return sImageLoader;
        } else {
            throw new IllegalStateException("OKVolley not initialized");
        }
    }

    //=================================================================================
    public static void displayImage(String url, ImageView imageView, int defaultImageResId, int errorImageResId) {
        OKVolley.getImageLoader().get(url, ImageLoader.getImageListener(imageView, defaultImageResId, errorImageResId));
    }

    public static void postWithCache(String url, Map<String, String> params, VolleyRespHandler respHandler) {
        post(url, params, true, respHandler);
    }

    public static void postWithoutCache(String url, Map<String, String> params, VolleyRespHandler respHandler) {
        post(url, params, false, respHandler);
    }

    public static void getWithCache(String url, VolleyRespHandler respHandler) {
        get(url, true, respHandler);
    }

    public static void getWithoutCache(String url, VolleyRespHandler respHandler) {
        get(url, false, respHandler);
    }

    /*-----------------------------HTTP文件上传-------------------------------------*/
    public static void updateFile(String url, Map<String, String> params, Map<String, File> fileParams, FileRequestListener listener) {
        BaseHttp.addUpdateRequest(url, params,  fileParams, listener);
    }

    /*-----------------------------文件下载-------------------------------------*/
    public static void download(String url, String fileDir, FileRequestListener listener) {
        BaseHttp.addDownloadRequest(url, fileDir, listener);
    }

    /*-----------------------------取消一个请求-------------------------------------*/
    public static void cancelFileRequestWithUrl(String url) {
        BaseHttp.cancel(url);
    }


    public static void cancelAll(Object tag) {
        OKVolley.getRequestQueue().cancelAll(tag);
    }

    public static void addRequest(Object tag, Request<?> request) {
        if (tag != null) {
            request.setTag(tag);
        }
        OKVolley.getRequestQueue().add(request);
    }

// =============================================================================================

    /**
     * post基类
     *
     * @param url
     * @param params
     * @param shouldCache
     * @param respHandler
     */
    private static void post(String url, final Map<String, String> params, boolean shouldCache, VolleyRespHandler respHandler) {
        respHandler.setUrl(url);
        Request request = new UTF8StringRequest(Request.Method.POST, url, respHandler) {
            protected Map<String, String> getParams() {
                return params;
            }
        };
        request.setShouldCache(shouldCache);
        OKVolley.addRequest(respHandler.getTag(), request);
    }

    /**
     * get基类
     *
     * @param url
     * @param shouldCache
     * @param respHandler
     */
    private static void get(String url, boolean shouldCache, VolleyRespHandler respHandler) {
        respHandler.setUrl(url);
        Request request = new UTF8StringRequest(Request.Method.GET, url, respHandler);
        request.setShouldCache(shouldCache);
        OKVolley.addRequest(respHandler.getTag(), request);
    }

    /**
     * 得到缓存
     *
     * @return
     */
    public static Cache getCache() {
        return OKVolley.getRequestQueue().getCache();
    }

    /**
     * 清除缓存
     *
     * @return
     */
    public static void clearCache() {
        OKVolley.getCache().clear();
    }

}
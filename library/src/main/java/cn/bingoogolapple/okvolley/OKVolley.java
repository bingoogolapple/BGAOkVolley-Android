package cn.bingoogolapple.okvolley;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    public static void init(Context context) {
        init(context, LruBitmapCache.getCacheSize(context));
    }

    public static void init(Context context, int maxSize) {
        // 双重检测。由于最后初始化的sImageLoader，所以这里检测sImageLoader是否为空
        if (sImageLoader == null) {
            synchronized (OKVolley.class) {
                if (sImageLoader == null) {
                    initOkHttpClient();
                    initRequestQueue(context);
                    initImageLoader(maxSize);
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

    public static void displayImage(String url, ImageView imageView, int defaultImageResId, int errorImageResId) {
        OKVolley.getImageLoader().get(url, ImageLoader.getImageListener(imageView, defaultImageResId, errorImageResId));
    }

    public static void addRequest(Object tag, Request<?> request) {
        if (tag != null) {
            request.setTag(tag);
        }
        OKVolley.getRequestQueue().add(request);
    }

    public static void cancelAll(Object tag) {
        OKVolley.getRequestQueue().cancelAll(tag);
    }

    public static void postWithCache(String url, Map<String, String> params, VolleyRespHandler respHandler) {
        post(url, params, true, respHandler);
    }

    public static void postWithoutCache(String url, Map<String, String> params, VolleyRespHandler respHandler) {
        post(url, params, false, respHandler);
    }

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

    public static void getWithCache(String url, VolleyRespHandler respHandler) {
        get(url, true, respHandler);
    }

    public static void getWithoutCache(String url, VolleyRespHandler respHandler) {
        get(url, false, respHandler);
    }

    private static void get(String url, boolean shouldCache, VolleyRespHandler respHandler) {
        respHandler.setUrl(url);
        Request request = new UTF8StringRequest(Request.Method.GET, url, respHandler);
        request.setShouldCache(shouldCache);
        OKVolley.addRequest(respHandler.getTag(), request);
    }

    public static Cache getCache() {
        return OKVolley.getRequestQueue().getCache();
    }

    public static void clearCache() {
        OKVolley.getCache().clear();
    }

}
package cn.bingoogolapple.okvolley;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
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
    public static final int HTTP_TIMEOUT = 30000;
    private static RequestQueue sRequestQueue;
    private static ImageLoader sImageLoader;
    private static OkHttpClient sOkHttpClient;

    private OKVolley() {
    }

    public static void init(Context context) {
        init(context, LruBitmapCache.getCacheSize(context));
    }

    public static void init(Context context, int maxSize) {
        sOkHttpClient = new OkHttpClient();
        sOkHttpClient.setConnectTimeout(HTTP_TIMEOUT, TimeUnit.MILLISECONDS);
        sOkHttpClient.setReadTimeout(HTTP_TIMEOUT, TimeUnit.MILLISECONDS);
        sRequestQueue = Volley.newRequestQueue(context, new OkHttpStack(sOkHttpClient));
        sImageLoader = new ImageLoader(getRequestQueue(), new LruBitmapCache(maxSize));
    }

    public static OkHttpClient getOkHttpClient() {
        if (sOkHttpClient != null) {
            return sOkHttpClient;
        } else {
            throw new IllegalStateException("OKVolley not initialized");
        }
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
        getRequestQueue().add(request);
    }

    public static void cancelAll(Object tag) {
        sRequestQueue.cancelAll(tag);
    }

    public static void post(String url, final Map<String, String> params, VolleyRespDelegate responseListener) {
        addRequest(responseListener.getTag(), new StringRequest(Request.Method.POST, url, responseListener, responseListener.getErrorListener()) {
            protected Map<String, String> getParams() {
                return params;
            }
        });
    }

    public static void get(String url, VolleyRespDelegate responseListener) {
        addRequest(responseListener.getTag(), new StringRequest(Request.Method.GET, url, responseListener, responseListener.getErrorListener()));
    }
}
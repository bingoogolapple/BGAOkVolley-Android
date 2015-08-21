package cn.bingoogolapple.okvolley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public class OKVolley {
    private static RequestQueue sRequestQueue;
    private static ImageLoader sImageLoader;

    private OKVolley() {
    }

    public static void init(Context context) {
        init(context, LruBitmapCache.getCacheSize(context));
    }

    public static void init(Context context, int maxSize) {
        sRequestQueue = Volley.newRequestQueue(context, new OkHttpStack());
        sImageLoader = new ImageLoader(getRequestQueue(), new LruBitmapCache(maxSize));
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
package cn.bingoogolapple.volleynote.engine;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import cn.bingoogolapple.volleynote.model.Nest;
import cn.bingoogolapple.volleynote.model.Normal;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 11:27
 * 描述:
 */
public class ApiClient {
    public static void testApiResponseNormal(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNormal.json", new ApiResponseListener(activity, delegate, Normal.class));
    }

    public static void testApiResponseList(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseList.json", new ApiResponseListener(activity, delegate, ArrayList.class));
    }

    public static void testApiResponseNest(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNest.json", new ApiResponseListener(activity, delegate, Nest.class));
    }

    public static void testApiResponseNeedLogin(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNeedLogin.json", new ApiResponseListener(activity, delegate, Normal.class));
    }

    public static void testApiResponseFailure(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseFailure.json", new ApiResponseListener(activity, delegate, Normal.class));
    }

    public static void testApiResponseJsonError(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        // 本来是List类型，用Normal类型去接收，模拟json解析错误
        // RequestManager.post("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseList.json", new ApiParams().with("p1", "p1value").with("p2", "p2value"), new ApiResponseListener(activity, delegate, Normal.class));
        RequestManager.post("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseJsonError.json", new ApiParams().with("p1", "p1value").with("p2", "p2value"), new ApiResponseListener(activity, delegate, Normal.class));
    }

    public static void testGsonResponseNormal(AppCompatActivity activity, JsonResponseListener.JsonResponseDelegate delegate) {
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNormal.json", new GsonResponseListener(activity, delegate, Normal.class));
    }

    public static void testGsonResponseNest(AppCompatActivity activity, JsonResponseListener.JsonResponseDelegate delegate) {
        RequestManager.post("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNest.json", new ApiParams().with("p1", "p1value").with("p2", "p2value"), new GsonResponseListener(activity, delegate, Nest.class));
    }

    public static void testGsonResponseList(AppCompatActivity activity, JsonResponseListener.JsonResponseDelegate delegate) {
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseList.json", new GsonResponseListener(activity, delegate, ArrayList.class));
    }

    public static void testGsonResponseJsonError(AppCompatActivity activity, JsonResponseListener.JsonResponseDelegate delegate) {
        // 本来是List类型，用Normal类型去接收，模拟json解析错误
        // RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseList.json", new GsonResponseListener(activity, delegate, Normal.class));
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseJsonError.json", new GsonResponseListener(activity, delegate, Normal.class));
    }

    public static void testGetText(AppCompatActivity activity, VolleyResponseListener.VolleyResponseDelegate delegate) {
        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNormal.json", new VolleyResponseListener(activity, delegate));
    }

}
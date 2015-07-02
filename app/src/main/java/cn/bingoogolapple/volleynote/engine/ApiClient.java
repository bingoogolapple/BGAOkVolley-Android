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
        RequestManager.get(activity, "https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNormal.json", new ApiResponseListener<Normal>(activity, delegate));
    }

    public static void testApiResponseList(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get(activity, "https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseList.json", new ApiResponseListener<ArrayList<Normal>>(activity, delegate));
    }

    public static void testApiResponseNest(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get(activity, "https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNest.json", new ApiResponseListener<Nest>(activity, delegate));
    }

    public static void testApiResponseNeedLogin(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get(activity, "https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNeedLogin.json", new ApiResponseListener<Normal>(activity, delegate));
    }

    public static void testApiResponseFailure(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {
        RequestManager.get(activity, "https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseFailure.json", new ApiResponseListener<Normal>(activity, delegate));
    }

    public static void testApiResponseJsonError(AppCompatActivity activity, ApiResponseListener.ApiResponseDelegate delegate) {

    }

    public static void testGsonResponseNormal(AppCompatActivity activity, VolleyResponseListener.VolleyResponseDelegate delegate) {
        RequestManager.get(activity, "https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNormal.json", new GsonResponseListener<Normal>(activity, delegate));
    }

    public static void testGsonResponseNest(AppCompatActivity activity, VolleyResponseListener.VolleyResponseDelegate delegate) {
        RequestManager.get(activity, "https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNest.json", new GsonResponseListener<Nest>(activity, delegate));
    }

    public static void testGsonResponseList(AppCompatActivity activity, VolleyResponseListener.VolleyResponseDelegate delegate) {
        RequestManager.get(activity, "https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseList.json", new GsonResponseListener<ArrayList<Normal>>(activity, delegate));
    }

    public static void testGsonResponseJsonError(AppCompatActivity activity, VolleyResponseListener.VolleyResponseDelegate delegate) {
    }

}
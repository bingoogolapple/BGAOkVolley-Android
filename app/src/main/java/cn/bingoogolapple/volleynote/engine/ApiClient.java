package cn.bingoogolapple.volleynote.engine;

import cn.bingoogolapple.okvolley.ApiParams;
import cn.bingoogolapple.okvolley.ApiRespDelegate;
import cn.bingoogolapple.okvolley.JsonRespDelegate;
import cn.bingoogolapple.okvolley.OKVolley;
import cn.bingoogolapple.okvolley.VolleyRespDelegate;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 11:27
 * 描述:
 */
public class ApiClient {
    public static void testApiResponseNormal(ApiRespDelegate delegate) {
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNormal.json", delegate);
    }

    public static void testApiResponseList(ApiRespDelegate delegate) {
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseList.json", delegate);
    }

    public static void testApiResponseNest(ApiRespDelegate delegate) {
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNest.json", delegate);
    }

    public static void testApiResponseNeedLogin(ApiRespDelegate delegate) {
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNeedLogin.json", delegate);
    }

    public static void testApiResponseFailure(ApiRespDelegate delegate) {
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseFailure.json", delegate);
    }

    public static void testApiResponseJsonError(String param1, String param2, ApiRespDelegate delegate) {
        // 本来是List类型，用Normal类型去接收，模拟json解析错误
//        RequestManager.post("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseList.json", new ApiParams().with("p1", "p1value").with("p2", "p2value"), delegate);
        // 本来是Normal类型，用ArrayList类型去接收，模拟json解析错误
//        RequestManager.post("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseNormal.json", new ApiParams().with("p1", "p1value").with("p2", "p2value"), delegate);
        // Json语法错误
        OKVolley.post("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testApiResponseJsonError.json", new ApiParams().with("p1", param1).with("p2", param2), delegate);
    }

    public static void testGsonResponseNormal(JsonRespDelegate delegate) {
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNormal.json", delegate);
    }

    public static void testGsonResponseNest(String param1, String param2, JsonRespDelegate delegate) {
        OKVolley.post("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNest.json", new ApiParams().with("p1", param1).with("p2", param2), delegate);
    }

    public static void testGsonResponseList(JsonRespDelegate delegate) {
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseList.json", delegate);
    }

    public static void testGsonResponseJsonError(JsonRespDelegate delegate) {
        // 本来是List类型，用Normal类型去接收，模拟json解析错误
//        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseList.json", delegate);
        // 本来是Normal类型，用ArrayList类型去接收，模拟json解析错误
//        RequestManager.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNormal.json", delegate);
        // Json语法错误
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseJsonError.json", delegate);
    }

    public static void testGetText(VolleyRespDelegate delegate) {
        OKVolley.get("https://raw.githubusercontent.com/bingoogolapple/VolleyNote/server/testGsonResponseNormal.json", delegate);
    }

}
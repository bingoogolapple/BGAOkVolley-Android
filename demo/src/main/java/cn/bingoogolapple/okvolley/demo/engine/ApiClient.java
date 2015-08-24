package cn.bingoogolapple.okvolley.demo.engine;

import cn.bingoogolapple.okvolley.ApiParams;
import cn.bingoogolapple.okvolley.ApiRespHandler;
import cn.bingoogolapple.okvolley.JsonRespHandler;
import cn.bingoogolapple.okvolley.OKVolley;
import cn.bingoogolapple.okvolley.VolleyRespHandler;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 11:27
 * 描述:
 */
public class ApiClient {

    public static void testApiResponseNormal(ApiRespHandler respHandler) {
        OKVolley.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testApiResponseNormal.json", respHandler);
    }

    public static void testApiResponseList(ApiRespHandler respHandler) {
        OKVolley.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testApiResponseList.json", respHandler);
    }

    public static void testApiResponseNest(ApiRespHandler respHandler) {
        OKVolley.getWithoutCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testApiResponseNest.json", respHandler);
    }

    public static void testApiResponseNeedLogin(ApiRespHandler respHandler) {
        OKVolley.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testApiResponseNeedLogin.json", respHandler);
    }

    public static void testApiResponseFailure(ApiRespHandler respHandler) {
        OKVolley.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testApiResponseFailure.json", respHandler);
    }

    public static void testApiResponseJsonError(String param1, String param2, ApiRespHandler respHandler) {
        // 本来是List类型，用Normal类型去接收，模拟json解析错误
//        RequestManager.postWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testApiResponseList.json", new ApiParams().with("p1", "p1value").with("p2", "p2value"), respHandler);
        // 本来是Normal类型，用ArrayList类型去接收，模拟json解析错误
//        RequestManager.postWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testApiResponseNormal.json", new ApiParams().with("p1", "p1value").with("p2", "p2value"), respHandler);
        // Json语法错误
        OKVolley.postWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testApiResponseJsonError.json", new ApiParams().with("p1", param1).with("p2", param2), respHandler);
    }

    public static void testGsonResponseNormal(JsonRespHandler respHandler) {
        OKVolley.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testGsonResponseNormal.json", respHandler);
    }

    public static void testGsonResponseNest(String param1, String param2, JsonRespHandler respHandler) {
        OKVolley.postWithoutCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testGsonResponseNest.json", new ApiParams().with("p1", param1).with("p2", param2), respHandler);
    }

    public static void testGsonResponseList(JsonRespHandler respHandler) {
        OKVolley.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testGsonResponseList.json", respHandler);
    }

    public static void testGsonResponseJsonError(JsonRespHandler respHandler) {
        // 本来是List类型，用Normal类型去接收，模拟json解析错误
//        RequestManager.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testGsonResponseList.json", respHandler);
        // 本来是Normal类型，用ArrayList类型去接收，模拟json解析错误
//        RequestManager.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testGsonResponseNormal.json", respHandler);
        // Json语法错误
        OKVolley.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testGsonResponseJsonError.json", respHandler);
    }

    public static void testGetText(VolleyRespHandler respHandler) {
        OKVolley.getWithCache("https://raw.githubusercontent.com/bingoogolapple/BGAOkVolley-Android/server/testGsonResponseNormal.json", respHandler);
    }

}
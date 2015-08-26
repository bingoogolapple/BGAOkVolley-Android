package cn.bingoogolapple.okvolley;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:20
 * 描述:
 */
public abstract class ApiRespHandler<T> extends JsonRespHandler<T> {
    /*
    {
        "error_code": 0,
        "error_description": "successful",
        "content": {
            "property1": "xxxxx",
            "property2": "xxxxx"
        }
    }
    */
    /**
     * 返回错误码的键
     */
    private static String sErrorCodeKeyName = "error_code";
    /**
     * 返回错误消息的键
     */
    private static String sErrorDescriptionKeyName = "error_description";
    /**
     * 返回数据的内容数据的键
     */
    private static String sContentKeyName = "content";
    /**
     * 需要跳转到登录界面的结果码
     */
    private static List<Integer> sJumpToLoginCodes;
    /**
     * 请求数据成功的结果码
     */
    private static int sSuccessCode = 0;

    public ApiRespHandler(@NonNull Object tag) {
        super(tag);
    }

    public ApiRespHandler(@NonNull Object tag, @NonNull Activity activity, @Nullable String loadingMsg) {
        super(tag, activity, loadingMsg);
    }

    public static void init(String errorCodeKeyName, String errorDescriptionKeyName, String contentKeyName, int successCode, Integer... jumpToLoginCodes) {
        sErrorCodeKeyName = errorCodeKeyName;
        sErrorDescriptionKeyName = errorDescriptionKeyName;
        sContentKeyName = contentKeyName;
        sJumpToLoginCodes = Arrays.asList(jumpToLoginCodes);

        sSuccessCode = successCode;
    }

    @Override
    protected void handleResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            int resultCode = jsonObject.getInt(sErrorCodeKeyName);

            if (sJumpToLoginCodes.contains(resultCode)) {
                jumpToLogin();
            } else if (resultCode == sSuccessCode) {
                onSucess(sGson.fromJson(jsonObject.getString(sContentKeyName), getTClass()), jsonObject.getString(sErrorDescriptionKeyName));
            } else {
                onFailure(resultCode, jsonObject.getString(sErrorDescriptionKeyName));
            }
        } catch (Exception e) {
            onJsonError(e);
        }
    }

    protected abstract void jumpToLogin();

    protected abstract void onFailure(int errorCode, String errorDescription);

    protected abstract void onSucess(T content, String msg);

}
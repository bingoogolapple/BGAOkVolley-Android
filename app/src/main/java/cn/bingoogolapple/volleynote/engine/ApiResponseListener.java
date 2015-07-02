package cn.bingoogolapple.volleynote.engine;

import android.support.v7.app.AppCompatActivity;

import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:20
 * 描述:
 */
public class ApiResponseListener<T> extends VolleyResponseListener {
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
    private static int sJumpToLoginCode = -1;
    /**
     * 请求数据成功的结果码
     */
    private static int sSuccessCode = 0;

    public ApiResponseListener(AppCompatActivity activity, ApiResponseDelegate delegate) {
        super(activity, delegate);
    }

    public static void init(String errorCodeKeyName, String errorDescriptionKeyName, String contentKeyName, int jumpToLoginCode, int successCode) {
        sErrorCodeKeyName = errorCodeKeyName;
        sErrorDescriptionKeyName = errorDescriptionKeyName;
        sContentKeyName = contentKeyName;
        sJumpToLoginCode = jumpToLoginCode;
        sSuccessCode = successCode;
    }

    @Override
    protected void handleResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            int resultCode = jsonObject.getInt(sErrorCodeKeyName);
            if (resultCode == sJumpToLoginCode) {
                ((ApiResponseDelegate) mDelegate).jumpToLogin();
            } else if (resultCode == sSuccessCode) {
                T t = sGson.fromJson(jsonObject.getString(sContentKeyName), new TypeToken<T>() {
                }.getType());
                mDelegate.onSucess(t);
            } else {
                ((ApiResponseDelegate) mDelegate).onFailure(resultCode, jsonObject.getString(sErrorDescriptionKeyName));
            }
        } catch (JSONException e) {
            mDelegate.onJsonError(e);
        }
    }

    public interface ApiResponseDelegate<T> extends VolleyResponseDelegate<T> {
        void jumpToLogin();

        void onFailure(int errorCode, String errorDescription);
    }

}
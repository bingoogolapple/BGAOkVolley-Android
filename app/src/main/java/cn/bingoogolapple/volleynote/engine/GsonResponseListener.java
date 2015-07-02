package cn.bingoogolapple.volleynote.engine;

import android.support.v7.app.AppCompatActivity;

import com.google.gson.JsonParseException;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:15
 * 描述:
 */
public class GsonResponseListener extends JsonResponseListener {

    public GsonResponseListener(AppCompatActivity activity, JsonResponseDelegate delegate, Class clazz) {
        super(activity, delegate, clazz);
    }

    @Override
    protected void handleResponse(String response) {
        try {
            mDelegate.onSucess(sGson.fromJson(response, mClazz));
        } catch (JsonParseException e) {
            ((JsonResponseDelegate)mDelegate).onJsonError(e);
        }
    }
}
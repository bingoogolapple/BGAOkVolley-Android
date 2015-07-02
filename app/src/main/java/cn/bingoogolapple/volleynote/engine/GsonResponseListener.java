package cn.bingoogolapple.volleynote.engine;

import android.support.v7.app.AppCompatActivity;

import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:15
 * 描述:
 */
public class GsonResponseListener<T> extends VolleyResponseListener {

    public GsonResponseListener(AppCompatActivity activity, VolleyResponseDelegate delegate) {
        super(activity, delegate);
    }

    @Override
    protected void handleResponse(String response) {
        try {
            T t = sGson.fromJson(response, new TypeToken<T>() {
            }.getType());
            mDelegate.onSucess(t);
        } catch (JsonParseException e) {
            mDelegate.onJsonError(e);
        }
    }
}
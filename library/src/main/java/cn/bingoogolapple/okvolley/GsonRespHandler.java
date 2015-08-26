package cn.bingoogolapple.okvolley;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:15
 * 描述:
 */
public abstract class GsonRespHandler<T> extends JsonRespHandler<T> {

    public GsonRespHandler(@NonNull Object tag) {
        super(tag);
    }

    public GsonRespHandler(@NonNull Object tag, @NonNull Activity activity, @Nullable String loadingMsg) {
        super(tag, activity, loadingMsg);
    }

    @Override
    protected void handleResponse(String response) {
        try {
            onSucess(sGson.fromJson(response, getTClass()));
        } catch (Exception e) {
            onJsonError(e);
        }
    }

    protected abstract void onSucess(T content);
}
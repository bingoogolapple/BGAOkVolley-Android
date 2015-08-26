package cn.bingoogolapple.okvolley;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public abstract class StringRespHandler extends VolleyRespHandler<String> {

    public StringRespHandler(@NonNull Object tag) {
        super(tag);
    }

    public StringRespHandler(@NonNull Object tag, @NonNull Activity activity, @Nullable String loadingMsg) {
        super(tag, activity, loadingMsg);
    }

    @Override
    protected void handleResponse(String response) {
        onSucess(response);
    }

    protected abstract void onSucess(String content);
}
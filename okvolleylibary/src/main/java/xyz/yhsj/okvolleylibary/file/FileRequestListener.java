package xyz.yhsj.okvolleylibary.file;

import android.support.annotation.NonNull;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Http请求回调
 * Created by Hais1992 on 2015/8/25.
 */
public abstract class FileRequestListener {

    private Object mTag;

    /**
     * @param tag 网络请求的tag，不能为空
     */
    protected FileRequestListener(@NonNull Object tag) {
        mTag = tag;
    }


    public abstract void onSuccess(Response response, String result);


    public void onError(Request request, Exception e) {
        e.printStackTrace();
    }

    public void onProgress(long contentLength, long progress, boolean done) {

    }

    //不管成功失败都回调
    public void onFinish(boolean isTrue) {

    }

    public Object getTag() {
        return mTag;
    }


}

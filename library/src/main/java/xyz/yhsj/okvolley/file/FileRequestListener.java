package xyz.yhsj.okvolley.file;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Http请求回调
 * Created by Hais1992 on 2015/8/25.
 */
public abstract class FileRequestListener {

    public abstract void success(Response response, String result);


    public void error(Request request, Exception e) {
        e.printStackTrace();
    }


    public void onString(Response request, String string) {
    }

    public void onProgress(long contentLength, long progress) {

    }

    //不管成功失败都回掉
    public void httpEnd(boolean isTrue) {

    }

}

package xyz.yhsj.okvolley.file;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;

import xyz.yhsj.okvolley.OKVolley;


/**
 * 拿来处理 各种请求
 * Created by Hais1992 on 2015/8/26.
 */
public class DoRequest {
    public OkHttpClient mOkHttpClient;
    public Handler mDelivery;
    private static DoRequest mInstance;

    private DoRequest() {
        mOkHttpClient = OKVolley.getOkHttpClient();
        mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
        mDelivery = new Handler(Looper.getMainLooper());
    }

    public static DoRequest getInstance() {
        if (mInstance == null) {
            synchronized (DoRequest.class) {
                if (mInstance == null) {
                    mInstance = new DoRequest();
                }
            }
        }
        return mInstance;
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @param listener
     */
    public <T> T doHttpRequest(final Request request, final FileRequestListener listener) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Request request, final IOException e) {
                onHttpError(request, e, listener);
            }

            @Override
            public void onResponse(final Response response) {
                try {
                    String string = response.body().string();
                    if (listener != null) {
                        listener.onString(response, string);
                    }
                    onHttpSuccess(response, listener, string);
                } catch (Exception e) {
                    onHttpError(request, e, listener);
                }
            }
        });
        return null;
    }


    /**
     * 下载文件
     *
     * @param request
     * @param url
     * @param destFileDir
     * @param listener
     */
    public void doDownloadResponse(final Request request, final String url, final String destFileDir, final FileRequestListener listener) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                onHttpError(request, e, listener);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                long contentLength = response.body().contentLength();
                InputStream is = null;
                byte[] buf = new byte[2048];
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();

                    File dir = new File(destFileDir);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    File file = new File(dir, getFileName(url));
                    fos = new FileOutputStream(file);
                    int progress = 0, len = 0;
                    while ((len = is.read(buf)) != -1) {
                        progress += len;
                        fos.write(buf, 0, len);
                        if (listener != null) listener.onProgress(contentLength, progress);
                    }
                    fos.flush();
                    //如果下载文件成功，第一个参数为文件的绝对路径
                    onHttpSuccess(response, listener, file.getAbsolutePath());
                } catch (IOException e) {
                    onHttpError(request, e, listener);
                } finally {
                    try {
                        if (is != null) is.close();
                        if (fos != null) fos.close();
                    } catch (IOException e) {
                    }
                }
            }
        });
    }


    /**
     * HTTP错误
     */
    public void onHttpError(final Request request, final Exception e, final FileRequestListener listener) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (listener != null) {
                    listener.httpEnd(false);
                    listener.error(request, e);
                }
            }
        });
    }

    /**
     * HTTP成功
     */
    public <T> T onHttpSuccess(final Response response, final FileRequestListener listener, final String result) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (listener != null) {
                    listener.httpEnd(true);
                    listener.success(response, result);
                }
            }
        });
        return null;
    }


    private String getFileName(String path) {
        int separatorIndex = path.lastIndexOf("/");
        return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length()).replace("?", "");
    }
}

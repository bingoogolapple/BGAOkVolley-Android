package xyz.yhsj.okvolley.file;

import com.squareup.okhttp.Request;

import java.io.File;
import java.util.Map;

/**
 * 基于 OkHttp 的网络请求 基本方法
 * Created by Hais1992 on 2015/8/25.
 */
public class BaseHttp {
    public static final String TAG = "Http请求";

    /**
     * 添加一个 Post 文件上传 请求
     */
    public static void addUpdateRequest(String url, Map<String, String> params, File[] files, String[] fileKeys, FileRequestListener fileRequestListener) {
        Request request = GetRequest.requestFile(url, files, fileKeys, params);  //根据请求 类型，获取 Request
        DoRequest.getInstance().doHttpRequest(request, fileRequestListener);  //处理请求
    }

    /**
     * 添加一个 文件下载 请求
     */
    public static void addDownloadRequest(String url, String fileDir, FileRequestListener fileRequestListener) {
        Request request = GetRequest.requestDownload(url, fileDir);
        DoRequest.getInstance().doDownloadResponse(request, url, fileDir, fileRequestListener);
    }

    /**
     * 取消一个请求
     */
    public static void cancel(String url) {
        if (DoRequest.getInstance().mOkHttpClient != null) {
            DoRequest.getInstance().mOkHttpClient.cancel(url);
        }
    }
}

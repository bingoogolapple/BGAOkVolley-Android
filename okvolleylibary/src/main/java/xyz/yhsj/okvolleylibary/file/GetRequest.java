package xyz.yhsj.okvolleylibary.file;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.File;
import java.net.URLConnection;
import java.util.Map;


/**
 * Created by Hais1992 on 2015/8/25.
 */
public class GetRequest {
    private static MediaType type = MediaType.parse("application/octet-stream;charset=UTF-8");

    /**
     * 上传文件
     *
     * @param url        请求地址
     * @param fileParams 文件，可多文件
     * @param params     参数
     * @return
     */
    public static Request requestFile(String url, Map<String, File> fileParams, Map<String, String> params, FileRequestListener fileRequestListener) {
        MultipartBuilder builder = new MultipartBuilder().type(MultipartBuilder.FORM);

        if (params != null) {
            for (String key : params.keySet()) {
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\""), RequestBody.create(null, params.get(key)));
            }
        }

        if (fileParams != null) {

            for (String key : fileParams.keySet()) {

                File file = fileParams.get(key);
                String fileName = file.getName();

                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(fileName);

                if (contentTypeFor == null) contentTypeFor = "application/octet-stream";

                RequestBody fileBody = RequestBody.create(MediaType.parse(contentTypeFor), file);

                //TODO 根据文件名设置contentType
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"; filename=\"" + fileName + "\""), fileBody);
            }

        }

        RequestBody requestBody = builder.build();

        return new Request.Builder().url(url).post(new ProgressRequestBody(requestBody, fileRequestListener)).tag(url).build();
    }


    public static Request requestDownload(String url, String destFileDir) {
        Request request = new Request.Builder().url(url).tag(url).build();
        return request;
    }


}

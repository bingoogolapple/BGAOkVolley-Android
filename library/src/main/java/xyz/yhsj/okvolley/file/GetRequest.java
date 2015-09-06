package xyz.yhsj.okvolley.file;

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
     * @param url      请求地址
     * @param files    文件，可多文件
     * @param fileKeys
     * @param params   参数
     * @return
     */
    public static Request requestFile(String url, File[] files, String[] fileKeys, Map<String, String> params) {
        MultipartBuilder builder = new MultipartBuilder().type(MultipartBuilder.FORM);
        for (String key : params.keySet()) {
            builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\""), RequestBody.create(null, params.get(key)));
        }

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String fileName = file.getName();

                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(fileName);
                if (contentTypeFor == null) contentTypeFor = "application/octet-stream";

                RequestBody fileBody = RequestBody.create(MediaType.parse(contentTypeFor), file);
                //TODO 根据文件名设置contentType
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + fileKeys[i] + "\"; filename=\"" + fileName + "\""), fileBody);
            }
        }
        RequestBody requestBody = builder.build();
        return new Request.Builder().url(url).post(requestBody).tag(url).build();
    }


    public static Request requestDownload(String url, String destFileDir) {
        Request request = new Request.Builder().url(url).tag(url).build();
        return request;
    }


}

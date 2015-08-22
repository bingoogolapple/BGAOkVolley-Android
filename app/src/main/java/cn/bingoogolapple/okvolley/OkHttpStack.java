package cn.bingoogolapple.okvolley;

import com.android.volley.toolbox.HurlStack;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/8/21 16:40
 * 描述:
 */
public class OkHttpStack extends HurlStack {
    private OkUrlFactory mOkUrlFactory;

    public OkHttpStack(OkHttpClient okHttpClient) {
        mOkUrlFactory = new OkUrlFactory(okHttpClient);
    }

    @Override
    protected HttpURLConnection createConnection(URL url) throws IOException {
        return mOkUrlFactory.open(url);
    }
}
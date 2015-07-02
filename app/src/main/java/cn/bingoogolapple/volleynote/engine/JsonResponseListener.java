package cn.bingoogolapple.volleynote.engine;

import android.support.v7.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public abstract class JsonResponseListener extends VolleyResponseListener {
    protected static Gson sGson = new Gson();
    protected Class mClazz;

    public JsonResponseListener(AppCompatActivity activity, JsonResponseDelegate delegate, Class clazz) {
        super(activity, delegate);
        mClazz = clazz;
    }

    protected abstract void handleResponse(String response);

    public Response.ErrorListener getErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onFinish();
                mDelegate.onNetError(error);
            }
        };
    }

    public void onFinish() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    public interface JsonResponseDelegate<T> extends VolleyResponseDelegate<T> {
        void onJsonError(Exception e);
    }

}
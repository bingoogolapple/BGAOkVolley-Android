package cn.bingoogolapple.volleynote.engine;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.bingoogolapple.volleynote.util.Logger;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public abstract class VolleyResponseListener implements Response.Listener<String> {
    private static final String TAG = VolleyResponseListener.class.getSimpleName();
    protected static Gson sGson = new GsonBuilder().create();
    protected VolleyResponseDelegate mDelegate;
    protected ProgressDialog mLoadingDialog;

    public VolleyResponseListener(AppCompatActivity activity, VolleyResponseDelegate delegate) {
        mDelegate = delegate;
        if (activity != null) {
            mLoadingDialog = new ProgressDialog(activity);
            mLoadingDialog.setMessage("数据加载中，请稍候");
            mLoadingDialog.show();
        }
    }

    @Override
    public void onResponse(String response) {
        Logger.e(TAG, response);
        onFinish();
        handleResponse(response);
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

    public interface VolleyResponseDelegate<T> {

        void onSucess(T content);

        void onJsonError(Exception e);

        void onNetError(VolleyError error);
    }

}
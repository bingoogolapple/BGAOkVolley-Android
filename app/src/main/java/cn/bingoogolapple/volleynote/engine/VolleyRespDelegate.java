package cn.bingoogolapple.volleynote.engine;

import android.support.v7.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import cn.bingoogolapple.volleynote.util.Logger;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public abstract class VolleyRespDelegate<T> implements Response.Listener<String> {
    private static final String TAG = VolleyRespDelegate.class.getSimpleName();
    protected SweetAlertDialog mLoadingDialog;
    private AppCompatActivity mActivity;

    protected VolleyRespDelegate(AppCompatActivity activity) {
        mActivity = activity;
        if (mActivity != null) {
            mLoadingDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
            mLoadingDialog.setTitleText("加载中...");
            mLoadingDialog.setCancelable(false);
            mLoadingDialog.show();
        }
    }

    public AppCompatActivity getActivity() {
        return mActivity;
    }

    @Override
    public void onResponse(String response) {
        Logger.e(TAG, response);
        onFinish();
        handleResponse(response);
    }

    protected void handleResponse(String response) {
        onSucess((T) response);
    }

    public Response.ErrorListener getErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onFinish();
                onNetError(error);
            }
        };
    }

    public void onFinish() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    protected abstract void onSucess(T content);

    protected abstract void onNetError(VolleyError error);
}
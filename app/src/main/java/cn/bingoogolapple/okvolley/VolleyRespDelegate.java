package cn.bingoogolapple.okvolley;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public abstract class VolleyRespDelegate<T> implements Response.Listener<String> {
    private static final String TAG = VolleyRespDelegate.class.getSimpleName();
    private static boolean sIsDebug = false;
    private static String sLoadingMessage = "数据加载中，请稍候";
    protected SweetAlertDialog mLoadingDialog;
    private Object mTag;

    protected VolleyRespDelegate(Object tag, Activity activity) {
        mTag = tag;

        showLoadingDialog(activity);
    }

    private void showLoadingDialog(Activity activity) {
        if (activity != null) {
            mLoadingDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
            mLoadingDialog.setCancelable(false);
            mLoadingDialog.setTitleText(sLoadingMessage);
            mLoadingDialog.show();
        }
    }

    public static void setIsDebug(boolean isDebug) {
        sIsDebug = isDebug;
    }

    public static void setLoadingMessage(String loadingMessage) {
        sLoadingMessage = loadingMessage;
    }

    public Object getTag() {
        return mTag;
    }

    @Override
    public void onResponse(String response) {
        closeLoadingDialog();

        if (sIsDebug) {
            Log.d(TAG, "response\n-------------------- START --------------------\n" + response + "\n-------------------- END --------------------");
        }

        handleResponse(response);

        onFinish();
    }

    private void closeLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    protected void handleResponse(String response) {
        onSucess((T) response);
    }

    public Response.ErrorListener getErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                closeLoadingDialog();

                onNetError(error);

                onFinish();
            }
        };
    }

    public void onFinish() {
    }

    protected abstract void onSucess(T content);

    protected abstract void onNetError(VolleyError error);

}
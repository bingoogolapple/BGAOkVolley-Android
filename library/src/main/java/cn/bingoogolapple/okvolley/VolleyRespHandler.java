package cn.bingoogolapple.okvolley;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.VolleyError;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public abstract class VolleyRespHandler<T> implements VolleyRespListener<String> {
    private static final String TAG = VolleyRespHandler.class.getSimpleName();
    private static boolean sIsDebug = false;
    protected SweetAlertDialog mLoadingDialog;
    protected Object mTag;
    protected Activity mActivity;
    protected String mUrl;

    /**
     * 用于在Service中的网络请求，不需要显示网络数据加载对话框
     *
     * @param tag 网络请求的tag，不能为空
     */
    protected VolleyRespHandler(@NonNull Object tag) {
        mTag = tag;
    }

    /**
     * 用于在Activity、Fragment、Dialog、PopupWindow等可视化中的网络请求
     *
     * @param tag        网络请求的tag，不能为空
     * @param activity   执行当前网络请求的activity，不能为空
     * @param loadingMsg 网络加载过程中显示的消息，如果为null则不显示网络数据加载对话框
     */
    protected VolleyRespHandler(@NonNull Object tag, @NonNull Activity activity, @Nullable String loadingMsg) {
        mTag = tag;
        mActivity = activity;
        showLoadingDialog(loadingMsg);
    }

    @Override
    public Object getTag() {
        return mTag;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        closeLoadingDialog();

        onNetError(error);

        onFinish();
    }

    @Override
    public void onResponse(String response) {
        closeLoadingDialog();

        if (sIsDebug) {
            Log.d(TAG, mUrl + "\n-------------------- START --------------------\n" + response + "\n-------------------- END --------------------");
        }

        handleResponse(response);

        onFinish();
    }

    protected abstract void handleResponse(String response);

    protected abstract void onNetError(VolleyError error);

    /**
     * 不管请求成功还是失败，最后都会调用该方法，这里给个默认的实现
     */
    protected void onFinish() {
    }

    private void showLoadingDialog(String loadingMsg) {
        if (mActivity != null && !TextUtils.isEmpty(loadingMsg)) {
            mLoadingDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE);
            mLoadingDialog.setCancelable(false);
            mLoadingDialog.setTitleText(loadingMsg);
            mLoadingDialog.show();
        }
    }

    private void closeLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    public void setUrl(@NonNull String url) {
        mUrl = url;
    }

    public static void setIsDebug(boolean isDebug) {
        sIsDebug = isDebug;
    }

}
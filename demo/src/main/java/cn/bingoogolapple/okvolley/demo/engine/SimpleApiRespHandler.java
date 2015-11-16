package cn.bingoogolapple.okvolley.demo.engine;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import cn.bingoogolapple.okvolley.ApiRespHandler;
import cn.bingoogolapple.okvolley.OKVolley;
import cn.bingoogolapple.okvolley.demo.util.SweetAlertDialogUtil;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/8/22 下午2:01
 * 描述:这里给个默认的实现，根据公司业务重写相应方法
 */
public abstract class SimpleApiRespHandler<T> extends ApiRespHandler<T> {
    /**
     * 用户登录过期时，后台重新登录后是否再次执行当前请求
     */
    private boolean mRetry = true;

    public SimpleApiRespHandler(Object tag, Activity activity) {
        super(tag, activity, "数据加载中");
    }

    @Override
    protected void jumpToLogin() {
        // 统一处理需要跳转到登陆界面的情况
        if (mRetry) {
            mRetry = false;

            // 1.获取保存在本地的用户名密码后重新登录

            // 2.再次执行当前的请求
            if (mRequest.getMethod() == Request.Method.POST) {
                OKVolley.postWithoutCache(mRequest.getUrl(), mRequest.getPostParamMap(), this);
            } else {
                OKVolley.getWithoutCache(mRequest.getUrl(), this);
            }
        } else {
            SweetAlertDialogUtil.showNormal(mActivity, "提示", "请先登陆");
        }
    }

    @Override
    protected void onFailure(int errorCode, String errorDescription) {
        SweetAlertDialogUtil.showError(mActivity, "提示", errorDescription);
    }

    @Override
    protected void onJsonError(Exception e) {
        SweetAlertDialogUtil.showWarning(mActivity, "提示", "Json解析错误");
    }

    @Override
    protected void onNetError(VolleyError error) {
        SweetAlertDialogUtil.showWarning(mActivity, "提示", "网络出错");
    }
}

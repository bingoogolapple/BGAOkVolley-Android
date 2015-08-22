package cn.bingoogolapple.okvolley.demo.engine;

import android.app.Activity;

import com.android.volley.VolleyError;

import cn.bingoogolapple.okvolley.GsonRespDelegate;
import cn.bingoogolapple.okvolley.demo.util.SweetAlertDialogUtil;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/8/22 下午2:15
 * 描述:这里给个默认的实现，根据公司业务重写相应方法
 */
public abstract class SimpleGsonRespDelegate<T> extends GsonRespDelegate<T> {

    public SimpleGsonRespDelegate(Object tag, Activity activity) {
        super(tag, activity);
    }

    @Override
    protected void onJsonError(Exception e) {
        SweetAlertDialogUtil.showWarning(mActivity, "提示", "服务器异常");
    }

    @Override
    protected void onNetError(VolleyError error) {
        SweetAlertDialogUtil.showWarning(mActivity, "提示", "网络出错");
    }
}
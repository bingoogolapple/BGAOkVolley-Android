package cn.bingoogolapple.okvolley.demo;

import android.app.Application;

import cn.bingoogolapple.okvolley.ApiRespDelegate;
import cn.bingoogolapple.okvolley.OKVolley;
import cn.bingoogolapple.okvolley.VolleyRespDelegate;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:12
 * 描述:
 */
public class App extends Application {
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        // 初始化Volley
        OKVolley.init(this);
        // 初始化ApiRespDelegate
        ApiRespDelegate.init("error_code", "error_description", "content", 0, -1);
        // 设置为调试阶段打印日志
        VolleyRespDelegate.setIsDebug(BuildConfig.IS_DEVELOP_MODE);
        VolleyRespDelegate.setLoadingMessage(getString(R.string.loading_data_tip));
    }

    public static App getInstance() {
        return sInstance;
    }
}
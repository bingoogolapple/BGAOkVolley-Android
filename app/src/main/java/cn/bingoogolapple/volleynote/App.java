package cn.bingoogolapple.volleynote;

import android.app.Application;

import cn.bingoogolapple.volleynote.engine.ApiRespDelegate;
import cn.bingoogolapple.volleynote.engine.OKVolley;
import cn.bingoogolapple.volleynote.engine.VolleyRespDelegate;
import cn.bingoogolapple.volleynote.util.Logger;

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
        ApiRespDelegate.init("error_code", "error_description", "content", -1, 0);
        // 设置为调试阶段打印日志
        VolleyRespDelegate.setIsDebug(Logger.IS_DEVELOP_MODE);
        VolleyRespDelegate.setLoadingMessage(getString(R.string.loading_data_tip));
    }

    public static App getInstance() {
        return sInstance;
    }
}
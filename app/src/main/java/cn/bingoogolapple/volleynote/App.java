package cn.bingoogolapple.volleynote;

import android.app.Application;

import cn.bingoogolapple.volleynote.engine.ApiRespDelegate;
import cn.bingoogolapple.volleynote.engine.RequestManager;

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
        RequestManager.init(this);
        // 初始化ApiResponseListener
        ApiRespDelegate.init("error_code", "error_description", "content", -1, 0);
    }

    public static App getInstance() {
        return sInstance;
    }
}
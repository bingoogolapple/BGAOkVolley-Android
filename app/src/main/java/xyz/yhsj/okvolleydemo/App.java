package xyz.yhsj.okvolleydemo;

import android.app.Application;

import xyz.yhsj.okvolleylibary.OKVolley;
import xyz.yhsj.okvolleylibary.handler.ApiRespHandler;
import xyz.yhsj.okvolleylibary.handler.VolleyRespHandler;


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
        OKVolley.init(this, true);
        // 初始化ApiRespDelegate
        ApiRespHandler.init("error_code", "error_description", "content", 0, -1);
        // 设置为调试阶段打印日志
        VolleyRespHandler.setIsDebug(true);
    }

    public static App getInstance() {
        return sInstance;
    }
}
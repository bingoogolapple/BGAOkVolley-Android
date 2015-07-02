package cn.bingoogolapple.volleynote.engine;

import android.support.v7.app.AppCompatActivity;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:14
 * 描述:
 */
public abstract class StringRespDelegate extends VolleyRespDelegate<String> {

    public StringRespDelegate(AppCompatActivity activity) {
        super(activity);
    }

}
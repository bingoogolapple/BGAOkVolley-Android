package cn.bingoogolapple.okvolley;

import com.android.volley.Response;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/8/24 上午2:12
 * 描述:
 */
public interface VolleyRespListener<T> extends Response.ErrorListener, Response.Listener<T> {
    Object getTag();
}
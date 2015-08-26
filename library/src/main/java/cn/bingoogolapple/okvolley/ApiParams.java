package cn.bingoogolapple.okvolley;

import java.util.HashMap;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:30
 * 描述:
 */
public class ApiParams extends HashMap<String, String> {

    public ApiParams() {
    }

    public ApiParams(String key, String value) {
        put(key, value);
    }

    public ApiParams(String key, int value) {
        put(key, String.valueOf(value));
    }

    public ApiParams(String key, long value) {
        put(key, String.valueOf(value));
    }

    public ApiParams with(String key, String value) {
        put(key, value);
        return this;
    }

    public ApiParams with(String key, int value) {
        put(key, String.valueOf(value));
        return this;
    }

    public ApiParams with(String key, long value) {
        put(key, String.valueOf(value));
        return this;
    }

}
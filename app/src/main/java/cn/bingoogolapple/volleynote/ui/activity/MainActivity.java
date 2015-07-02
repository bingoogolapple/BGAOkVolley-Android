package cn.bingoogolapple.volleynote.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.volley.VolleyError;

import java.util.ArrayList;

import cn.bingoogolapple.volleynote.R;
import cn.bingoogolapple.volleynote.engine.ApiClient;
import cn.bingoogolapple.volleynote.engine.ApiResponseListener;
import cn.bingoogolapple.volleynote.engine.JsonResponseListener;
import cn.bingoogolapple.volleynote.engine.VolleyResponseListener;
import cn.bingoogolapple.volleynote.model.Nest;
import cn.bingoogolapple.volleynote.model.Normal;
import cn.bingoogolapple.volleynote.util.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testApiResponseNormal(View v) {
        ApiClient.testApiResponseNormal(this, new ApiResponseListener.ApiResponseDelegate<Normal>() {
            @Override
            public void jumpToLogin() {
                ToastUtil.show("请先登录");
            }

            @Override
            public void onFailure(int errorCode, String errorDescription) {
                ToastUtil.show(errorDescription);
            }

            @Override
            public void onSucess(Normal content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testApiResponseList(View v) {
        ApiClient.testApiResponseList(this, new ApiResponseListener.ApiResponseDelegate<ArrayList<Normal>>() {
            @Override
            public void onSucess(ArrayList<Normal> content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void jumpToLogin() {
                ToastUtil.show("请先登录");
            }

            @Override
            public void onFailure(int errorCode, String errorDescription) {
                ToastUtil.show(errorDescription);
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testApiResponseNest(View v) {
        ApiClient.testApiResponseNest(this, new ApiResponseListener.ApiResponseDelegate<Nest>() {
            @Override
            public void jumpToLogin() {
                ToastUtil.show("请先登录");
            }

            @Override
            public void onFailure(int errorCode, String errorDescription) {
                ToastUtil.show(errorDescription);
            }

            @Override
            public void onSucess(Nest content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testApiResponseNeedLogin(View v) {
        ApiClient.testApiResponseNeedLogin(this, new ApiResponseListener.ApiResponseDelegate<Normal>() {
            @Override
            public void jumpToLogin() {
                ToastUtil.show("请先登录");
            }

            @Override
            public void onFailure(int errorCode, String errorDescription) {
                ToastUtil.show(errorDescription);
            }

            @Override
            public void onSucess(Normal content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testApiResponseFailure(View v) {
        ApiClient.testApiResponseFailure(this, new ApiResponseListener.ApiResponseDelegate<Normal>() {
            @Override
            public void jumpToLogin() {
                ToastUtil.show("请先登录");
            }

            @Override
            public void onFailure(int errorCode, String errorDescription) {
                ToastUtil.show(errorDescription);
            }

            @Override
            public void onSucess(Normal content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testApiResponseJsonError(View v) {
        ApiClient.testApiResponseJsonError(this, new ApiResponseListener.ApiResponseDelegate<Normal>() {
            @Override
            public void jumpToLogin() {
                ToastUtil.show("请先登录");
            }

            @Override
            public void onFailure(int errorCode, String errorDescription) {
                ToastUtil.show(errorDescription);
            }

            @Override
            public void onSucess(Normal content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testGsonResponseNormal(View v) {
        ApiClient.testGsonResponseNormal(this, new JsonResponseListener.JsonResponseDelegate<Normal>() {
            @Override
            public void onSucess(Normal content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testGsonResponseNest(View v) {
        ApiClient.testGsonResponseNest(this, new JsonResponseListener.JsonResponseDelegate<Nest>() {
            @Override
            public void onSucess(Nest content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testGsonResponseList(View v) {
        ApiClient.testGsonResponseList(this, new JsonResponseListener.JsonResponseDelegate<ArrayList<Normal>>() {
            @Override
            public void onSucess(ArrayList<Normal> content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testGsonResponseJsonError(View v) {
        ApiClient.testGsonResponseJsonError(this, new JsonResponseListener.JsonResponseDelegate<Normal>() {
            @Override
            public void onSucess(Normal content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onJsonError(Exception e) {
                ToastUtil.show("服务器异常");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

    public void testGetText(View v) {
        ApiClient.testGetText(this, new VolleyResponseListener.VolleyResponseDelegate<String>() {
            @Override
            public void onSucess(String content) {
                ToastUtil.show("请求成功");
            }

            @Override
            public void onNetError(VolleyError error) {
                ToastUtil.show("网络出错");
            }
        });
    }

}
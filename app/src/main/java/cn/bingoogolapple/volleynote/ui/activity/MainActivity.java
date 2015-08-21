package cn.bingoogolapple.volleynote.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.volley.VolleyError;

import java.util.ArrayList;

import cn.bingoogolapple.volleynote.R;
import cn.bingoogolapple.volleynote.engine.ApiClient;
import cn.bingoogolapple.volleynote.engine.ApiRespDelegate;
import cn.bingoogolapple.volleynote.engine.GsonRespDelegate;
import cn.bingoogolapple.volleynote.engine.StringRespDelegate;
import cn.bingoogolapple.volleynote.model.Nest;
import cn.bingoogolapple.volleynote.model.Normal;
import cn.bingoogolapple.volleynote.util.ToastUtil;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testApiResponseNormal(View v) {
        ApiClient.testApiResponseNormal(new ApiRespDelegate<Normal>(this, this) {
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
        ApiClient.testApiResponseList(new ApiRespDelegate<ArrayList<Normal>>(this, this) {
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
        ApiClient.testApiResponseNest(new ApiRespDelegate<Nest>(this, this) {
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
        ApiClient.testApiResponseNeedLogin(new ApiRespDelegate<Normal>(this, this) {
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
        ApiClient.testApiResponseFailure(new ApiRespDelegate<Normal>(this, this) {
            @Override
            public void jumpToLogin() {
                ToastUtil.show("请先登录");
            }

            @Override
            public void onFailure(int errorCode, String errorDescription) {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("提示")
                        .setContentText(errorDescription)
                        .show();
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
        ApiClient.testApiResponseJsonError("参数1", "参数2", new ApiRespDelegate<Normal>(this, this) {
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
        ApiClient.testGsonResponseNormal(new GsonRespDelegate<Normal>(this, this) {
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
        ApiClient.testGsonResponseNest("参数1", "参数2", new GsonRespDelegate<Nest>(this, this) {
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
        ApiClient.testGsonResponseList(new GsonRespDelegate<ArrayList<Normal>>(this, this) {
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
        ApiClient.testGsonResponseJsonError(new GsonRespDelegate<Normal>(this, this) {
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
        ApiClient.testGetText(new StringRespDelegate(this, this) {
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
package cn.bingoogolapple.volleynote.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import cn.bingoogolapple.volleynote.R;
import cn.bingoogolapple.volleynote.engine.ApiClient;
import cn.bingoogolapple.volleynote.engine.ApiRespDelegate;
import cn.bingoogolapple.volleynote.engine.GsonRespDelegate;
import cn.bingoogolapple.volleynote.engine.OKVolley;
import cn.bingoogolapple.volleynote.engine.StringRespDelegate;
import cn.bingoogolapple.volleynote.model.Nest;
import cn.bingoogolapple.volleynote.model.Normal;
import cn.bingoogolapple.volleynote.util.CircleDrawableUtil;
import cn.bingoogolapple.volleynote.util.ToastUtil;
import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TEST_IMAGE_URL = "http://7xk9dj.com1.z0.glb.clouddn.com/refreshlayout/images/staggered72.png";
    private ImageView mAvatarIv;
    private CircleImageView mAvatarCiv;
    private NetworkImageView mAvatarNiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAvatarIv = (ImageView) findViewById(R.id.iv_main_avatar);
        mAvatarCiv = (CircleImageView) findViewById(R.id.civ_main_avatar);
        mAvatarNiv = (NetworkImageView) findViewById(R.id.niv_main_avatar);
        testLoadImage();
    }

    private void testLoadImage() {
        OKVolley.getRequestQueue().add(new ImageRequest(TEST_IMAGE_URL, new Response.Listener<Bitmap>() {

            @Override
            public void onResponse(Bitmap response) {
                mAvatarIv.setImageDrawable(CircleDrawableUtil.getCircleDrawable(MainActivity.this, response));
            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                mAvatarIv.setImageDrawable(CircleDrawableUtil.getCircleDrawable(MainActivity.this, R.mipmap.avatar_error));
            }
        }));

        OKVolley.getImageLoader().get(TEST_IMAGE_URL, ImageLoader.getImageListener(mAvatarCiv, R.mipmap.avatar_default, R.mipmap.avatar_error));

        mAvatarNiv.setDefaultImageResId(R.mipmap.avatar_default);
        mAvatarNiv.setErrorImageResId(R.mipmap.avatar_error);
        mAvatarNiv.setImageUrl(TEST_IMAGE_URL, OKVolley.getImageLoader());
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
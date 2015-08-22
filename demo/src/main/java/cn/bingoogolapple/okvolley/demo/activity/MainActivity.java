package cn.bingoogolapple.okvolley.demo.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import cn.bingoogolapple.okvolley.OKVolley;
import cn.bingoogolapple.okvolley.RoundedNetworkImageView;
import cn.bingoogolapple.okvolley.StringRespDelegate;
import cn.bingoogolapple.okvolley.demo.R;
import cn.bingoogolapple.okvolley.demo.engine.ApiClient;
import cn.bingoogolapple.okvolley.demo.engine.SimpleApiRespDelegate;
import cn.bingoogolapple.okvolley.demo.engine.SimpleGsonRespDelegate;
import cn.bingoogolapple.okvolley.demo.model.Nest;
import cn.bingoogolapple.okvolley.demo.model.Normal;
import cn.bingoogolapple.okvolley.demo.util.SweetAlertDialogUtil;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TEST_IMAGE_URL = "http://7xk9dj.com1.z0.glb.clouddn.com/refreshlayout/images/staggered72.png";
    private ImageView mAvatarIv;
    private CircleImageView mAvatarCiv;
    private NetworkImageView mAvatarNiv;
    private RoundedNetworkImageView mAvatarCircleRniv;
    private RoundedNetworkImageView mAvatarRoundedRniv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testLoadImage();
    }

    private void testLoadImage() {
        testImageView();
        testCircleImageView();
        testNetworkImageView();
        testCircleNetworkImageView();
        testRoundedNetworkImageView();
    }

    private void testImageView() {
        mAvatarIv = (ImageView) findViewById(R.id.iv_main_avatar);

        OKVolley.getRequestQueue().add(new ImageRequest(TEST_IMAGE_URL, new Response.Listener<Bitmap>() {

            @Override
            public void onResponse(Bitmap response) {
                mAvatarIv.setImageDrawable(RoundedNetworkImageView.getCircleDrawable(MainActivity.this, response));
            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                mAvatarIv.setImageDrawable(RoundedNetworkImageView.getCircleDrawable(MainActivity.this, R.mipmap.avatar_error));
            }
        }));
    }

    private void testCircleImageView() {
        mAvatarCiv = (CircleImageView) findViewById(R.id.civ_main_avatar);

//        OKVolley.getImageLoader().get(TEST_IMAGE_URL, ImageLoader.getImageListener(mAvatarCiv, R.mipmap.avatar_default, R.mipmap.avatar_error));
        OKVolley.displayImage(TEST_IMAGE_URL, mAvatarCiv, R.mipmap.avatar_default, R.mipmap.avatar_error);
    }

    private void testNetworkImageView() {
        mAvatarNiv = (NetworkImageView) findViewById(R.id.niv_main_avatar);

        mAvatarNiv.setDefaultImageResId(R.mipmap.avatar_default);
        mAvatarNiv.setErrorImageResId(R.mipmap.avatar_error);
        mAvatarNiv.setImageUrl(TEST_IMAGE_URL, OKVolley.getImageLoader());
    }

    private void testCircleNetworkImageView() {
        mAvatarCircleRniv = (RoundedNetworkImageView) findViewById(R.id.rniv_main_avatar);

        mAvatarCircleRniv.setImageUrl(TEST_IMAGE_URL, OKVolley.getImageLoader());
    }

    private void testRoundedNetworkImageView() {
        mAvatarRoundedRniv = (RoundedNetworkImageView) findViewById(R.id.rniv_main_avatarRounded);

        mAvatarRoundedRniv.setImageUrl(TEST_IMAGE_URL, OKVolley.getImageLoader());
    }

    public void testApiResponseNormal(View v) {
        ApiClient.testApiResponseNormal(new SimpleApiRespDelegate<Normal>(this, this) {
            @Override
            public void onSucess(Normal content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testApiResponseList(View v) {
        ApiClient.testApiResponseList(new SimpleApiRespDelegate<ArrayList<Normal>>(this, this) {
            @Override
            public void onSucess(ArrayList<Normal> content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testApiResponseNest(View v) {
        ApiClient.testApiResponseNest(new SimpleApiRespDelegate<Nest>(this, this) {
            @Override
            public void onSucess(Nest content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testApiResponseNeedLogin(View v) {
        ApiClient.testApiResponseNeedLogin(new SimpleApiRespDelegate<Normal>(this, this) {
            @Override
            public void onSucess(Normal content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testApiResponseFailure(View v) {
        ApiClient.testApiResponseFailure(new SimpleApiRespDelegate<Normal>(this, this) {
            @Override
            public void onSucess(Normal content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testApiResponseJsonError(View v) {
        ApiClient.testApiResponseJsonError("参数1", "参数2", new SimpleApiRespDelegate<Normal>(this, this) {
            @Override
            public void onSucess(Normal content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testGsonResponseNormal(View v) {
        ApiClient.testGsonResponseNormal(new SimpleGsonRespDelegate<Normal>(this, this) {
            @Override
            public void onSucess(Normal content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testGsonResponseNest(View v) {
        ApiClient.testGsonResponseNest("参数1", "参数2", new SimpleGsonRespDelegate<Nest>(this, this) {
            @Override
            public void onSucess(Nest content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testGsonResponseList(View v) {
        ApiClient.testGsonResponseList(new SimpleGsonRespDelegate<ArrayList<Normal>>(this, this) {
            @Override
            public void onSucess(ArrayList<Normal> content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testGsonResponseJsonError(View v) {
        ApiClient.testGsonResponseJsonError(new SimpleGsonRespDelegate<Normal>(this, this) {
            @Override
            public void onSucess(Normal content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }
        });
    }

    public void testGetText(View v) {
        ApiClient.testGetText(new StringRespDelegate(this, this) {
            @Override
            public void onSucess(String content) {
                SweetAlertDialogUtil.showSuccess(mActivity, "提示", "请求成功");
            }

            @Override
            public void onNetError(VolleyError error) {
                SweetAlertDialogUtil.showError(mActivity, "提示", "网络出错");
            }
        });
    }

}
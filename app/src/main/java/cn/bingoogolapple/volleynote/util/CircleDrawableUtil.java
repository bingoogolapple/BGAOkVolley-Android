package cn.bingoogolapple.volleynote.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/8/21 18:41
 * 描述:
 */
public class CircleDrawableUtil {
    private CircleDrawableUtil() {
    }

    public static RoundedBitmapDrawable getCircleDrawable(Context context, Bitmap bitmap) {
        RoundedBitmapDrawable circleDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
        circleDrawable.getPaint().setAntiAlias(true);
        circleDrawable.setCornerRadius(Math.max(bitmap.getWidth(), bitmap.getHeight()) / 2.0f);
        return circleDrawable;
    }

    public static RoundedBitmapDrawable getCircleDrawable(Context context, @DrawableRes int resId) {
        return getCircleDrawable(context, BitmapFactory.decodeResource(context.getResources(), resId));
    }
}
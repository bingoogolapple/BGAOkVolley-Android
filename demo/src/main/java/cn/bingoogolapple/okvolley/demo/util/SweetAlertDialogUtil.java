package cn.bingoogolapple.okvolley.demo.util;

import android.app.Activity;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/8/22 下午1:54
 * 描述:
 */
public class SweetAlertDialogUtil {

    private SweetAlertDialogUtil() {
    }

    public static void showError(Activity activity, String title, String desc) {
        new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE).setTitleText(title).setContentText(desc).show();
    }

    public static void showWarning(Activity activity, String title, String desc) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE).setTitleText(title).setContentText(desc).show();
    }

    public static void showNormal(Activity activity, String title, String desc) {
        new SweetAlertDialog(activity, SweetAlertDialog.NORMAL_TYPE).setTitleText(title).setContentText(desc).show();
    }

    public static void showSuccess(Activity activity, String title, String desc) {
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE).setTitleText(title).setContentText(desc).show();
    }

    public static void showProgress(Activity activity, String title) {
        new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE).setTitleText(title).show();
    }
}
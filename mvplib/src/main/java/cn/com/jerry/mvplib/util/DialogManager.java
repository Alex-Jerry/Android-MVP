package cn.com.jerry.mvplib.util;

import android.content.Context;

import cn.com.jerry.mvplib.R;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class DialogManager {

    private static SweetAlertDialog mDialog;

    public static void showWarningDialog(Context context, String title, String content, SweetAlertDialog.OnSweetClickListener listener) {
        if (mDialog != null) {
            mDialog = null;
        }
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(content)
                .setConfirmText("确定")
                .setCancelText("取消")
                .setConfirmClickListener(listener);
        mDialog.show();
    }

    public static void showErrorDialog(Context context, String title, String content, SweetAlertDialog.OnSweetClickListener listener) {
        if (mDialog != null) {
            mDialog = null;
        }
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("确定")
                .setTitleText(title)
                .setContentText(content)
                .setConfirmClickListener(listener);
        mDialog.show();
    }

    public static void showProgressDialog(Context context, String message) {
        if (mDialog != null) {
            mDialog = null;
        }
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.colorPrimary));
        mDialog.setTitleText(message);
        mDialog.setCancelable(true);
        mDialog.show();
    }


    public static void showProgressDialog(Context context, String message, int progress) {
        if (mDialog != null) {
            mDialog = null;
        }
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.colorPrimary));
        mDialog.setTitleText(message);
        mDialog.setCancelable(true);
        mDialog.getProgressHelper().setProgress(progress);
        mDialog.show();
    }

    public static void hideProgressDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }
}

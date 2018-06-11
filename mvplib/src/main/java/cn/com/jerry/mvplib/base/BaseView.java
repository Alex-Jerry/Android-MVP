package cn.com.jerry.mvplib.base;

/**
 *
 * Created by LiuLei on 2017/11/27.
 */
public interface BaseView {
    void showMessage(String msg);

    void showProgress(String msg);

    void showProgress(String msg, int progress);

    void hideProgress();

    void showErrorMessage(String msg, String content);
}

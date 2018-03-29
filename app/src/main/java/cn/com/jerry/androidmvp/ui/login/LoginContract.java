package cn.com.jerry.androidmvp.ui.login;

import android.app.Activity;

import cn.com.jerry.mvplib.annotation.Implement;

/**
 * Created by LiuLei on 2017/11/27.
 */
@Implement(LoginPresenter.class)
public interface LoginContract {
    void onLogin(String username, String password, Activity context);
}

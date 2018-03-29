package cn.com.jerry.androidmvp;

import android.app.Application;
import android.content.Context;

import cn.com.jerry.androidmvp.ui.home.MainContract;
import cn.com.jerry.androidmvp.ui.login.LoginContract;
import cn.com.jerry.androidmvp.ui.upload.UploadContract;
import cn.com.jerry.mvplib.base.BaseProxy;

/**
 *
 * Created by LiuLei on 2017/11/27.
 */
public class App extends Application {

    private static App ourInstance = new App();
    private static Context mContext;

    public static App getInstance() {
        return ourInstance;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        mContext = getApplicationContext();
        //这个很重要   该项目中的所有的Contract都必须在此进行初始化（注册)
        BaseProxy.getInstance().init(LoginContract.class, MainContract.class, UploadContract.class);

    }
}

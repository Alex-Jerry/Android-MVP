package cn.com.jerry.androidmvp.ui.login;

import android.app.Activity;

import java.util.HashMap;

import cn.com.jerry.androidmvp.App;
import cn.com.jerry.androidmvp.api.JerryRetrofit;
import cn.com.jerry.androidmvp.model.UserVO;
import cn.com.jerry.androidmvp.utils.ToastUtil;
import cn.com.jerry.mvplib.api.BaseResponse;
import cn.com.jerry.mvplib.api.ProgressSubscriber;
import cn.com.jerry.mvplib.api.SubscriberOnNextListener;
import cn.com.jerry.mvplib.base.model.LoadEveryLogicImpl;
import rx.Subscriber;

/**
 * Created by LiuLei on 2017/11/27.
 */

public class LoginPresenter extends LoadEveryLogicImpl<UserVO> implements LoginContract{
    @Override
    public void onLogin(String username, String password,  Activity context) {
        HashMap<String,String> map = new HashMap<>();
        map.put("mobile","18682176281");
        map.put("password","e10adc3949ba59abbe56e057f20f883e");
//        JerryRetrofit.getInstance().getUserBean(map,new Subscriber<BaseResponse<UserVO>>() {
//            @Override
//            public void onCompleted() {
//                ToastUtil.show("登录完成");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                ToastUtil.show("登录出错");
//            }
//
//            @Override
//            public void onNext(BaseResponse<UserVO> userVOBaseResponse) {
//                onLoadCompleteData(userVOBaseResponse);
//            }
//        });

        JerryRetrofit.getInstance().getUserBean(map,
                new ProgressSubscriber<BaseResponse<UserVO>>(new SubscriberOnNextListener<BaseResponse<UserVO>>() {
            @Override
            public void onNext(BaseResponse<UserVO> userVOBaseResponse) {
                onLoadCompleteData(userVOBaseResponse);
            }
        }, context));
    }

}

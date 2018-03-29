package cn.com.jerry.androidmvp.ui.home;

import android.content.Context;

import java.util.HashMap;
import java.util.List;

import cn.com.jerry.androidmvp.api.JerryRetrofit;
import cn.com.jerry.androidmvp.model.DeviceVO;
import cn.com.jerry.androidmvp.utils.ToastUtil;
import cn.com.jerry.mvplib.api.BaseResponse;
import cn.com.jerry.mvplib.base.BasePresenter;
import rx.Subscriber;

/**
 *
 * Created by LiuLei on 2017/11/27.
 */

public class MainPresenter extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter{
    @Override
    public void onLoadDeviceList(boolean isMore, String token) {
        HashMap<String,String> map = new HashMap<>();
        if(token!=null){
            map.put("token",token);
        }else {
            ToastUtil.show("token不能为空");
            return;
        }
        JerryRetrofit.getInstance().MyDevices(map,new Subscriber<BaseResponse<List<DeviceVO>>>() {
            @Override
            public void onCompleted() {
                ToastUtil.show("获取设备列表完成");
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("获取设备列表出错");
                mView.onFailer(e.getMessage());
            }

            @Override
            public void onNext(BaseResponse<List<DeviceVO>> deviceVOBaseResponse) {
                List<DeviceVO> body = deviceVOBaseResponse.data;
                mView.onLoadCompleteData(body,false);
            }
        });
    }

    @Override
    public void init(Context context) {
        mView.initResult(true);
    }

    @Override
    public void statPlay(String msg) {
        mView.onPlayState(0);
    }

    @Override
    public void stopPlay(String msg) {
        mView.onPlayState(1);
    }

    @Override
    public void end(String msg) {
        mView.onPlayState(2);
    }
}

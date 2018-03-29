package cn.com.jerry.androidmvp.ui.home;

import android.content.Context;

import java.util.List;

import cn.com.jerry.androidmvp.model.DeviceVO;
import cn.com.jerry.mvplib.annotation.Implement;
import cn.com.jerry.mvplib.base.BaseView;

/**
 *
 * Created by LiuLei on 2017/11/27.
 */
@Implement(MainPresenter.class)
public interface MainContract {
    //    //回调给上层activity的接口（逻辑相关的任何接口  此处接口只是举例子）
    interface IMainView extends BaseView {
        void onLoadCompleteData(List<DeviceVO> body, boolean isMore);

        void onFailer(String msg);

        void initResult(boolean isSuccess);

        void onPlayState(int status);
    }

    //统一管理数据加载 进行实质性调用
    interface IMainPresenter {
        void onLoadDeviceList(boolean isMore, String token);

        void init(Context context);

        void statPlay(String msg);

        void stopPlay(String msg);

        void end(String msg);
    }
}

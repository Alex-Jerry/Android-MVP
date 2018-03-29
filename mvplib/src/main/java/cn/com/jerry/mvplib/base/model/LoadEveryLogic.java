package cn.com.jerry.mvplib.base.model;


import cn.com.jerry.mvplib.api.BaseResponse;
import cn.com.jerry.mvplib.base.BaseView;

/**
 * Created by LiuLei on 2017/11/27.
 */
public interface LoadEveryLogic<T> {

    void onLoadCompleteData(BaseResponse<T> response);

    void onFailer(String msg);

    interface LoadEveryView<T> extends BaseView {
        void onLoadComplete(T body);

        void onLoadFailer(String msg);
    }
}

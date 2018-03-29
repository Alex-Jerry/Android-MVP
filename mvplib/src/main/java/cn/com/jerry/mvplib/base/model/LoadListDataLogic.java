package cn.com.jerry.mvplib.base.model;


import java.util.List;

import cn.com.jerry.mvplib.api.BaseResponse;
import cn.com.jerry.mvplib.base.BaseView;

/**
 * Created by LiuLei on 2017/11/27.
 */
public interface LoadListDataLogic<T> {
    void onLoadComplete(BaseResponse<List<T>> response, boolean isMore);

    void onFailer(String msg);

    interface LoadListView<T> extends BaseView {
        void onLoadCompleteData(T body, boolean isMore);

        void onLoadComplete(boolean isMore);
    }
}

package cn.com.jerry.mvplib.base.model;

import java.util.List;

import cn.com.jerry.mvplib.api.BaseResponse;
import cn.com.jerry.mvplib.base.BasePresenter;

/**
 *
 * Created by LiuLei on 2017/11/27.
 */
public class LoadListDataLogicImpl<T> extends BasePresenter<LoadListDataLogic.LoadListView> implements LoadListDataLogic<T> {

    private static LoadListDataLogicImpl instance = new LoadListDataLogicImpl();

    public static LoadListDataLogicImpl getInstance(){
        return instance;
    }

    @Override
    public void onLoadComplete(BaseResponse<List<T>> response, boolean isMore) {
        getView().onLoadComplete(isMore);
        List<T> body = response.data;
        if (body != null)
            getView().onLoadCompleteData(body, isMore);
    }

    @Override
    public void onFailer(String msg) {
        getView().showErrorMessage("网络错误", msg);
    }
}

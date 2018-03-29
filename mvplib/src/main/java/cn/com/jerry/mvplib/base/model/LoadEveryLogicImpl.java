package cn.com.jerry.mvplib.base.model;


import cn.com.jerry.mvplib.api.BaseResponse;
import cn.com.jerry.mvplib.base.BasePresenter;

/**
 * Created by LiuLei on 2017/11/27.
 */
public class LoadEveryLogicImpl<T> extends BasePresenter<LoadEveryLogic.LoadEveryView> implements LoadEveryLogic<T> {

    private static LoadEveryLogicImpl instance = new LoadEveryLogicImpl();

    public static LoadEveryLogicImpl getInstance(){
        return instance;
    }

    @Override
    public void onLoadCompleteData(BaseResponse<T> response) {
        T body = response.data;
        if (body != null)
            getView().onLoadComplete(body);
    }

    @Override
    public void onFailer(String msg) {
        getView().hideProgress();
        getView().onLoadFailer(msg);
    }
}

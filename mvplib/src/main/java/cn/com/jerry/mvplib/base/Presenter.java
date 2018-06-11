package cn.com.jerry.mvplib.base;

/**
 *
 * Created by LiuLei on 2017/11/27.
 */
public interface Presenter<V> {
    void attachView(V mvpView);
    void detachView();
}

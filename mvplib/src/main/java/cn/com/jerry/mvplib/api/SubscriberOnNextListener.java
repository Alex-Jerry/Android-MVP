package cn.com.jerry.mvplib.api;

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}

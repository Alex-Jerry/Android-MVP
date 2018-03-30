package cn.com.jerry.mvplib.api;

import android.app.Activity;
import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ProgressSubscriber<T> implements ProgressCancelListener, Observer<T> {
    private static final String TAG = "ProgressSubscriber";
    private SubscriberOnNextListener<T> mListener;
    private Activity mContext;
    private ProgressDialogHandler mHandler;
    //用于取消连接
    private Disposable mDisposeable;

    public ProgressSubscriber(SubscriberOnNextListener<T> listener, Activity context){
        this.mListener = listener;
        this.mContext = context;
        mHandler = new ProgressDialogHandler(context,this,true);
    }

    private void showProgressDialog(){
        if (mHandler != null) {
            mHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog(){
        if (mHandler != null) {
            mHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mHandler = null;
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            Log.i(TAG, "网络中断，请检查您的网络状态！");
        } else if (e instanceof ConnectException) {
            Log.i(TAG, "网络中断，请检查您的网络状态！");
        } else {
            Log.i(TAG, "error:" + e.getMessage());
        }
        dismissProgressDialog();
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
        Log.i(TAG, "onCompleted: 获取数据完成！");
    }

    @Override
    public void onSubscribe(Disposable d) {
        //拿到Disposable对象可随时取消请求
        mDisposeable = d;
        //订阅开始时调用,显示ProgressDialog
        showProgressDialog();
    }

    @Override
    public void onNext(T t) {
        if (mListener != null){
            mListener.onNext(t);
        }
    }

    @Override
    public void onCancelProgress() {
        if (mDisposeable != null && mDisposeable.isDisposed()){
            mDisposeable.dispose();
        }
    }
}

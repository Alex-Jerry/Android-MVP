package cn.com.jerry.mvplib.base;

/**
 * Created by LiuLei on 2017/11/27.
 */
public class BasePresenter<T extends BaseView> implements Presenter<T> {

    public T mView;

    @Override
    public void attachView(T mvpView) {
        this.mView = mvpView;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    public boolean isViewBind() {
        return mView != null;
    }


    public T getView() {
        return mView;
    }

    public void checkViewAttached() {
        if (!isViewBind()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(BaseView) before" +
                    " requesting data to the Presenter");
        }
    }
}

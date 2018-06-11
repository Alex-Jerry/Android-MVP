package cn.com.jerry.androidmvp.ui.home;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.jerry.androidmvp.R;
import cn.com.jerry.androidmvp.ui.home.domain.DeviceVO;
import cn.com.jerry.androidmvp.ui.login.domain.UserVO;
import cn.com.jerry.androidmvp.ui.upload.UploadActivity;
import cn.com.jerry.mvplib.base.BaseActivity;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class MainActivity extends BaseActivity implements MainContract.IMainView{

    private static final String TAG = "MainActivity";
    @BindView(R.id.listView)
    ListView mListView;
    private List<DeviceVO> mLists = new ArrayList<>();
    private ArrayAdapter<DeviceVO> mAdapter;
    private MainPresenter mPresenter;
    private String mToken;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitView() {
        mPresenter = getBaseImpl(MainContract.class, this);
        mToken = getIntent().getStringExtra("token");
        initData();
    }

    private void initData() {
        mAdapter = new ArrayAdapter<DeviceVO>(this,android.R.layout.simple_list_item_1,mLists);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onLoadCompleteData(List<DeviceVO> body, boolean isMore) {
        mLists.clear();
        mLists.addAll(body);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailer(String msg) {
        //获取数据失败
        Log.e(TAG, "onFailer: "+msg);
    }

    @Override
    public void initResult(boolean isSuccess) {
        Log.e(TAG, "initResult: "+isSuccess);
    }

    @Override
    public void onPlayState(int status) {
        Log.e(TAG, "onPlayState: "+status);
    }

    @OnClick(R.id.load)
    void load(){
        if(!TextUtils.isEmpty(mToken)){
            mPresenter.onLoadDeviceList(false, mToken);
        }
    }

    @OnClick(R.id.next)
    void next(){
        if(!TextUtils.isEmpty(mToken)){
            startActivity(new Intent(MainActivity.this,UploadActivity.class).putExtra("token",mToken));
        }
    }

    @OnClick(R.id.init)
    void init(){
        mPresenter.init(this);
    }

    @OnClick(R.id.start)
    void start(){
        mPresenter.statPlay("开始游戏了");
    }

    @OnClick(R.id.stop)
    void stop(){
        mPresenter.stopPlay("停止游戏了");
    }

}

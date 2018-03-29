package cn.com.jerry.androidmvp.ui.login;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.jerry.androidmvp.R;
import cn.com.jerry.androidmvp.api.JerryApiService;
import cn.com.jerry.androidmvp.api.JerryRetrofit;
import cn.com.jerry.androidmvp.model.NewsEntity;
import cn.com.jerry.androidmvp.model.UserVO;
import cn.com.jerry.androidmvp.ui.home.MainActivity;
import cn.com.jerry.mvplib.base.BaseActivity;
import cn.com.jerry.mvplib.base.model.LoadEveryLogic;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity implements LoadEveryLogic.LoadEveryView<UserVO>{

    @BindView(R.id.et_name)
    EditText mName;
    @BindView(R.id.et_pwd)
    EditText mPwd;
    private LoginContract mPresenter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitView() {
        mPresenter = getBaseImpl(LoginContract.class, this);
    }

    @OnClick(R.id.btn_login)
    void login(){
        Log.e(TAG, "login: ");
        mPresenter.onLogin(mName.getText().toString(),mPwd.getText().toString(),this);
        //get请求   测试缓存
//        JerryApiService newsApi = JerryRetrofit.getInstance().getApiService();
//        newsApi.getNews().enqueue(new Callback<NewsEntity>() {
//            @Override
//            public void onResponse(Call<NewsEntity> call, Response<NewsEntity> response) {
//                //请求成功
//                Log.e(TAG, "onResponse: "+response.body().getStories().toString());
//            }
//
//            @Override
//            public void onFailure(Call<NewsEntity> call, Throwable t) {
//                //请求失败
//                Log.e(TAG, "onFailure: "+t.getMessage());
//            }
//        });

    }

    @Override
    public void onLoadComplete(UserVO body) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("token",body.getUser_token()));
    }

    @Override
    public void onLoadFailer(String msg) {
        showErrorMessage("网络错误", msg);
    }
}

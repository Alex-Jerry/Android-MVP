package cn.com.jerry.androidmvp.api;

import java.util.List;
import java.util.Map;

import cn.com.jerry.androidmvp.C;
import cn.com.jerry.androidmvp.model.DeviceVO;
import cn.com.jerry.androidmvp.model.UserVO;
import cn.com.jerry.mvplib.api.BaseResponse;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class JerryRetrofit {

    private static final String TAG = "JerryRetrofit";
    private Retrofit mRetrofit;
    private JerryApiService mApiService;
    private static JerryRetrofit mInstance;
    private static OkHttpClient mOkHttpClient;

    /**
     * 私有构造方法
     */
    private JerryRetrofit(){
        if (null == mOkHttpClient) {
            mOkHttpClient = JerryOkHttp.getOkHttpClient();
        }
        mRetrofit = new Retrofit.Builder()
                //默认网络请求
//                .client(builder.build())
                //设置使用okhttp网络请求
                .client(mOkHttpClient)
                .baseUrl(C.APP_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mApiService = mRetrofit.create(JerryApiService.class);
    }

    public static JerryRetrofit getInstance(){
        if (mInstance == null){
            synchronized (JerryRetrofit.class){
                mInstance = new JerryRetrofit();
            }
        }
        return mInstance;
    }

    public JerryApiService getApiService(){
        return mApiService;
    }

    //请求的原始函数
    private <T> void request(Observable<T> observable, Subscriber<T> subscriber){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //验证手机号码   这里是我自己的接口
    public void verfcationNum(Map<String,String> map,Subscriber<BaseResponse> subscriber){
        request(mApiService.getVerfcationCodePostMap(map),subscriber);
    }

    //获取用户个人信息   这里是我自己的接口
    public void getUserBean(Map<String,String> map,Subscriber<BaseResponse<UserVO>> subscriber){
        request(mApiService.getUser(map),subscriber);
    }

    //获取我的设备列表  这里是我自己的接口
    public void MyDevices(Map<String,String> map, Subscriber<BaseResponse<List<DeviceVO>>> subscriber){
        request(mApiService.getDevices(map),subscriber);
    }

    //上传头像  这里是我自己的接口
    public void uploadImg(MultipartBody.Part part, Map<String, RequestBody>map, Subscriber<BaseResponse>subscriber){
        mApiService.uploadImage(map,part)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}

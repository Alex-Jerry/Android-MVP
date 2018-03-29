package cn.com.jerry.androidmvp.api;

import java.util.List;
import java.util.Map;

import cn.com.jerry.androidmvp.C;
import cn.com.jerry.androidmvp.model.DeviceVO;
import cn.com.jerry.androidmvp.model.NewsEntity;
import cn.com.jerry.androidmvp.model.UserVO;
import cn.com.jerry.mvplib.api.BaseResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.Observable;

public interface JerryApiService {

    //直接用retrofit请求
    @GET(C.NEWS)
    Call<NewsEntity> getNews();

    //POST请求
    @FormUrlEncoded
    @POST("api/user/checkMobile")
    Observable<BaseResponse> getVerfcationCodePostMap(@FieldMap Map<String, String> map);

    //POST请求
    @FormUrlEncoded
    @POST("api/user/loginByMobile")
    Observable<BaseResponse<UserVO>> getUser(@FieldMap Map<String, String> map);

    //POST请求
    @FormUrlEncoded
    @POST("api/user/devices")
    Observable<BaseResponse<List<DeviceVO>>> getDevices(@FieldMap Map<String, String> map);

    /*上传文件*/
    @Multipart
    @POST("api/user/modifyDevice")
    Observable<BaseResponse> uploadImage(@PartMap Map<String, RequestBody> map, @Part MultipartBody.Part file);

}

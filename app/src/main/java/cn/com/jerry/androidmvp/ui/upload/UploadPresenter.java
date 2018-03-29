package cn.com.jerry.androidmvp.ui.upload;

import java.io.File;
import java.util.HashMap;

import cn.com.jerry.androidmvp.api.JerryRetrofit;
import cn.com.jerry.androidmvp.utils.ToastUtil;
import cn.com.jerry.mvplib.api.BaseResponse;
import cn.com.jerry.mvplib.api.upload.ProgressRequestBody;
import cn.com.jerry.mvplib.api.upload.UploadProgressListener;
import cn.com.jerry.mvplib.base.model.LoadEveryLogicImpl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Subscriber;

/**
 * Created by LiuLei on 2017/11/27.
 */

public class UploadPresenter extends LoadEveryLogicImpl implements UploadContract{
    @Override
    public void onUpload(File file, String token) {

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("token", RequestBody.create(MediaType.parse("text/plain"),token));
        map.put("client_id", RequestBody.create(MediaType.parse("text/plain"),"0c313613013040acae32f088b069932a"));
        map.put("device_name", RequestBody.create(MediaType.parse("text/plain"),"傻了"));
        map.put("device_header", RequestBody.create(MediaType.parse("text/plain"),"device_header"));

        RequestBody requestBody= RequestBody.create(MediaType.parse("image/jpeg"),file);
        MultipartBody.Part part= MultipartBody.Part.createFormData("device_header", file.getName(), new ProgressRequestBody(requestBody,
                new UploadProgressListener() {
                    @Override
                    public void onProgress(long currentBytesCount, long totalBytesCount) {
//                        tvMsg.setText("提示:上传中");
//                        progressBar.setMax((int) totalBytesCount);
//                        progressBar.setProgress((int) currentBytesCount);
                    }
                }));
        JerryRetrofit.getInstance().uploadImg(part,map, new Subscriber<BaseResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("上传头像出错");
            }

            @Override
            public void onNext(BaseResponse baseResponse) {
                onLoadCompleteData(baseResponse);
            }
        });

    }
}

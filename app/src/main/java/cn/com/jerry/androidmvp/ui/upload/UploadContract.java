package cn.com.jerry.androidmvp.ui.upload;

import java.io.File;

import cn.com.jerry.mvplib.annotation.Implement;

/**
 * Created by LiuLei on 2017/11/27.
 */
@Implement(UploadPresenter.class)
public interface UploadContract {
    //上传
    void onUpload(File file, String token);
}

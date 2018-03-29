package cn.com.jerry.androidmvp.ui.upload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.jerry.androidmvp.R;
import cn.com.jerry.androidmvp.utils.ToastUtil;
import cn.com.jerry.mvplib.base.BaseActivity;
import cn.com.jerry.mvplib.base.model.LoadEveryLogic;

public class UploadActivity extends BaseActivity implements LoadEveryLogic.LoadEveryView{

    @BindView(R.id.imageView)
    ImageView mImg;
    private String mToken;
    private File mFile;
    private UploadPresenter mPresenter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_upload;
    }

    @Override
    protected void onInitView() {
        mToken = getIntent().getStringExtra("token");
        mPresenter = getBaseImpl(UploadContract.class, this);
    }

    @OnClick(R.id.upload_picture)
    void upload(){
        mFile=new File("/storage/emulated/0/11.jpg");

        mPresenter.onUpload(mFile,mToken);
//        Album.album(this)
//                .requestCode(999) // Request code.
//                .toolBarColor(getResources().getColor(R.color.albumColorPrimary)) // Toolbar color.
//                .statusBarColor(getResources().getColor(R.color.albumColorPrimary)) // StatusBar color.
//                .navigationBarColor(getResources().getColor(R.color.albumColorPrimary)) // NavigationBar color.
//                .title("Album") // Title.
//
//                .selectCount(9) // Choose up to a few pictures.
//                .columnCount(2) // Number of albums.
//                .camera(true) // Have a camera function.
//                .checkedList(mImageList) // Has selected the picture, automatically select.
//                .start();
    }

    @Override
    public void onLoadComplete(Object body) {
        Bitmap bitmap = BitmapFactory.decodeFile(mFile.getAbsolutePath());
        mImg.setImageBitmap(bitmap);
    }

    @Override
    public void onLoadFailer(String msg) {
        ToastUtil.show("上传头像失败");
    }
}

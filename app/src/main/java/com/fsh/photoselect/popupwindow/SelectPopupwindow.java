package com.fsh.photoselect.popupwindow;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.fsh.photoselect.R;
import com.fsh.photoselect.core.CameraProxy;
import com.fsh.photoselect.core.PhotoCallback;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class SelectPopupwindow extends PopupWindow implements View.OnClickListener{
    private View mRootView;
    private Button mTakePicButton,mGetPicFromAlbum,mCancleButton;
    private boolean isCrop;
    private CameraProxy proxy;
    private String photoDir;
    public SelectPopupwindow(Activity activity, boolean isCrop, String dir,PhotoCallback callback){
        initData(activity,isCrop,dir,callback);
        initView(activity);
        initEvent();
        initPopupwindow();
    }

    private void initData(Activity activity,boolean isCrop, String dir,PhotoCallback callback){
        this.isCrop = isCrop;
        this.photoDir = dir;
        proxy = new CameraProxy(callback,activity);
    }

    private void initView(Activity activity){
        mRootView = LayoutInflater.from(activity).inflate(R.layout.popupwindow_photo_select,null,false);
        mTakePicButton = (Button) mRootView.findViewById(R.id.btn_carmera);
        mGetPicFromAlbum = (Button) mRootView.findViewById(R.id.btn_album);
        mCancleButton = (Button) mRootView.findViewById(R.id.btn_cancle);
    }

    private void initEvent(){
        mTakePicButton.setOnClickListener(this);
        mGetPicFromAlbum.setOnClickListener(this);
        mCancleButton.setOnClickListener(this);
    }

    private void initPopupwindow(){
        //设置SelectPicPopupWindow的View  
        this.setContentView(mRootView);
        //设置SelectPicPopupWindow弹出窗体的宽  
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高  
       this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
       //设置SelectPicPopupWindow弹出窗体可点击  
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果  
        this.setAnimationStyle(R.style.AnimBottom);
        //实例化一个ColorDrawable颜色为半透明  
        ColorDrawable dw = new ColorDrawable(0x50000000);
        //设置SelectPicPopupWindow弹出窗体的背景  
        this.setBackgroundDrawable(dw);
    }

    public CameraProxy getProxy(){
        return this.proxy;
    }

    public void show(){
        this.showAtLocation(mRootView, Gravity.BOTTOM,0,0);
    }

    @Override
    public void onClick(View v) {
        String filePath = photoDir+new Date().getTime()+".jpg";
        switch (v.getId()){
            case R.id.btn_carmera:
                if (isCrop)
                    proxy.getPhotoFromCameraCrop(filePath);
                else
                    proxy.getPhotoFromCamera(filePath);
                break;
            case R.id.btn_album:
                if (isCrop)
                    proxy.getPhotoFromAlbumCrop(filePath);
                else
                    proxy.getPhotoFromAlbum(filePath);
                break;
            case R.id.btn_cancle:
                break;
        }
        this.dismiss();
    }
}

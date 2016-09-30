package com.fsh.photoselect;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;

import com.fsh.photoselect.core.PhotoCallback;
import com.fsh.photoselect.popupwindow.SelectPopupwindow;

import java.io.File;

public class PhotoSelectUtils {
    /**默认文件保存目录*/
    private String photoDir = Environment.getExternalStorageDirectory()
            + File.separator + "FSH" + File.separator + "photo" + File.separator;
    private Activity mActivity;
    private SelectPopupwindow pop;

    public PhotoSelectUtils(){}

    public PhotoSelectUtils(Activity activity,boolean isCrop,String dir,PhotoCallback callback){
        this.photoDir = dir;
        pop = new SelectPopupwindow(activity,isCrop,photoDir,callback);
    }

    public PhotoSelectUtils(Activity activity,boolean isCrop,PhotoCallback callback){
        pop = new SelectPopupwindow(activity,isCrop,photoDir,callback);
    }

    /**
     * 设置文件保存目录
     * @param dir
     */
    public void setPhotoDir(String dir){
        photoDir = dir;
    }

    public String getPhotoDir(){
        return photoDir;
    }

	/**
     * 调用系统相机或系统相册获取图片
     */
    public void getPhoto(){
        pop.show();
    }

    public void onResult(int requestCode, int resultCode, Intent data){
        this.pop.getProxy().onResult(requestCode,resultCode,data);
    }
}

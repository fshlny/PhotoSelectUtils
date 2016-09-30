package com.fsh.photoselect.core;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class CameraProxy{
    private CameraCore cameraCore;

    public CameraProxy(PhotoCallback cameraResult,Activity activity){
        cameraCore = new CameraCore(cameraResult,activity);
    }

    public Uri getPhotoUri(){
        return cameraCore.getPhotoUri();
    }

    public void setPhotoUri(Uri uri){
        cameraCore.setPhotoUri(uri);
    }

    /**
     * 调用系统相机拍照
     * @param filePath
     */
    public void getPhotoFromCamera(String filePath){
        File outputImg = new File(filePath);
        if (outputImg.exists()){
            outputImg.delete();
        }
        try {
            outputImg.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri uri = Uri.fromFile(outputImg);
        cameraCore.getPhotoFromCamera(uri);
    }

    /**
     * 调用系统相机拍照，并对拍照后的图片裁剪
     * @param filePath
     */
    public void getPhotoFromCameraCrop(String filePath){
        File outputImg = new File(filePath);
        if (outputImg.exists()){
            outputImg.delete();
        }
        try {
            outputImg.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri uri = Uri.fromFile(outputImg);
        cameraCore.getPhotoFromCameraCrop(uri);
    }

    /**
     * 从系统相册获取照片
     * @param filePath
     */
    public void getPhotoFromAlbum(String filePath){
        Uri uri = Uri.fromFile(new File(filePath));
        cameraCore.getPhotoFromAlbum(uri);

    }
    /**
     * 从系统相册获取照片,并对图片剪切
     * @param filePath
     */
    public void getPhotoFromAlbumCrop(String filePath){
        Uri uri = Uri.fromFile(new File(filePath));
        cameraCore.getPhotoFromAlbumCrop(uri);

    }

    /**
     * 核心图片处理
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onResult(int requestCode, int resultCode, Intent data){
        cameraCore.onResult(requestCode,resultCode,data);
    }
}

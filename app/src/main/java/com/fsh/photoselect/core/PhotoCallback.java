package com.fsh.photoselect.core;

/**
 * Created by Administrator on 2016/6/12 0012.
 */
public interface PhotoCallback{
   void onSuccess(String filePath,int requestId);

   void onFail(String message,int requestId);
}
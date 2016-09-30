package com.fsh.photoselect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fsh.photoselect.core.PhotoCallback;

public class MainActivity extends AppCompatActivity implements PhotoCallback{
    private PhotoSelectUtils api;
    private TextView mResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResult = (TextView) findViewById(R.id.result);
        api = new PhotoSelectUtils(this,false,this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        api.onResult(requestCode,resultCode,data);
    }

    public void getPhoto(View view){
        api.getPhoto();
    }



    @Override
    public void onSuccess(String filePath, int requestId) {
        mResult.setText("获取图片成功,图片地址为：\n"+filePath);
    }

    @Override
    public void onFail(String message, int requestId) {
        mResult.setText("获取图片失败,失败原因：\n"+message);
    }
}

package com.rabbi.examplemodels.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rabbi.examplemodels.R;
import com.rabbi.examplemodels.common.base.BaseActivity;

/**
 * 1.实现 handle.callback
 * 2.new Handle(this)
 */
public class HomeActivity extends BaseActivity implements Handler.Callback {
    private final Handler handler = new Handler(this); //create handler
    @Override
    protected int setLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initWidget() {
    findViewById(R.id.tvHelloWorld).setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case 0:
                showToast(String.valueOf(msg.obj));
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvHelloWorld :
            handler.obtainMessage(0,"this is test handle").sendToTarget();
            break;

        }
    }
}

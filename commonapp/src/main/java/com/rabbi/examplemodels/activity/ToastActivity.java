package com.rabbi.examplemodels.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rabbi.examplemodels.R;
import com.rabbi.examplemodels.common.base.BaseActivity;
//算法存在问题
public class ToastActivity extends BaseActivity {


    private static final String TAG = "ToastActivity";
    TextView tvMsg;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_toast;
    }

    @Override
    protected void initWidget() {
        showToast("居中Toast",Toast.LENGTH_SHORT);
        tvMsg= (TextView) findViewById(R.id.tv_msg);
        textParam("aaaaa","bbbbbb","ccccc","ddddd","eeeee","ffffff");
    }

    @Override
    public void onClick(View v) {

    }

    public void textParam(String... a){
        String str1="",str2="",strTmp="";
        for (int i = 0; i < a.length; i++) {
            if (i/2>0){
                Log.d(TAG,"i'm param one>>>"+a[i]);
                str1=a[i];
            }else {
                Log.e(TAG,"i'm param two>>>"+a[i]);
                str2=a[i];
            }
            Log.e(TAG,"str1,str2:"+str1+"|"+str2);
            strTmp+="\nstr1,str2:"+str1+"|"+str2;
        }
            tvMsg.setText(strTmp);
    }
}

package com.rabbi.examplemodels.common.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _init();
    }

   void _init(){
       setContentView(setLayoutId());
       initWidget();
       initDatas();
   }

    protected abstract int setLayoutId();

    protected  void initDatas(){

    };

    protected abstract void initWidget();

    protected void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }
}

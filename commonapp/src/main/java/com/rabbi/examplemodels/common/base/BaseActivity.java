package com.rabbi.examplemodels.common.base;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.rabbi.examplemodels.R;
import com.rabbi.examplemodels.common.widget.CustomProgressDialog;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _init();
    }

    void _init() {
        setContentView(setLayoutId());
        initWidget();
        initDatas();
    }

    protected abstract int setLayoutId();

    protected void initDatas() {

    }

    ;

    protected abstract void initWidget();


    //UI 提示 ---->>>>
    protected CustomProgressDialog mProgress;
    protected CustomProgressDialog mProgressFile;

    public void showProgress(int resId, boolean cancel) {
        mProgress = new CustomProgressDialog(this);
        if (resId <= 0) {
            mProgress.setMessage(R.string.loading_data, cancel);
        } else {
            mProgress.setMessage(resId, cancel);
        }
        mProgress.show();
    }

    public void cancelProgress() {
        if (mProgress != null) {
            mProgress.dismiss();
        }
    }

    public boolean progressIsShow() {
        if (mProgress != null) {
            return mProgress.isShowing();
        }
        return false;
    }

    public static final int MSG_CLOSE_PROGRESS = 0x01;
    public static final int MSG_SHOW_TOAST = 0x02;

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    Toast toast = null;
    public Handler baseHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_CLOSE_PROGRESS:
                    cancelProgress();
                    break;
                case MSG_SHOW_TOAST:
                    int resid = msg.arg1;
                    if (resid > 0) {
                        showToast(resid);
                    } else if (msg.obj != null) {
                        String mes = (String) msg.obj;
                        if (!TextUtils.isEmpty(mes)) {
                            showToast(mes);
                        }
                    }
                    break;
            }
        }

        ;
    };

    /**
     * 2秒toast
     *
     * @param resid
     */
    protected void showToast(int resid) {
        if (toast != null) {
            return;
        }
        toast = Toast.makeText(this, resid, Toast.LENGTH_SHORT);
        toast.show();
        baseHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (toast != null) {
                    toast.cancel();
                    toast = null;
                }
            }
        }, 2000);
    }


    /**
     *居中toast
     * @param message String
     * @param length
     */
    protected void showToast(String message, int length) {
        Toast toast = Toast.makeText(this, message, length);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     *居中toast
     * @param resid int
     * @param length
     */
    protected void showToast(int resid, int length) {
        Toast toast = Toast.makeText(this, resid, length);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    ////<<<<<<------ toast end

    ///------>>>>> strActivity

    protected Intent startAtvParam(Class cls) {
        return new Intent(this, cls);
    }

    /**
     * 多String 参数配置跳转
     * @param cls
     * @param key
     * @return
     */
    protected Intent startAtvParam (Class cls,String... key) {
//        String str1="",str2="";
        Intent intent = startAtvParam(cls);
        for (int i = 0; i < key.length; i+=2) {
            intent.putExtra(key[i],key[i+1]);
        }
        return intent;
    }


    /**
     * @Description: TODO
     * @param cls
     * @return void
     * @throws
     */
    protected void startAtv(Class cls) {
        startActivity(startAtvParam(cls));
    }

    /**
     *
     * @Description: TODO
     * @param cls
     * @param key
     * @param id
     * @return void
     * @throws
     */
    protected void startAtv(Class cls, String key, String id) {
        startActivity(startAtvParam(cls,key,id));
    }

    /**
     *
     * @param cls
     * @param key
     * @param id
     * @param key2
     * @param id2
     */
    protected void startAtv  (Class cls, String key, String id, String key2,
                            String id2) {
        if (TextUtils.isEmpty(key)||TextUtils.isEmpty(id)||TextUtils.isEmpty(key2)||TextUtils.isEmpty(id2)) {
            showToast("参数异常，请检查传递参数");
            return;
        }
        startActivity(startAtvParam(cls,key,id,key2,id2));
    }

///<<<<<----strActivity end


}

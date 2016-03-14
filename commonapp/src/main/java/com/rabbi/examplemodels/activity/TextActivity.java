package com.rabbi.examplemodels.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rabbi.examplemodels.R;
import com.rabbi.examplemodels.common.base.BaseTmpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextActivity extends BaseTmpActivity {
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.bt_show)
    Button btShow;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_text);
//    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_text;
    }

    @Override
    protected void initWidget() {
        ButterKnife.bind(this);
    }


    @OnClick({R.id.et_name, R.id.bt_show})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_name:
                break;
            case R.id.bt_show:
                break;
        }
    }
}

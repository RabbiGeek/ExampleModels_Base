package com.rabbi.examplemodels.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rabbi.examplemodels.R;

/**
 * Created by Rabbi on 3/9/16.
 * 自定义Image和textView 的组合控件
 */
public class FlexImageButton extends LinearLayout {

    private ImageView imageView;
    private TextView textView;
    private CharSequence text;
    private Drawable drawable;
    private float textSize;

    public FlexImageButton(Context context) {
        super(context);
    }

    public FlexImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FlexImageButton);
        text = a.getText(R.styleable.FlexImageButton_text);
        if(text==null){
            text="";
        }
        Drawable d = a.getDrawable(R.styleable.FlexImageButton_src);
        if (d != null) {
            drawable=d;
        } else {
            throw new RuntimeException("图像资源为空");
        }

        textSize = a.getDimension(R.styleable.FlexImageButton_textSize,12);
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.flex_image_button_layout, this);
        imageView = (ImageView) findViewById(R.id.icon_part);
        imageView.setImageDrawable(drawable);

        textView = (TextView) findViewById(R.id.text_part);
        textView.setTextSize((float) textSize);
        textView.setText(text);
        if(text.equals("")||text==null){
            textView.setVisibility(View.GONE);
        }
        a.recycle();
    }

    public void setImageResource(int resId) {
        imageView.setImageResource(resId);
    }
    public void setTextViewText(String text) {
        textView.setText(text);
    }

}

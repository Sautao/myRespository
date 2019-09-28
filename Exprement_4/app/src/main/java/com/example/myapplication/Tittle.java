package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Tittle extends ConstraintLayout {
    public Tittle(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tittle,this);

        Button button1=findViewById(R.id.title_back);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        Button button2=findViewById(R.id.title_exit);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //退出功能与返回有重复，用toast替代。
                Toast.makeText(getContext(),"you cilcked exit",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

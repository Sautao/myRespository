package com.example.exprement_5;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ForceOffLineReceiver receiver;
    private OutGoingCallReceiver outGoingCallReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActicityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActicityCollector.removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        //在过滤器中添加自定义广播，与发出的自定义广播action对应
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE");
        //添加android自带的电话外拨广播
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");

        receiver=new ForceOffLineReceiver();
        //动态注册广播接收器
        registerReceiver(receiver,intentFilter);
        registerReceiver(outGoingCallReceiver,intentFilter);
    }
    @Override
    protected void onPause() {
        super.onPause();
        //手动取消注册广播监听器，否则会一直存在于系统中
        unregisterReceiver(receiver);
        unregisterReceiver(outGoingCallReceiver);
    }
}


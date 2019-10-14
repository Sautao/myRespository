package com.example.exprement_5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OutGoingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //清楚拦截到的外拨电话号码，实现拦截功能。
        setResultData(null);
    }
}

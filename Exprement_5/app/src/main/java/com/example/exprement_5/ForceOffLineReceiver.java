package com.example.exprement_5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

/*
    接收强迫下线的广播并实现强迫下线的功能

 */

public class ForceOffLineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(context);
        dialog.setCancelable(false);
        dialog.setTitle("Force to off line.");
        dialog.setMessage("You have no choice");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                ActicityCollector.finshAll();
            }
        });
        dialog.show();


    }

}

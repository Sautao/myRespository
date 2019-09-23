package com.example.exprement_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
//    定于两个字符串变量用于储存用户名以及密码。
    private String registerName = "admin";
    private String registerPassword = "admin";
//    private String emailAddress="admin";

    //progressBar demo
    private ProgressBar progressBar;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK)
                registerName=data.getStringExtra("et_registName");
                registerPassword=data.getStringExtra("et_registPassword");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView imageView = (ImageView) findViewById(R.id.image_loginView);

        //当登陆按钮时，验证两个editText中的数据与注册时的用户密码是否匹配，
        final EditText loginName = (EditText) findViewById(R.id.text_username);
        final EditText loginPassword = (EditText) findViewById(R.id.text_password);
        Button button1 = (Button) findViewById(R.id.btn_login);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginName.getText().toString().equals(registerName)
                        && loginPassword.getText().toString().equals(registerPassword)) {
                    //用tomast输出是否登陆成功
                    Toast.makeText(LoginActivity.this, "登陆成功！",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登陆失败！",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });


        //function of registerbutton!!!

        Button button2=(Button)findViewById(R.id.btn_toRegister);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,1);
            }
        });


        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        Button button3=(Button)findViewById(R.id.btn_controlprogressBar);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(progressBar.getVisibility()==View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                }

                int progress=progressBar.getProgress();
                progress+=10;
                progressBar.setProgress(progress);

//                AlertDialog.Builder dialog=new AlertDialog.Builder(LoginActivity.this);
//                dialog.setTitle("This Dialog");
//                dialog.setMessage("important");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.show();

                ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this);
                progressDialog.setTitle("just wait");
                progressDialog.setMessage("waitting...");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });

    }
}

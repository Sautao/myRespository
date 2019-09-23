package com.example.exprement_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private String registName="admin1";
    private String registAddress="admin1";
    private String registPwd="admin1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText retTxt_name=(EditText)findViewById(R.id.edtTxt_regisitName);
        final EditText retTxt_address=(EditText)findViewById(R.id.edtTxt_regisitAddress);
        final EditText retTxt_password=(EditText)findViewById(R.id.edtTxt_regisitPassword);

        Button button1=(Button)findViewById(R.id.btn_register);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registName=retTxt_name.getText().toString();
                registAddress=retTxt_address.getText().toString();
                registPwd=retTxt_password.getText().toString();
                Toast.makeText(RegisterActivity.this,"注册成功！！！",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //跳转到登陆界面
        Button button2=(Button)findViewById(R.id.btn_toLogin);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                Intent intent=new Intent();
                intent.putExtra("et_registName",registName);
                intent.putExtra("et_regiseAddress",registAddress);
                intent.putExtra("et_registPassword",registPwd);
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
}

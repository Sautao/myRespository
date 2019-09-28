package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    //重写itemOnClick方法
    // 使用dialog工具
    // 实现点击item显示放大的图片
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//    }

    List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>() {
    };

    //讲数据存入集合框架中
    protected void studentInit() {
        Map<String, Object> map;
        for (int i = 0; i < 5; i++) {
            map = new HashMap<String, Object>() {
            };
            map.put("logo", R.drawable.student1_pic);
            map.put("name", "Mike");
            mapList.add(map);

            map = new HashMap<String, Object>() {
            };
            map.put("logo", R.drawable.student2_pic);
            map.put("name", "John");
            mapList.add(map);

            map = new HashMap<String, Object>() {
            };
            map.put("logo", R.drawable.student3_pic);
            map.put("name", "Tom");
            mapList.add(map);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.lv);
        //初始化数据
        studentInit();

        //获取系统默认的actionBar标题对象，如果标题存在就调用hide（）方法将其隐藏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
//        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
//                mapList, R.layout.item,
//                new String[]{"logo", "name"},
//                new int[]{R.id.logo, R.id.name}
//        );
//        listView.setAdapter(simpleAdapter);

        final MyAdapter myAdapter = new MyAdapter(MainActivity.this);
        myAdapter.setList(mapList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(MainActivity.this, R.style.edit_AlertDialog_style);
                dialog.setContentView(R.layout.mydialog);
                dialog.show();
                dialog.setCanceledOnTouchOutside(true);//点击空白处退出

                ImageView imageView = dialog.findViewById(R.id.dialog_View);
                //通过psition找到目标item项，并通过map集合的key值取出相应的图片id
                imageView.setImageResource((Integer) mapList.get(position).get("logo"));
                dialog.show();
            }
        });
        listView.setAdapter(myAdapter);

    }
}

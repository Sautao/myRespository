package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> studentList=new ArrayList<>();

    private void initStudent(){
        for(int i=0;i<3;i++){
            //同一条内容添加多次
             Student student1=new Student("mike",R.drawable.student1_pic);
            studentList.add(student1);
            Student student2=new Student("john",R.drawable.student2_pic);
            studentList.add(student2);
            Student student3=new Student("wuyifan",R.drawable.student3_pic);
            studentList.add(student3);



//             studentList.add(new Student("john",R.drawable.student2_pic));
//             studentList.add(new Student("amy0",R.drawable.student3_pic));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initStudent();
        StudentAdapter adapter=new StudentAdapter(MainActivity.this,R.layout.student_item,studentList);

        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
}

package com.example.uitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private int resourceId;

    public StudentAdapter(@NonNull Context context, int textViewResourceId, List<Student> objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Student student=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        ImageView studentImage=(ImageView) view.findViewById(R.id.student_image);
        TextView studentName=(TextView)view.findViewById(R.id.student_name);

        studentImage.setImageResource(student.getImageId());
        studentName.setText(student.getName());
        return view;
    }
}

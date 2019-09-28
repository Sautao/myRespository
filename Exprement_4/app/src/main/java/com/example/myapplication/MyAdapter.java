package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    List<Map<String,Object>> list;
    LayoutInflater inflater;

    public MyAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public MyAdapter(Context context) {
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(R.layout.item,null);

        ImageView logo=view.findViewById(R.id.logo);
        TextView name=view.findViewById(R.id.name);

        Map map=list.get(position);
        logo.setImageResource((Integer)map.get("logo"));
        name.setText((String) map.get("name"));

        return view;
    }
}

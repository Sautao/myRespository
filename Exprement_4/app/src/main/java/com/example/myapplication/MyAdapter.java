package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    private List<Map<String, Object>> list;
    private LayoutInflater inflater;
    private Context context;

    public MyAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public MyAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = getContext(context);
    }


    private  Context getContext(Context context) {
        return context;
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

        View view;
        ViewHolder viewHolder;
        //适配器优化一
        if (convertView == null) {
            //当converView为null，即第一次加载item布局时，利用反射器加载一个item布局并赋于view
            view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.logo = view.findViewById(R.id.logo);
            viewHolder.name = view.findViewById(R.id.name);
            view.setTag(viewHolder);
        } else {
            //当converView不为null，
            // 由于使用同一个item布局故重用converView，提高效率
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        //定义一个map用于接收当前的item实例



        //此处与书本上定义一个Fruit类有区别
        //可进行修改增加易读性！！！！！！！！！！！！！！！！
        Map map = list.get(position);
        viewHolder.logo.setImageResource((Integer)map.get("logo"));
        viewHolder.name.setText((String)map.get("name"));

        //优化后弃用原来的方法
//        ImageView logo = view.findViewById(R.id.logo);
//        TextView name = view.findViewById(R.id.name);
//
//        logo.setImageResource((Integer) map.get("logo"));
//        name.setText((String) map.get("name"));

        return view;
    }

    class ViewHolder {
        ImageView logo;
        TextView name;
    }
}

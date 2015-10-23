package com.game.snda.gameassistant.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by zoubaolin on 15/10/22.
 * 构造一个通用性的Adapter
 * params T: adapter中绑定的数据类型
 * params TItemView: adapter中绑定数据项的视图
 */
public abstract class MyArrayAdapter<T, TItemView extends ItemView<T>> extends ArrayAdapter<T>{

    public MyArrayAdapter(Context context) {
        super(context, 0);
    }

    public MyArrayAdapter(Context context, List<T> objects) {
        super(context, 0, objects);
    }

    public void bind(List<T> list) {
        bind(list, false);
    }

    public void bind(List<T> list , boolean doClear) {
        if (doClear)
            clear();
        addAll(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TItemView itemView;
        if (convertView == null) {
            itemView = build(getContext());
        } else {
            itemView = (TItemView)convertView;
        }
        itemView.bind(getItem(position));
        return (View)itemView;
    }

    public void addAll(List<T> list) {
        for (T t : list) {
            add(t);
        }
    }

    protected abstract TItemView build(Context context);
}

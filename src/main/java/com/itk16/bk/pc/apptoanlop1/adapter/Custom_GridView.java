package com.itk16.bk.pc.apptoanlop1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.itk16.bk.pc.apptoanlop1.R;
import com.itk16.bk.pc.apptoanlop1.model.ItemImage;


import java.util.ArrayList;


public class Custom_GridView  extends ArrayAdapter<ItemImage>{
    private  Context context;
    private int Item;
    private ArrayList<ItemImage> arrA;
    private int i;
    public Custom_GridView(@NonNull Context context, int resource, @NonNull ArrayList<ItemImage> objects, int i) {
        super(context, resource, objects);
        this.context=context;
        this.Item= resource;
        this.arrA= objects;
        this.i= i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_anh, parent, false);
        ItemImage IA= arrA.get(position);
        ImageView IM=(ImageView)convertView.findViewById(R.id.IM);
        IM.setImageResource(i);
        return convertView;
    }
}

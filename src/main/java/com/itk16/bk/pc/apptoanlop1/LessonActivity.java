package com.itk16.bk.pc.apptoanlop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.itk16.bk.pc.apptoanlop1.adapter.CustomAdapter;
import com.itk16.bk.pc.apptoanlop1.model.Lesson;


import java.util.ArrayList;
import java.util.HashMap;

public class LessonActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_back;
    private ListView listView;
    private Integer chuong;
    CustomAdapter customAdapter;
    private static HashMap map = new HashMap<Integer, Integer>();
    private ArrayList<Lesson> ArrayLesson=new ArrayList<>();
    static {
        map.put(1, R.layout.activity_bai1);
        map.put(2, R.layout.activity_bai2);
        map.put(3, R.layout.activity_bai3);
        map.put(4, R.layout.activity_bai4);
        map.put(5, R.layout.activity_bai5);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chuong = getIntent().getIntExtra("chuong", -1);
        setContentView((Integer)map.get(chuong));
        loadData();
        init();
        setevent();
        customAdapter = new CustomAdapter(LessonActivity.this,R.layout.item,ArrayLesson, chuong);
        listView.setAdapter(customAdapter);

    }
    public void init()
    {
        bt_back=(Button)findViewById(R.id.nut_thoat);
        listView=(ListView)findViewById(R.id.lv);
    }
    public void setevent()
    {
        bt_back.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == 1){
                int sao = data.getIntExtra("sao",-1);
                Toast.makeText(this, "duoc "+sao, Toast.LENGTH_SHORT).show();
                ArrayLesson.get(0).setmNumberStar(3);
                customAdapter.notifyDataSetChanged();
            }
            if(resultCode == 2){
                int sao = data.getIntExtra("sao",-1);
                Toast.makeText(this, "duoc"+sao, Toast.LENGTH_SHORT).show();
            }
            if(resultCode == 3){
                int sao = data.getIntExtra("sao",-1);
                Toast.makeText(this, "dươc"+sao, Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
                case R.id.nut_thoat:
                finish();
                break;
        }
    }
    public void loadData()
    {
        ArrayLesson.add(new Lesson("Bài 1", false,1,0));
        ArrayLesson.add(new Lesson("Bài 2", false,2,0));
        ArrayLesson.add(new Lesson("Bài 4", true,4,0));
        ArrayLesson.add(new Lesson("Bài 3", false,3,0));
        ArrayLesson.add(new Lesson("Bài 5", true,5,0));
    }
}


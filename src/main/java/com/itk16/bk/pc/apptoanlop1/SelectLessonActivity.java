package com.itk16.bk.pc.apptoanlop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectLessonActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt_back;
    private Button  bt1;
    private Button  bt2;
    private Button  bt3;
    private Button  bt4;
    private Button  bt5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectlesson);
        khaibao();
        setevnet();
    }
    public void khaibao()
    {
        bt_back = findViewById(R.id.bt_back);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);

        bt1.setTag(1);
        bt2.setTag(2);
        bt3.setTag(3);
        bt4.setTag(4);
        bt5.setTag(5);
    }
    public void setevnet()
    {
        bt_back.setOnClickListener((View.OnClickListener) this);
        bt1.setOnClickListener((View.OnClickListener) this);
        bt2.setOnClickListener((View.OnClickListener) this);
        bt3.setOnClickListener((View.OnClickListener) this);
        bt4.setOnClickListener((View.OnClickListener) this);
        bt5.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bt_back) {
            finish();
            return;
        }
        int chuong = (int)v.getTag();
        Intent intent =new Intent(SelectLessonActivity.this, LessonActivity.class);
        intent.putExtra("chuong", chuong);
        startActivity(intent);
    }

}

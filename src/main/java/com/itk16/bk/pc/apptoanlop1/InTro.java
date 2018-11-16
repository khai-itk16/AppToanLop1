package com.itk16.bk.pc.apptoanlop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class InTro extends AppCompatActivity

{
    Timer timer =new Timer();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent gotomain = new Intent(InTro.this,StartActivity.class );
                startActivity(gotomain);
                finish();
            }
        },3000);
    }
}

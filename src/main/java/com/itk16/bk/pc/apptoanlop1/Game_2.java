package com.itk16.bk.pc.apptoanlop1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game_2 extends AppCompatActivity implements View.OnClickListener{
    private int lc;
    private Button btBack, btPause, btNext, btGreatThan, btItThan, btDegree;
    private TextView tvField1, tvField2, tvCountdown;
    private String field1, field2;
    private Intent intent;
    private int resuilt1,resuilt2 ;
    int d;
    int status;//da chon 1 dap an
    int sao=0;//tinh so cau dung
    int check;//kiem tra dung sai
    CountDownTimer timer;
    int numberQuestion=0;
    int N;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        init();
        kecha();
    }
    public void init()
    {
        intent = getIntent();
        lc = intent.getIntExtra("chuong", -1);
        switch (lc)
        {
            case 1:N=10;
            break;
            case 2: N=20;
            break;
            case 3:N=40;
            break;
            case 4: N=60;
            break;
            case 5:N=100;
            break;
        }
       btBack=(Button)findViewById(R.id.nut_thoat);
       btPause=(Button)findViewById(R.id.bt_dung);
       btNext=(Button)findViewById(R.id.next) ;
       btGreatThan=(Button)findViewById(R.id.bt_lonhon);
       btItThan=(Button)findViewById(R.id.bt_behon);
       btDegree=(Button)findViewById(R.id.bt_bang);

       tvCountdown=(TextView)findViewById(R.id.tv_countdown);
       tvField1=(TextView)findViewById(R.id.tv_ve1);
       tvField2=(TextView)findViewById(R.id.tv_ve2);

       btNext.setOnClickListener(this);
       btPause.setOnClickListener(this);
       btBack.setOnClickListener(this);
       btDegree.setOnClickListener(this);
       btGreatThan.setOnClickListener(this);
       btItThan.setOnClickListener(this);
    }
    public void kecha()
    {
        status=0;
        check=0;
        random(2);
        btItThan.setBackgroundResource(R.drawable.be);
        btGreatThan.setBackgroundResource(R.drawable.lon);
        btDegree.setBackgroundResource(R.drawable.dau_bang);
        tvField1.setText(field1);
        tvField2.setText(field2);
         timer= new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvCountdown.setText("00:"+millisUntilFinished/1000+"");
            }
            @Override
            public void onFinish() {
                tvCountdown.setText("Hết giờ");
                status=1;
            }
        }.start();
    }

     public void Check()
     {
         if(status==0)
         {
             sao+=1;
             check=1;
             status=1;
         }
     }
    public void random(int i)
    {
        Random rd= new Random();
        switch (i)
        {
            case 1:
                resuilt1=rd.nextInt(N-1)+1;
                resuilt2=rd.nextInt(N-1)+1;
                field1=resuilt1+"";
                field2=resuilt2+"";
                break;
            case 2:
                int c;
                c=rd.nextInt(2);
                if(c==0)
                {
                    int i1, i2;
                    resuilt1=rd.nextInt(N-1)+1;
                    resuilt2=rd.nextInt(N-1)+1;
                    i1= rd.nextInt(resuilt1-1)+1;
                    i2=resuilt1-i1;
                    field1=i1+" + "+i2+"";
                    field2=resuilt2+"";
                }else {
                    int i1, i2;
                    resuilt1=rd.nextInt(N-1)+1;
                    resuilt2=rd.nextInt(N-1)+1;
                    i1= rd.nextInt(resuilt2-1)+1;
                    i2=resuilt2-i1;
                    field2=i1+" + "+i2+"";
                    field1=resuilt1+"";
                }
                break;
            case 3:
                int i1, i2;
                resuilt1=rd.nextInt(N-1)+1;
                i1=rd.nextInt(resuilt1-1)+1;
                i2=resuilt1-i1;
                field1= i1+" + "+i2+"";
                resuilt2=rd.nextInt(N-1)+1;
                i1=rd.nextInt(resuilt2-1)+1;
                i2=resuilt2-i1;
                field2=i1+" + "+i2+"";
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_behon:
                if(resuilt1<resuilt2)
                {
                    btItThan.setBackgroundResource(R.drawable.bedung);
                    Check();
                    timer.cancel();
                }
                else
                {
                    btItThan.setBackgroundResource(R.drawable.besai);
                    status=1;
                }
                break;
            case R.id.bt_lonhon:
                if(resuilt1>resuilt2)
                {
                    btGreatThan.setBackgroundResource(R.drawable.londung);
                    Check();
                    timer.cancel();
                }
                else {
                    btGreatThan.setBackgroundResource(R.drawable.lonsai);
                    status=1;
                }
                break;
            case R.id.bt_bang:
                if(resuilt1==resuilt2)
                {
                    btDegree.setBackgroundResource(R.drawable.bangdung);
                    Check();
                    timer.cancel();
                }
                else {
                    btDegree.setBackgroundResource(R.drawable.bangsai);
                    status=1;
                }
                break;
            case R.id.next:

               if(status==1) {
                   timer.cancel();
                   if (numberQuestion < 10) {
                       kecha();
                       numberQuestion++;
                   } else
                       {
                           AlertDialog.Builder builder = new AlertDialog.Builder(this);
                           builder.setTitle("BẠN ĐÃ HOÀN THÀNH BÀI TẬP ");
                           builder.setMessage("Bạn đã trả lời đúng " + sao);
                           builder.setCancelable(false);
                           builder.setIcon(R.drawable.bt_quatao);
                           builder.setPositiveButton(
                                   "OK",
                                   new DialogInterface.OnClickListener() {
                                       public void onClick(DialogInterface dialog, int id) {
                                           intent.putExtra("sao", sao);
                                           setResult(2, intent);
                                           finish();
                                           dialog.cancel();
                                       }
                                   });
                           AlertDialog alertdialog = builder.create();
                           alertdialog.show();
                       }
               }
                else Toast.makeText(this, "BẠN PHẢI CHỌN ÍT NHẤT MỘT ĐÁP ÁN TRƯỚC KHI TIẾP TỤC",Toast.LENGTH_SHORT).show();
               break;
            case R.id.nut_thoat:
                finish();
                break;

        }
    }

}

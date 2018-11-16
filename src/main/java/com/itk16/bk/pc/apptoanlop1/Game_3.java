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
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.itk16.bk.pc.apptoanlop1.adapter.Custom_GridView;
import com.itk16.bk.pc.apptoanlop1.model.ItemImage;
import com.itk16.bk.pc.apptoanlop1.model.ListItemImage;


import java.util.ArrayList;
import java.util.Random;

public class Game_3 extends AppCompatActivity implements View.OnClickListener{
    private int chuong;
    private Button btResponse1,btResponse2, btResponse3, btResponse4,btNext, btBack, btPause;
    private TextView tvCountdown,tvQuestion;
    private GridView gridView;
    private Intent intent;
    private ListItemImage listItemImage;//danh sach anh
    int k;//bien k dung de tao bien ramdom tuong ung voi mot con so trong bai hoc
    int a;// a dung de random ra mot anh bat ky trong LITA
    String Question;//chua ten anh
    int[] Da={0,0,0,0};//mang dap an
    int da;//vi tri dap an dung
    CountDownTimer timer;
    private int status;
    private int star;
    private int check;
    int n=0;
    int N;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        init();
        kecha();
    }

    public void init()
    {

        btResponse1=(Button)findViewById(R.id.bt_da1);
        btResponse2=(Button)findViewById(R.id.bt_da2);
        btResponse3=(Button)findViewById(R.id.bt_da3);
        btResponse4=(Button)findViewById(R.id.bt_da4);
        btBack=(Button)findViewById(R.id.nut_thoat);
        btPause=(Button)findViewById(R.id.bt_pause);
        btNext=(Button)findViewById(R.id.next);
        tvCountdown=(TextView)findViewById(R.id.tv_countdown);
        tvQuestion=(TextView)findViewById(R.id.tv_Ch);
        intent = getIntent();
       chuong = intent.getIntExtra("chuong", -1);
        switch (chuong)
        {
            case 1: N=10;
            break;
            case 2: N=20;
            break;
            case 3:N=40;
            break;

        }
        gridView= (GridView)findViewById(R.id.gr_v);
        btResponse1.setOnClickListener(this);
        btResponse2.setOnClickListener(this);
        btResponse3.setOnClickListener(this);
        btResponse4.setOnClickListener(this);
        btBack.setOnClickListener(this);
        btPause.setOnClickListener(this);
        btNext.setOnClickListener(this);
        listItemImage= new ListItemImage();


    }
    public  void kecha()
    {
        btResponse1.setBackgroundResource(R.drawable.dapan);
        btResponse2.setBackgroundResource(R.drawable.dapan);
        btResponse3.setBackgroundResource(R.drawable.dapan);
        btResponse4.setBackgroundResource(R.drawable.dapan);
        random();
        btResponse1.setText(Da[0]+"");
        btResponse2.setText(Da[1]+"");
        btResponse3.setText(Da[2]+"");
        btResponse4.setText(Da[3]+"");
        status=0;
        check=0;
        ArrayList<ItemImage> item_images = new ArrayList<>();
        for (int i= 0; i<k;i++)
        {
            item_images.add(new ItemImage(listItemImage.getmArrImages().get(a).getmImageResource(),listItemImage.getmArrImages().get(a).getmImageName()));
        }
        Custom_GridView custom_gridView= new Custom_GridView(this, R.layout.item_anh, item_images, listItemImage.getmArrImages().get(a).getmImageResource());
        gridView.setAdapter(custom_gridView);


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
// -----------------------------------------
    public void random()
    {
        Random rd= new Random();
        a=rd.nextInt(listItemImage.getmArrImages().size());
        k= rd.nextInt(N);
        Question= "Có bao nhiêu "+listItemImage.getmArrImages().get(a).getmImageName()+" trong hình vẽ ?";
        tvQuestion.setText(Question);
        da=rd.nextInt(3);
        Da[da]=k;
        for (int i= 0; i<=3;i++)
        {
            if (i!=da)
            {
                do{
                    Da[i]=rd.nextInt(N);
                }while (Da[i]==k);
            }
        }

    }
    // ---------------------------------
    public void Check()
    {
        if(status==0)
        {
            check= 1;
            star+=1;
            status=1;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_da1:
                if(Da[0]==k)
                {
                    btResponse1.setBackgroundResource(R.drawable.dung);
                    Check();
                    timer.cancel();

                }
                else{
                    btResponse1.setBackgroundResource(R.drawable.sai);
                    status=1;
                }

                break;
            case R.id.bt_da2:
                if(Da[1]==k)
                {
                    btResponse2.setBackgroundResource(R.drawable.dung);
                    Check();
                    timer.cancel();
                }
                else {
                    btResponse2.setBackgroundResource(R.drawable.sai);
                    status=1;
                }
                break;
            case R.id.bt_da3:
                if(Da[2]==k)
                {
                    btResponse3.setBackgroundResource(R.drawable.dung);
                    Check();
                    timer.cancel();
                }
                else {
                    btResponse3.setBackgroundResource(R.drawable.sai);
                    status=1;
                }
                break;
            case R.id.bt_da4:
                if(Da[3]==k)
                {
                    btResponse4.setBackgroundResource(R.drawable.dung);
                    Check();
                    timer.cancel();
                }
                else {
                    btResponse4.setBackgroundResource(R.drawable.sai);
                    status=1;
                }
                break;
            case R.id.next:

                if(status==1)
                {
                    timer.cancel();
                    if(n<10)
                    {n++;
                    kecha();
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("BẠN ĐÃ HOÀN THÀNH BÀI TẬP ");
                        builder.setMessage("Bạn đã trả lời đúng " + star);
                        builder.setCancelable(false);
                        builder.setIcon(R.drawable.bt_quatao);

                        builder.setPositiveButton(
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        intent.putExtra("sao", star);
                                        setResult(3, intent);
                                        finish();
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alertdialog = builder.create();
                        alertdialog.show();
                    }
                }else Toast.makeText(this, "BẠN PHẢI CHỌN ÍT NHẤT MỘT ĐÁP ÁN TRƯỚC KHI TIẾP TỤC",Toast.LENGTH_SHORT).show();

                break;
            case R.id.nut_thoat:
                finish();
                break;
        }

    }

}

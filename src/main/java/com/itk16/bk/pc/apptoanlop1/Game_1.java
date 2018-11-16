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

import com.itk16.bk.pc.apptoanlop1.model.ListQuestions;
import com.itk16.bk.pc.apptoanlop1.model.Question;


public class Game_1 extends AppCompatActivity implements View.OnClickListener{

    private int lc;
    private ListQuestions mListquestions;
    TextView tvQuestion, tvCountdown;
    Button btQuestion1, btQuestion2, btQuestion3, btQuestion4, btPause,btBack,btNext;
    private int vt=0;
    private int sao=0;
    private int status;
    private int check;
    private Intent intent;
    CountDownTimer timer;
    int[] k= new int[]{0, 0, 0, 0};
      @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        init();
        kecha();
      }

    public void init()
    {

        intent = getIntent();
        lc = intent.getIntExtra("chuong", -1);
        mListquestions= new ListQuestions(lc);
        btNext=(Button)findViewById(R.id.next) ;
        btQuestion1= (Button)findViewById(R.id.bt_da1);
        btQuestion2= (Button)findViewById(R.id.bt_da2);
        btQuestion3= (Button)findViewById(R.id.bt_da3);
        btQuestion4= (Button)findViewById(R.id.bt_da4);
        btBack=(Button) findViewById(R.id.nut_thoat);
        btPause=(Button)findViewById(R.id.bt_pause) ;
        tvQuestion= (TextView)findViewById(R.id.tv_Ch);
        tvCountdown=(TextView)findViewById(R.id.tv_countdown);
        btQuestion1.setOnClickListener(this);
        btQuestion2.setOnClickListener(this);
        btQuestion3.setOnClickListener(this);
        btQuestion4.setOnClickListener(this);
        btNext.setOnClickListener(this);
        btBack.setOnClickListener(this);
        btPause.setOnClickListener(this);
    }
    public void kecha() {
        if (vt < mListquestions.getmListQuestions().size()){
            Question question = mListquestions.getmListQuestions().get(vt);
        check= 0;
        status=0;
        for (int i= 0; i< k.length; i++)
        {
            k[i]=0;
        }
        btQuestion1.setBackgroundResource(R.drawable.dapan);
        btQuestion2.setBackgroundResource(R.drawable.dapan);
        btQuestion3.setBackgroundResource(R.drawable.dapan);
        btQuestion4.setBackgroundResource(R.drawable.dapan);
        btQuestion1.setText(question.getmResponses().get(0).getmResponse());
        btQuestion2.setText(question.getmResponses().get(1).getmResponse());
        btQuestion3.setText(question.getmResponses().get(2).getmResponse());
        btQuestion4.setText(question.getmResponses().get(3).getmResponse());
        tvQuestion.setText(question.getQuestion());
        timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvCountdown.setText("00:" + millisUntilFinished/ 1000);
            }

            @Override
            public void onFinish() {
                tvCountdown.setText("Hết giờ");
                status=1;
            }
        }.start();
    }
    else {
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
                        setResult(1, intent);
                        finish();
                        dialog.cancel();
                    }
                });
            AlertDialog alertdialog = builder.create();
            alertdialog.show();
        }
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_da1:
                if(mListquestions.getmListQuestions().get(vt).getmResponses().get(0).isT())
                {
                    btQuestion1.setBackgroundResource(R.drawable.dung);
                    Check();
                  timer.cancel();
                }
                else
                {
                    btQuestion1.setBackgroundResource(R.drawable.sai);
                    status=1;
                }
                break;
            case R.id.bt_da2:
                if(mListquestions.getmListQuestions().get(vt).getmResponses().get(1).isT())
                {
                    btQuestion2.setBackgroundResource(R.drawable.dung);
                    Check();
                    timer.cancel();
                }
                else
                {
                    btQuestion2.setBackgroundResource(R.drawable.sai);
                    status=1;

                }
                break;
            case R.id.bt_da3:
                if(mListquestions.getmListQuestions().get(vt).getmResponses().get(2).isT())
                {
                    btQuestion3.setBackgroundResource(R.drawable.dung);
                    Check();
                    timer.cancel();
                }
                else
                {
                    btQuestion3.setBackgroundResource(R.drawable.sai);
                    status=1;
                }
                break;
            case R.id.bt_da4:
                if(mListquestions.getmListQuestions().get(vt).getmResponses().get(3).isT())
                {
                    btQuestion4.setBackgroundResource(R.drawable.dung);
                    Check();
                    timer.cancel();
                }
                else
                {
                    btQuestion4.setBackgroundResource(R.drawable.sai);
                    status=1;
                }
                break;
            case R.id.next:

               if(status==1)
               { timer.cancel();
               vt++;
                kecha();
               }else Toast.makeText(this, "BẠN PHẢI CHỌN ÍT NHẤT MỘT ĐÁP ÁN TRƯỚC KHI TIẾP TỤC",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nut_thoat:
                finish();
                break;
        }
    }





}

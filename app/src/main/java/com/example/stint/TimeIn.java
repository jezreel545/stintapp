package com.example.stint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeIn extends AppCompatActivity {

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;
    TextView GetDateAndTime, GetDateAndTime2;
    Button BtnTimeIn,BtnTimeOut;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_in);

        GetDateAndTime=findViewById(R.id.TimeInView);
        GetDateAndTime2=findViewById(R.id.TimeView);
        BtnTimeIn=findViewById(R.id.TimeInbtn);
        BtnTimeIn=findViewById(R.id.TimeOutbtn);
        calendar =Calendar.getInstance();
        simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date=simpleDateFormat.format(calendar.getTime());

        BtnTimeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetDateAndTime.setText(Date);
            }
        });

        BtnTimeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetDateAndTime.setText(Date);
            }
        });








    }
}
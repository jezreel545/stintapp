package com.example.stint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeOut extends AppCompatActivity {



    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;
    TextView GetDateAndTime;
    Button BtnTimeOut;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_out);

        GetDateAndTime=findViewById(R.id.TimeOutView);
        BtnTimeOut=findViewById(R.id.TimeOutbtn);
        calendar =Calendar.getInstance();
        simpleDateFormat= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        Date=simpleDateFormat.format(calendar.getTime());
        GetDateAndTime.setText(Date);


    }
}
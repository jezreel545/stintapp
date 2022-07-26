package com.example.stint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TimeIn extends AppCompatActivity {


    EditText registerfullname, registeremail;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;
    TextView GetDateAndTime,Timeinview;
    Button BtnTimeIn,BtnTimeOut;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_in);
        fAuth = FirebaseAuth.getInstance();
        Timeinview=findViewById(R.id.TimeInView);

        GetDateAndTime=findViewById(R.id.TimeInView);
        BtnTimeIn=findViewById(R.id.TimeInbtn);
        calendar =Calendar.getInstance();
        registerfullname = findViewById(R.id.registerfullname);
        registeremail = findViewById(R.id.registeremail);
        simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date=simpleDateFormat.format(calendar.getTime());





        BtnTimeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDateAndTime.setText(Date);
                Toast.makeText(TimeIn.this, "Punch", Toast.LENGTH_SHORT).show();



            }

        });
    }
}
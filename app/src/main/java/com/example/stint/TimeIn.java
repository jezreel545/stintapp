package com.example.stint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TimeIn extends AppCompatActivity {

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;
    TextView GetDateAndTime, GetDateAndTime2;
    Button BtnTimeIn,BtnTimeOut;
    FirebaseAuth auth;
    FirebaseFirestore fStore;

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
                FirebaseUser user = fAuth.getCurrentUser();
                DocumentReference df = fStore.collection("Users").document(user.getUid());
                Map<String,Object> userInfo = new HashMap<>();
                userInfo.put("Fullname",registerfullname.getText().toString());
                userInfo.put("UserEmail",registeremail.getText().toString());
            }
        });


    }
}
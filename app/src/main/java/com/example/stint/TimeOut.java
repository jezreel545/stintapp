package com.example.stint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class TimeOut extends AppCompatActivity {



    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;
    TextView GetDateAndTime;
    Button BtnTimeOut;
    FirebaseAuth fAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_out);

        GetDateAndTime=findViewById(R.id.TimeOutView);
        fAuth = FirebaseAuth.getInstance();
        BtnTimeOut=findViewById(R.id.TimeOutbtn);
        calendar =Calendar.getInstance();
        simpleDateFormat= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        Date=simpleDateFormat.format(calendar.getTime());

        BtnTimeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDateAndTime.setText(Date);
                Toast.makeText(TimeOut.this, "Punch", Toast.LENGTH_SHORT).show();
                FirebaseUser user = fAuth.getCurrentUser();
                DocumentReference df = FirebaseFirestore.getInstance().collection("Users").document(user.getUid());
                Map<String,Object> userInfo = new HashMap<>();
                userInfo.put("TimeOut", Date);

                df.update(userInfo);
            }
        });


    }
}
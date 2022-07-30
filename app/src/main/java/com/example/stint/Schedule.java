package com.example.stint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Schedule extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        button = (Button) findViewById(R.id.btn_schedule);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity_recycler_view();
            }
        });
    }
    public void openactivity_recycler_view(){
        Intent intent = new Intent(this, main_activity.class);
        startActivity(intent);
    }
}
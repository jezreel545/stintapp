package com.example.stint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView verifymsg;
    Button verifyEmailbtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button logout = findViewById(R.id.logoutbtn);
        auth = FirebaseAuth.getInstance();

        verifymsg = findViewById(R.id.verifyemailmsg);
        verifyEmailbtn = findViewById(R.id.verifyemailbtn);

        if (!auth.getCurrentUser().isEmailVerified()){
            verifyEmailbtn.setVisibility(View.VISIBLE);
            verifymsg.setVisibility(View.VISIBLE);
        }

        verifyEmailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send Email verification
                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Verification Email sent", Toast.LENGTH_SHORT).show();
                        verifyEmailbtn.setVisibility(View.GONE);
                        verifymsg.setVisibility(View.GONE);
                    }
                });
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.resetUserPassword){
            startActivity(new Intent(getApplicationContext(),Resetpassword.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
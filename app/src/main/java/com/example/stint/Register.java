package com.example.stint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText registerfullname,registeremail,registerpassword,registerconfpass;
    Button registeruserbtn,gotoLogin;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerfullname = findViewById(R.id.registerfullname);
        registeremail = findViewById(R.id.registeremail);
        registerpassword = findViewById(R.id.registerpassword);
        registerconfpass = findViewById(R.id.confpassword);
        registeruserbtn = findViewById(R.id.registerbtn);
        gotoLogin = findViewById(R.id.gotoLogin);

        fAuth = FirebaseAuth.getInstance();

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });

        registeruserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //extract the data
                String fullName = registerfullname.getText().toString();
                String email = registeremail.getText().toString();
                String password = registerpassword.getText().toString();
                String confpass = registerconfpass.getText().toString();

                if (fullName.isEmpty()){
                    registerfullname.setError("Full Name is Required");
                    return;
                }
                if (email.isEmpty()){
                    registeremail.setError("Email is Required");
                    return;
                }
                if (password.isEmpty()){
                    registerpassword.setError("Password is Required");
                    return;
                }
                if (confpass.isEmpty()){
                    registerconfpass.setError("Confirm password is Required");
                    return;
                }

                if (!password.equals(confpass)){
                    registerconfpass.setError("Password does not match");
                    return;
                }
                //data is validated
                //register the user in firebase\
                Toast.makeText(Register.this, "Data is Validated", Toast.LENGTH_SHORT).show();
                
                fAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //send user to next page
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
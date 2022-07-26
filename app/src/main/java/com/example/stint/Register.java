package com.example.stint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText registerfullname,registeremail,registerpassword,registerconfpass;
    Button registeruserbtn,gotoLogin;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    CheckBox isUser,isAdmin;
    boolean valid = true;
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
        isUser = findViewById(R.id.isUser);
        isAdmin = findViewById(R.id.isAdmin);


        // check boxes 1
        isUser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    isAdmin.setChecked(false);
                }
            }
        });
        isAdmin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    isUser.setChecked(false);
                }
            }
        });

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
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
                checkField(registerfullname);
                checkField(registeremail);
                checkField(registerpassword);
                checkField(registerconfpass);

                //checkbox validation
                if (!(isUser.isChecked() || isAdmin.isChecked())){
                    Toast.makeText(Register.this, "Select the account Type", Toast.LENGTH_SHORT).show();
                    return;
                }


                //data is validated
                //register the user in firebase\
                Toast.makeText(Register.this, "Data is Validated", Toast.LENGTH_SHORT).show();
                if (valid){
                    fAuth.createUserWithEmailAndPassword(registeremail.getText().toString(),registerpassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            //send user to next page
                            FirebaseUser user = fAuth.getCurrentUser();
                            Toast.makeText(Register.this, "Account Successfully Created", Toast.LENGTH_SHORT).show();
                            DocumentReference df = fStore.collection("Users").document(user.getUid());
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("Fullname",registerfullname.getText().toString());
                            userInfo.put("UserEmail",registeremail.getText().toString());
                            userInfo.put("Time In", false);
                            userInfo.put("Time Out", false);

                            // Specify if the user is admin
                            if (isAdmin.isChecked()){
                                userInfo.put("isAdmin","1");
                            }
                            if (isUser.isChecked()){
                                userInfo.put("isUser","1");
                            }


                            df.set(userInfo);
                            if (isAdmin.isChecked()){
                                startActivity(new Intent(getApplicationContext(),Admin.class));
                                finish();
                            }
                            if (isUser.isChecked()){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Register.this, "Failed to Create Account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

    }
    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
}
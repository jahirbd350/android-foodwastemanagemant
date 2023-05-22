package com.jahirbd350.foodwastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.jahirbd350.foodwastemanagement.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {
    private  static final String TAG = "Register";
    Button registrationbtn;
    Button gotologin;

    ActivityRegisterBinding binding;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar);

        Intent loginintent = new Intent(Register.this, Login.class);

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.username.getText().toString();
                String email = binding.emailaddress.getText().toString();
                String password = binding.password.getText().toString();
                String phoneno = binding.phoneno.getText().toString();
                String address = binding.address.getText().toString();

                progressBar.setVisibility(View.VISIBLE);

                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Please enter you email and password correctly!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "Registration Success!", Toast.LENGTH_LONG).show();

                                    progressBar.setVisibility(View.GONE);
                                    Intent loginintent = new Intent(Register.this, Login.class);
                                    startActivity(loginintent);
                                }else {
                                    Toast.makeText(
                                                    getApplicationContext(),
                                                    "Registration failed!!"
                                                            + " Please try again later",
                                                    Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });

                        /*.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Log.d(TAG, "createUserWithEmail:success");
                                Toast.makeText(Register.this, "Registration Success.", (Toast.LENGTH_SHORT)).show();
                                startActivity(loginintent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Register.this, "Registration Failed!", (Toast.LENGTH_SHORT)).show();
                            }
                        });*/
            }
        });

        gotologin = findViewById(R.id.gotologin);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(loginintent);
            }
        });

        /*setContentView(R.layout.activity_register);
        registrationbtn = findViewById(R.id.register);

        Intent intent = new Intent(Register.this, Login.class);

        registrationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        }); */


    }
}
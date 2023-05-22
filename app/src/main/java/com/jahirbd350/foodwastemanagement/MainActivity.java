package com.jahirbd350.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
CardView donatefood, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donatefood = findViewById(R.id.donatefood);
        donatefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donatefood = new Intent(MainActivity.this, DonateFood.class);
                startActivity(donatefood);
            }
        });

        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Logged out successfully!", Toast.LENGTH_SHORT).show();
                Intent logout = new Intent(MainActivity.this, Login.class);
                startActivity(logout);
            }
        });
    }
}
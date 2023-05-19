package com.jahirbd350.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
CardView donatefood;
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
    }
}
package com.example.canteen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class userlogin extends AppCompatActivity {

    Button btn;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        btn = findViewById(R.id.login);
        btn1=findViewById(R.id.register);

        btn.setOnClickListener(view -> {
            Intent intent=new Intent(userlogin.this,login.class);
            startActivity(intent);
        });

        btn1.setOnClickListener(view -> {
            Intent intent=new Intent(userlogin.this,register.class);
            startActivity(intent);
        });

    }
}
package com.example.canteen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.adminlogin);
        btn1=findViewById(R.id.userlogin);

        btn.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,adminlogin.class);
            startActivity(intent);
        });

        btn1.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,userlogin.class);
            startActivity(intent);
        });
    }
}


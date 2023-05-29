package com.example.canteen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class adminlogin extends AppCompatActivity {

    EditText username1,pass1;

    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        username1=findViewById(R.id.username);
        pass1=findViewById(R.id.pass);
        btnlogin = findViewById(R.id.btnSubmit_login);


        btnlogin.setOnClickListener(view -> {
            if(username1.getText().toString().equals("admin") && pass1.getText().toString().equals("admin")) {
                Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(adminlogin.this,uploadmenu.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText email1,pass1;
    FirebaseAuth mAuth;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email1=findViewById(R.id.email);
        pass1=findViewById(R.id.pass);
        login=findViewById(R.id.btn_login);

        mAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(v -> {
            String email=email1.getText().toString().trim();
            String pass=pass1.getText().toString().trim();

            if(email.isEmpty())
            {
                email1.setError("Email is empty");
               email1.requestFocus();
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                email1.setError("Enter the valid email");
                email1.requestFocus();
                return;
            }
            if(pass.isEmpty())
            {
                pass1.setError("Password is empty");
                pass1.requestFocus();
                return;
            }
            if(pass.length()<6)
            {
                pass1.setError("Length of password is more than 6");
                pass1.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(task -> {
            if(task.isSuccessful())
            {
                startActivity(new Intent(login.this, menu.class));
            }
            else
            {
                Toast.makeText(login.this,
                        "Please Check Your login Credentials",
                        Toast.LENGTH_SHORT).show();
            }

        });
        });

    }
}


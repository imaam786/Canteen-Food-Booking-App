package com.example.canteen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class register extends AppCompatActivity {
    Button reg;
    EditText regno1,name1,dept1,year1,pass1,email1;
    FirebaseAuth mAuth;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regno1=findViewById(R.id.regno);
        name1=findViewById(R.id.name);
        dept1=findViewById(R.id.dept);
        year1=findViewById(R.id.year);
        pass1=findViewById(R.id.pass);
        reg=findViewById(R.id.register);

        email1=findViewById(R.id.email);

        mAuth=FirebaseAuth.getInstance();

        reg.setOnClickListener(view -> {
            rootNode=FirebaseDatabase.getInstance();
            reference= rootNode.getReference("users");

            String regno=regno1.getText().toString().trim();
            String name=name1.getText().toString().trim();
            String dept=dept1.getText().toString().trim();
            String year=year1.getText().toString().trim();
            String pass=pass1.getText().toString().trim();
            String email=email1.getText().toString().trim();

            UserHelper helperClass = new UserHelper(regno,name,dept,year,email,pass);
            reference.child(regno).setValue(helperClass);

            if(email.isEmpty())
            {
                email1.setError("Email is empty");
                email1.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                email1.setError("Enter the valid email address");
                email1.requestFocus();
                return;
            }

            if(regno.isEmpty())
            {
                regno1.setError("RegNo is empty");
                regno1.requestFocus();
                return;
            }

            if(name.isEmpty())
            {
                name1.setError("Name is empty");
                name1.requestFocus();
                return;
            }

            if(dept.isEmpty())
            {
                dept1.setError("Dept is empty");
                dept1.requestFocus();
                return;
            }

            if(year.isEmpty())
            {
                year1.setError("Year is empty");
                year1.requestFocus();
                return;
            }

            if(pass.isEmpty())
            {
                pass1.setError("Enter password");
                pass1.requestFocus();
                return;
            }

            if(pass.length()<6)
            {
                pass1.setError("Password should be more than 6");
                pass1.requestFocus();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Toast.makeText(register.this,"You are successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(register.this,login.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(register.this, "You are not Registered! Try again", Toast.LENGTH_SHORT).show();
                }
            });

        });
    }
}
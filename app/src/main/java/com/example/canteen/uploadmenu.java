package com.example.canteen;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class uploadmenu extends AppCompatActivity {
    EditText d_name, d_price;
    Button upload;
    Button orders;

    FirebaseDatabase rootnode;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadmenu);

        d_name = findViewById(R.id.dish);
        d_price = findViewById(R.id.price);
        upload = findViewById(R.id.btn_upload);
        orders=findViewById(R.id.btn_viewodr);

        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(uploadmenu.this,vieworder.class);
                startActivity(intent);
            }
        });



        upload.setOnClickListener(view -> {

            rootnode = FirebaseDatabase.getInstance();
            databaseReference = rootnode.getReference("Menu");

            String name = d_name.getText().toString();
            String price = d_price.getText().toString();

            UserHelper userHelper = new UserHelper(name, price);
            databaseReference.child(name).setValue(userHelper);

            if (name.isEmpty()) {
                d_name.setError("Name is empty");
                d_name.requestFocus();
                return;
            }

            if (price.isEmpty()) {
                d_price.setError("Price is empty");
                d_price.requestFocus();
                return;
            }


            if (TextUtils.isEmpty(name) && TextUtils.isEmpty(price)) {
                Toast.makeText(uploadmenu.this, "Please add some data.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(uploadmenu.this, "Dish added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

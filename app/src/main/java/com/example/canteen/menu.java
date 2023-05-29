package com.example.canteen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;


public class menu extends AppCompatActivity {

    Button btnorder;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ListView listView = findViewById(R.id.listview);

        btnorder=findViewById(R.id.btn_order);
        btnorder.setOnClickListener(view -> {
            Intent intent=new Intent(menu.this,checkout.class);
            startActivity(intent);
        });


        ArrayList<String>  list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((adapterView, view, i, l) -> startActivity(new Intent(menu.this,checkout.class)));

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Menu");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    list.add(Objects.requireNonNull(snapshot.getValue()).toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(menu.this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
package com.example.canteen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class finalpage extends AppCompatActivity {

    TextView tid, det, menu, pri;
    String Tid,Detail,Menu,Price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        tid=(TextView) findViewById(R.id.t_id);
        det=(TextView) findViewById(R.id.detail);
        menu=(TextView) findViewById(R.id.menu_name);
        pri=(TextView) findViewById(R.id.price_detail);

        Intent intent=getIntent();
        Tid=intent.getStringExtra("tid_key");
        Detail=intent.getStringExtra("Detail_key");
        Menu=intent.getStringExtra("Menu_key");
        Price=intent.getStringExtra("Price_key");

        tid.setText(Tid);
        det.setText(Detail);
        menu.setText(Menu);
        pri.setText(Price);
    }
}
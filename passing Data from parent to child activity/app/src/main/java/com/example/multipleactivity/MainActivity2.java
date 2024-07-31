package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i=getIntent();
        int id=i.getIntExtra("id",0);
        String name=i.getStringExtra("Name");
        String address=i.getStringExtra("Address");
        TextView txt=findViewById(R.id.txt1);
        txt.setText("Id="+id+"\n"+"Name="+name+"\n"+"Address="+address);



    }
}
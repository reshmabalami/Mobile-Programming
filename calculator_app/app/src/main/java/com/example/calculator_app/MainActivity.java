package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText txtnum1,txtnum2;
TextView getresult;
float first, second,result;
Button add,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnum1= findViewById(R.id.num1);
        txtnum2= findViewById(R.id.num2);

        add=findViewById(R.id.buttonadd);
        sub=findViewById(R.id.buttonsub);
        mul=findViewById(R.id.buttonmul);
        div=findViewById(R.id.buttondiv);
        getresult=findViewById(R.id.txtview);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first=Float.parseFloat(txtnum1.getText().toString());
                second=Float.parseFloat(txtnum2.getText().toString());
               result=first+second;
               getresult.setText("The Sum is "+result);

            }
        });
       sub.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               first=Float.parseFloat(txtnum1.getText().toString());
               second=Float.parseFloat(txtnum2.getText().toString());
               result=first-second;
               getresult.setText("The difference is "+result);
           }
       });
       mul.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               first=Float.parseFloat(txtnum1.getText().toString());
               second=Float.parseFloat(txtnum2.getText().toString());
               result=first*second;
               getresult.setText("The Product is"+result);
           }
       });

       div.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               first=Float.parseFloat(txtnum1.getText().toString());
               second=Float.parseFloat(txtnum2.getText().toString());
               result=first/second;
               getresult.setText("The division is "+result);
           }
       });

    }
}
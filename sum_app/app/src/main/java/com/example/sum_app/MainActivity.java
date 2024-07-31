package com.example.sum_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn_calculate;
EditText num1,num2;
Float first,second,result;
TextView view_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_calculate=findViewById(R.id.calculate_sum);
        view_result=findViewById(R.id.view_result);
        num1=findViewById(R.id.first_num);
        num2=findViewById(R.id.second_num);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=Float.parseFloat(num1.getText().toString());
                second=Float.parseFloat(num2.getText().toString());
                result=first+second;
                view_result.setText("The sum is"+result);
            }
        });

    }
}
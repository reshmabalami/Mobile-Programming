package com.example.custom_dialog_box_example;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonOpenDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOpenDialog = findViewById(R.id.button_open_dialog);
        buttonOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Enter Numbers");

        final EditText editTextNumber1 = dialog.findViewById(R.id.editText_number1);
        final EditText editTextNumber2 = dialog.findViewById(R.id.editText_number2);
        Button buttonCalculate = dialog.findViewById(R.id.button_calculate);
        final TextView textViewResult = dialog.findViewById(R.id.textView_result);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1String = editTextNumber1.getText().toString().trim();
                String number2String = editTextNumber2.getText().toString().trim();

                if (!number1String.isEmpty() && !number2String.isEmpty()) {
                    int number1 = Integer.parseInt(number1String);
                    int number2 = Integer.parseInt(number2String);
                    int sum = number1 + number2;
                    textViewResult.setText("Sum: " + sum);
                }
            }
        });

        dialog.show();
    }
}

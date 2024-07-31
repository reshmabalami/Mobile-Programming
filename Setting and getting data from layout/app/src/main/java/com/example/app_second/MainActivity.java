package com.example.app_second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextEmail, editTextPhone;
    private RadioGroup radioGroupGender;
    private Spinner spinnerCountry;
    private Button buttonSubmit;
    private TextView textViewDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewDisplay = findViewById(R.id.textViewDisplay);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();

                int genderId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton radioButtonGender = findViewById(genderId);
                String gender = radioButtonGender.getText().toString();

                String country = spinnerCountry.getSelectedItem().toString();

                String displayText = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone
                        + "\nGender: " + gender + "\nCountry: " + country;
                textViewDisplay.setText(displayText);
            }
        });


    }
}



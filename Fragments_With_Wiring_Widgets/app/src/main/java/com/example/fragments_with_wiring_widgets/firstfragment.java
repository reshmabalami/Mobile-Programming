package com.example.fragments_with_wiring_widgets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class firstfragment extends Fragment {

    private EditText firstNumberEditText;
    private EditText secondNumberEditText;
    private Button sumButton;
    private Button differenceButton;
    private Button multiplicationButton;
    private Button divisionButton;
    private TextView resultTextView;
    private static final String ARG_TEXT = "text";

    public firstfragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_firstfragment, container, false);

        // Get references to views
        firstNumberEditText = view.findViewById(R.id.firstNumber);
        secondNumberEditText = view.findViewById(R.id.secondNumber);
        sumButton = view.findViewById(R.id.sumButton);
        differenceButton = view.findViewById(R.id.differenceButton);
        multiplicationButton = view.findViewById(R.id.multiplicationButton);
        divisionButton = view.findViewById(R.id.divisionButton);
        resultTextView = view.findViewById(R.id.viewResult);

        // Set click listeners for buttons
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float first = Float.parseFloat(firstNumberEditText.getText().toString());
                float second = Float.parseFloat(secondNumberEditText.getText().toString());
                float sum = first + second;
                resultTextView.setText("The sum is " + sum);




            }
        });

        differenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float first = Float.parseFloat(firstNumberEditText.getText().toString());
                float second = Float.parseFloat(secondNumberEditText.getText().toString());
                float diff = first - second;
                resultTextView.setText("The Difference is " + diff);
            }
        });

        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float first = Float.parseFloat(firstNumberEditText.getText().toString());
                float second = Float.parseFloat(secondNumberEditText.getText().toString());
                float prod = first * second;
                resultTextView.setText("The Product is " + prod);
            }
        });

        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float first = Float.parseFloat(firstNumberEditText.getText().toString());
                float second = Float.parseFloat(secondNumberEditText.getText().toString());
                float div = first / second;
                resultTextView.setText("The Quotient is " + div);
            }
        });


        return view;
    }
    public String getText() {

        return resultTextView.getText().toString();

    }
}



        // Show result in second fragment





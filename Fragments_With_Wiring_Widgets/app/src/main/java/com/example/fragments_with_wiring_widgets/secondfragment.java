package com.example.fragments_with_wiring_widgets;

import static android.text.style.TtsSpan.ARG_TEXT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class secondfragment extends Fragment {


    TextView resultinsecond;


    public secondfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_secondfragment, container, false);
        resultinsecond=view.findViewById(R.id.viewresult_Second);
        // Get references to views
        firstfragment firstFragment = (firstfragment) getParentFragmentManager().findFragmentById(R.id.fragment1);
        String text = firstFragment.getText();
        //resultinsecond.setText(text);

            // Set click listeners for buttons

            return view;
        }



}



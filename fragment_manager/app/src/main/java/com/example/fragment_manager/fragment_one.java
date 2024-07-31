package com.example.fragment_manager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fragment_one extends Fragment {

    private ListView listView;
    private ArrayList<String> dataList;
    private ArrayAdapter<String> adapter;

    public fragment_one() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        listView = view.findViewById(R.id.list_view);

        dataList = new ArrayList<>();
        dataList.add("नेपाल");
        dataList.add("भारत");
        dataList.add("चाईना");
        dataList.add("बेलायत");
        dataList.add("सम्युक्त राज्य अमेरिका");

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        return view;
    }
}

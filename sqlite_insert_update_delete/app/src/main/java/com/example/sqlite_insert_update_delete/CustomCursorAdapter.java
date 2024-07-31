package com.example.sqlite_insert_update_delete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter {

    public CustomCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewId = view.findViewById(R.id.textid);
        TextView textViewName = view.findViewById(R.id.textname);
        TextView textViewAddress = view.findViewById(R.id.textaddress);

        @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
        @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ADDRESS));

        textViewId.setText(id);
        textViewName.setText(name);
        textViewAddress.setText(address);
    }
}

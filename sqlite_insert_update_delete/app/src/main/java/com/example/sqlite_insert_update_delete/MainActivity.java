package com.example.sqlite_insert_update_delete;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextId, editTextName, editTextAddress;
    private Button buttonInsert, buttonSelect, buttonUpdate, buttonDelete;
    private ListView listView;
    private DatabaseHelper dbHelper;
    private CustomCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonSelect = findViewById(R.id.buttonSelect);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);
        listView = findViewById(R.id.listView);

        // Initialize database helper
        dbHelper = new DatabaseHelper(this);

        // Set button click listener for Insert button
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                if (id.isEmpty() || name.isEmpty() || address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    long rowId = dbHelper.insertData(id, name, address);
                    if (rowId != -1) {
                        Toast.makeText(MainActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                        clearFields();
                        refreshListView();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set button click listener for Select button
        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshListView();
            }
        });

        // Set button click listener for Update button
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                if (id.isEmpty() || name.isEmpty() || address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    int rowsAffected = dbHelper.updateData(id, name, address);
                    if (rowsAffected > 0) {
                        Toast.makeText(MainActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                        clearFields();
                        refreshListView();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to update data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set button click listener for Delete button
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                if (id.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter an ID to delete", Toast.LENGTH_SHORT).show();
                } else {
                    int rowsAffected = dbHelper.deleteData(id);
                    if (rowsAffected > 0) {
                        Toast.makeText(MainActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                        clearFields();
                        refreshListView();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set item click listener for ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = adapter.getCursor();
                if (cursor.moveToPosition(position)) {
                    @SuppressLint("Range") String itemId = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
                    @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ADDRESS));

                    editTextId.setText(itemId);
                    editTextName.setText(name);
                    editTextAddress.setText(address);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshListView();
    }

    private void clearFields() {
        editTextId.setText("");
        editTextName.setText("");
        editTextAddress.setText("");
    }

    private void refreshListView() {
        Cursor cursor = dbHelper.selectData();
        if (adapter == null) {
            adapter = new CustomCursorAdapter(this, cursor);
            listView.setAdapter(adapter);
        } else {
            adapter.changeCursor(cursor);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adapter != null) {
            adapter.changeCursor(null);
        }
    }
}

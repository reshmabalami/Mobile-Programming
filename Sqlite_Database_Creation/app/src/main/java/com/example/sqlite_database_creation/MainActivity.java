package com.example.sqlite_database_creation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Create or open the database
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        // Insert data into the table
        String insertDataQuery = "INSERT INTO " + DatabaseHelper.TABLE_NAME +
                " (" + DatabaseHelper.COLUMN_NAME + ") VALUES ('Ram')";
        db.execSQL(insertDataQuery);

        // View the table and inserted data
        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));

            stringBuilder.append("ID: ").append(id).append(", Name: ").append(name).append("\n");
        }
        cursor.close();

        // Display the data
        textView.setText(stringBuilder.toString());

        // Close the database
        db.close();
    }
}
package com.example.context_menu_example;
import com.example.context_menu_example.R;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        // Register the view for the context menu
        registerForContextMenu(textView);

        // Set a long click listener to show the context menu
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_1) {
            Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_item_2) {
            Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_item_3) {
            Toast.makeText(this, "Option 3 selected", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

}

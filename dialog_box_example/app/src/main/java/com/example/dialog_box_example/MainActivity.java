package com.example.dialog_box_example;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {

        showExitConfirmationDialog();
    }

    private void showExitConfirmationDialog() {
        if (dialogBuilder == null) {
            dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setTitle("Exit");
            dialogBuilder.setMessage("Are you sure you want to exit?");
            dialogBuilder.setCancelable(true);
            dialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                }
            });
        }

        AlertDialog exitDialog = dialogBuilder.create();
        exitDialog.show();
    }
}

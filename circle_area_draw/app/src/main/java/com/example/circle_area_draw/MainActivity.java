package com.example.circle_area_draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.circle_area_draw.R;

public class MainActivity extends AppCompatActivity {

    EditText radiusEditText;
    Button calculateButton;
    TextView areaTextView;
    ImageView canvasImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiusEditText = findViewById(R.id.radiusEditText);
        calculateButton = findViewById(R.id.calculateButton);
        areaTextView = findViewById(R.id.areaTextView);
        canvasImageView = findViewById(R.id.canvasImageView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radiusStr = radiusEditText.getText().toString();
                if (radiusStr.isEmpty()) {
                    areaTextView.setText("Please enter a radius.");
                    return;
                }

                double radius = Double.parseDouble(radiusStr);
                double area = Math.PI * Math.pow(radius, 2);

                areaTextView.setText("Area: " + String.format("%.2f", area));

                // Draw circle
                int canvasWidth = canvasImageView.getWidth();
                int canvasHeight = canvasImageView.getHeight();
                Bitmap bitmap = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);

                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                paint.setStyle(Paint.Style.FILL);

                int centerX = canvasWidth / 2;
                int centerY = canvasHeight / 2;
                int radiusPx = (int) (canvasWidth * radius / 10);
                canvas.drawCircle(centerX, centerY, radiusPx, paint);

                canvasImageView.setImageBitmap(bitmap);
            }
        });
    }
}

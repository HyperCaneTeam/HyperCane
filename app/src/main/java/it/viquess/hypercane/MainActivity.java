package it.viquess.hypercane;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView status;
    private TextView status2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = findViewById(R.id.stato);
        status2 = findViewById(R.id.stato2);

        status2.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(() -> {
            status.setTextColor(Color.RED);
            status.setText("La stampella è caduta!");
            status2.setVisibility(View.VISIBLE);
        }, 5000);
    }
}

package it.viquess.hypercane;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView bt_connected;
    private BluetoothAdapter BA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_connected = findViewById(R.id.bt_connection);

        //https://www.youtube.com/watch?v=iFtjox9_zAI
        //https://www.youtube.com/watch?v=TtpLcsQ4nMw
    }
}
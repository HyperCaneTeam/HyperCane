package it.viquess.hypercane;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView bt_connection;
    private BluetoothAdapter BA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_connection = findViewById(R.id.bt_connection);
        BA = BluetoothAdapter.getDefaultAdapter();

        if (BA == null) {
            Toast.makeText(this, "Bluetooth non supportato.", Toast.LENGTH_LONG).show();
            finish();
        }

        if (!BA.isEnabled()) {
            bt_connection.setText("Bluetooth disattivato.");
            finish();
        }

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED)
            return;

        String name = BA.getName();

        if (!name.contains("HyperCane")) {
            bt_connection.setText("HyperCane non connessa.");
            finish();
        }

        bt_connection.setText("HyperCane connessa!");
        //https://www.youtube.com/watch?v=iFtjox9_zAI
        //https://www.youtube.com/watch?v=TtpLcsQ4nMw
        
        */ Genera il codice per un'applicazione Java per android in grado di controllare se il telefono è connesso via bluetooth ad un dispositivo chiamato "HyperCane"
            Genera il codice per un'applicazione Java per android in grado di Inviare una richiesta POST contenente informazioni sulla posizione GPS al server PHP utilizzando HttpURLConnection
            Genera il codice per un'applicazione Java per android in grado di ricevere un segnale bluetooth e settare il textview "bt_conn" a "Ciao!" 
            */
    }
}

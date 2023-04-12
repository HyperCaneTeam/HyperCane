package it.viquess.hypercane;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    //private TextView bt_connection;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.web_view);
        //webView.setVisibility(View.INVISIBLE);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sendMail(getCoords());
    }

    /*private void checkConnection() {

        BluetoothDevice hyperCane = BA.getRemoteDevice("HyperCane");

        if (hyperCane == null) {
            Toast.makeText(this, "Il dispositivo HyperCane non è stato trovato", Toast.LENGTH_SHORT).show();
            return;
        }

        if (BluetoothAdapter.checkBluetoothAddress(hyperCane.getAddress()) && BA.getConnectionState(hyperCane) == BluetoothAdapter.STATE_CONNECTED) {
            Toast.makeText(this, "Il dispositivo HyperCane è connesso via Bluetooth", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Il dispositivo HyperCane non è connesso via Bluetooth", Toast.LENGTH_SHORT).show();


    }*/

    private Location getLocation() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        return lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    private String getCoords() {
        Location loc = getLocation();

        if (loc == null)
            return "";

        return loc.getLatitude() + "," + loc.getLongitude();
    }

    private void sendMail(String coords) {
        webView.reload();
        webView.loadUrl("https://loriscl.altervista.org/hypercane/?coordinate=" + coords + "&mail1=vincenzo.bova05@gmail.com");
    }
}

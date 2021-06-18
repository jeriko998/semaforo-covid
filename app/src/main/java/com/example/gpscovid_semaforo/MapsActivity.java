package com.example.gpscovid_semaforo;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/**
 *     Contraseña de la llave: semaforocovid
 *     Nombre de la llave my-key.jks
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private String LOG_TAG;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Log.d(LOG_TAG,"error");
        Log.i(LOG_TAG,"error");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }


}
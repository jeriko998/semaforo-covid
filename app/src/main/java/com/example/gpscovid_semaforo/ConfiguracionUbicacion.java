package com.example.gpscovid_semaforo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class ConfiguracionUbicacion extends AppCompatActivity {

    public static final int INTERVALO_ACTUALIZACION_PREDETERMINADO = 30;
    public static final int INTERVALO_ACTUALIZACION_RAPIDO = 5;
    public static final int PERMISSION_FINE_LOCATION = 1;
    public String LOG_TAG;

    TextView txtview_actualizacion, txtview_sensor, txtview_latitud, txtview_longitud;
    Switch sw_actualizacion, sw_sensor;
    //API para servicios de localizacion
    FusedLocationProviderClient fusedLocationProviderClient;

    boolean updateOn = false;

    LocationRequest locationRequest;
    private LocationCallback locationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_ubicacion);
        sw_actualizacion = findViewById(R.id.sw_actualizacion);
        sw_sensor = findViewById(R.id.sw_sensor);
        txtview_actualizacion = findViewById(R.id.txtview_actualizacion);
        txtview_sensor = findViewById(R.id.txtview_sensor);
        txtview_longitud = findViewById(R.id.txtview_longitud);
        txtview_latitud = findViewById(R.id.txtview_latitud);

        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000 * INTERVALO_ACTUALIZACION_PREDETERMINADO);
        locationRequest.setFastestInterval(1000 * INTERVALO_ACTUALIZACION_RAPIDO);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        locationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                actualizarValoresUI(locationResult.getLastLocation());
            }
        };

        txtview_sensor.setText("Torres de teléfono + Wifi");
        //switch del tipo de sensor
        sw_sensor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (sw_sensor.isChecked()) {
                    //mas preciso utilizando GPS
                    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                    txtview_sensor.setText("Sensores GPS");
                    Log.d(LOG_TAG, "switch cambiado a sensores GPS");
                } else {
                    locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    txtview_sensor.setText("Torres de telefono + Wifi");
                    Log.d(LOG_TAG, "switch cambiado a torres y wifi");
                }
            }
        });

        txtview_actualizacion.setText("Actualizacion de ubicacion para" +
                " cambios de ubicacion respecto a alcaldias");
        sw_actualizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw_actualizacion.isChecked()) {
                    iniciarActualizacionUbicacion();
                    actualizarGPS();
                } else {
                    detenerActualizacionUbicacion();
                }
            }
        });
    }//fin del metodo onCreate

    private void iniciarActualizacionUbicacion() {
        txtview_actualizacion.setText("Actualizacion de ubicacion respecto a  alcaldias");

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
        }

    }

    private void detenerActualizacionUbicacion() {
        txtview_actualizacion.setText("Sin actualizaciones de ubicacion");
        txtview_longitud.setText("");
        txtview_latitud.setText("");
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_FINE_LOCATION:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    actualizarGPS();
                }else{
                    Toast.makeText(this,"La aplicacion requiere permiso de ubicacion para funcionar correctamente",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }break;
        }
    }


    public void actualizarGPS(){
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(ConfiguracionUbicacion.this);
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this,
                    location -> actualizarValoresUI(location));
        }else{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_FINE_LOCATION);
            }
        }
    }

    public void actualizarValoresUI(Location location){
        txtview_latitud.setText(String.valueOf(location.getLatitude()));
        txtview_longitud.setText(String.valueOf(location.getLongitude()));
    }


}
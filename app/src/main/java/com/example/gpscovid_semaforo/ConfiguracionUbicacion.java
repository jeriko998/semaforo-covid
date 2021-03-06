package com.example.gpscovid_semaforo;

import android.Manifest;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class ConfiguracionUbicacion extends AppCompatActivity {

    public static final int INTERVALO_ACTUALIZACION_PREDETERMINADO = 30;
    public static final int INTERVALO_ACTUALIZACION_RAPIDO = 5;
    public static final int PERMISSION_FINE_LOCATION = 1;
    public String LOG_TAG;
    TextView txtview_actualizacion, txtview_sensor, txtview_latitud, txtview_longitud;
    Switch sw_actualizacion, sw_sensor;
    //API para servicios de localizacion
    FusedLocationProviderClient fusedLocationClient;
    boolean updateOn = false;
    LocationRequest locationRequest;
    private LocationCallback locationCallback;
    protected static final int REQUEST_CHECK_SETTINGS = 0x1;
    Task<LocationSettingsResponse> task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_ubicacion);
        actualizarGPS();
        sw_actualizacion = findViewById(R.id.sw_actualizacion);
        sw_sensor = findViewById(R.id.sw_sensor);
        txtview_actualizacion = findViewById(R.id.txtview_actualizacion);
        txtview_sensor = findViewById(R.id.txtview_sensor);
        txtview_longitud = findViewById(R.id.txtview_longitud);
        txtview_latitud = findViewById(R.id.txtview_latitud);

        requestUbicacion();

        //Evento que se activa cada que se alcanza el intervalo de actualizacion
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                actualizarValoresUI(locationResult.getLastLocation());}
        };

        SharedPreferences sharedPrefs = getSharedPreferences("com.example.xyle", MODE_PRIVATE);
        sw_actualizacion.setChecked(sharedPrefs.getBoolean("Switch de intervalo", true));
        sw_sensor.setChecked(sharedPrefs.getBoolean("Switch de gps", true));


        txtview_sensor.setText("Sensores GPS");
        //switch del tipo de sensor
        sw_sensor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (sw_sensor.isChecked()) {
                    //mas preciso utilizando GPS
                    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                    txtview_sensor.setText("Sensores GPS");
                    Log.d(LOG_TAG, "switch cambiado a sensores GPS");
                    SharedPreferences.Editor editor = getSharedPreferences("com.example.xyz", MODE_PRIVATE).edit();
                    editor.putBoolean("Switch de gps", true);
                    editor.apply();
                } else {
                    locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    txtview_sensor.setText("Torres de telefono + Wifi");
                    SharedPreferences.Editor editor = getSharedPreferences("com.example.xyz", MODE_PRIVATE).edit();
                    editor.putBoolean("Switch de torres", false);
                    editor.apply();
                    Log.d(LOG_TAG, "switch cambiado a torres y wifi");
                }
            }
        });

        txtview_actualizacion.setText("Actualizacion de ubicacion para cambios respecto a alcaldias");
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

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        SettingsClient client = LocationServices.getSettingsClient(this);
        task = client.checkLocationSettings(builder.build());
        checkConfiguracion();

    }//fin del metodo onCreate

    private void requestUbicacion() {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000 * INTERVALO_ACTUALIZACION_PREDETERMINADO);
        locationRequest.setFastestInterval(1000 * INTERVALO_ACTUALIZACION_RAPIDO);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
    }

    protected void iniciarActualizacionUbicacion() {
        txtview_actualizacion.setText("Actualizacion de ubicacion para cambios respecto a alcaldias");

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
        }

    }

    private void detenerActualizacionUbicacion() {
        txtview_actualizacion.setText("Sin actualizaciones de ubicacion");
        txtview_longitud.setText("");
        txtview_latitud.setText("");
        fusedLocationClient.removeLocationUpdates(locationCallback);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_FINE_LOCATION:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    actualizarGPS();
                }else{
                    Toast.makeText(this,"La aplicacion requiere permiso de ubicacion " +
                                    "para funcionar correctamente",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }break;
        }
    }


    public void actualizarGPS(){
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(ConfiguracionUbicacion.this);
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationClient.getLastLocation().addOnSuccessListener(this,
                    location -> actualizarValoresUI(location));
        }else{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSION_FINE_LOCATION);
            }
        }
    }

    public void actualizarValoresUI(Location location){
        txtview_latitud.setText(String.valueOf(location.getLatitude()));
        txtview_longitud.setText(String.valueOf(location.getLongitude()));
    }

    public void checkConfiguracion(){
        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                // All location settings are satisfied. The client can initialize
                // location requests here.
                // ...
            }
        });

        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(ConfiguracionUbicacion.this,
                                REQUEST_CHECK_SETTINGS);
                    } catch (IntentSender.SendIntentException sendEx) {
                        // Ignore the error.
                    }
                }
            }
        });
    }//fin del metodo checkConfiguracion



    @Override
    protected void onResume() {
        super.onResume();
        checkConfiguracion();
        iniciarActualizacionUbicacion();
        actualizarGPS();
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkConfiguracion();
        iniciarActualizacionUbicacion();
        actualizarGPS();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
package com.example.gpscovid_semaforo;

import static com.example.gpscovid_semaforo.NotificacionAlerta.CHANNEL_1_ID;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mapbox.android.core.location.LocationEngineResult;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    private int TiempoEspera = 3000;
    private TelephonyManager mTelephonyManager;
    public String LOG_TAG;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    public static final int CALL_PERMISSION = 1;
    List<String> listPermissionsNeeded = new ArrayList<>();
    MapaMapBox mapaMapBox = new MapaMapBox();
    LocationEngineResult result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAndRequestPermissions();
        mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        isTelephonyEnabled();
        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void llamarNumero(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            enableCallButton();
            TextView textview = findViewById(R.id.numero_a_llamar);

            //Formato del numero de celular
            String numeroCelular = String.format("tel: %s", textview.getText().toString());
            Intent callIntent = new Intent(Intent.ACTION_CALL);

            //Estableciendo el Uri con el numero telefonico
            callIntent.setData(Uri.parse(numeroCelular));

            //Si el paquete abre una aplicación, enviar el Intent
            if (callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(callIntent);
            } else {
                Toast.makeText(this, "Permiso de llamadas necesario", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"La aplicación requiere permiso " +
                    "de llamadas para poder realizar esta acción", Toast.LENGTH_LONG).show();
            Handler handler = new Handler();
            handler.postDelayed(() ->
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION),
                    3000);
        }
    }

    //Corroborando que el telefono tenga tarjeta SIM
    private boolean isTelephonyEnabled() {
        if (mTelephonyManager != null) {
            return mTelephonyManager.getSimState() == TelephonyManager.SIM_STATE_READY;
        }
        return false;
    }

    //  Metodo para obtencion multiple de permisos
    public boolean checkAndRequestPermissions() {
        int permisoUbicacion_Segundoplano = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        int permisoUbicacion = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int permisoLlamadas = ContextCompat.checkSelfPermission(this
                , Manifest.permission.CALL_PHONE);
        if (permisoUbicacion != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (permisoLlamadas != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE);
        }
        if (permisoUbicacion_Segundoplano != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }



    public void enableCallButton() {
        FloatingActionButton fab = findViewById(R.id.call_button);
        fab.setEnabled(true);
    }

    public void abrirClaseMapa(View view) {
        Log.d(LOG_TAG, "Boton presionado");
        startActivity(new Intent(MainActivity.this, MapaMapBox.class));
    }

    public void notificacionAlerta(View v) {
        String titleC1 = "Titulo notif 1";
        String textoC1 = "Notificacion de ubicacion";
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                //.setSmallIcon() agregar icono aplicacion
                .setContentTitle(titleC1)
                .setContentText(textoC1)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void abrirConfiguracion(View v){
        Log.d(LOG_TAG,"Configuracion abierta");
        startActivity(new Intent(MainActivity.this, ConfiguracionUbicacion.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
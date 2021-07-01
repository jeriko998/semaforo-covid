package com.example.gpscovid_semaforo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TelephonyManager mTelephonyManager;
    public String LOG_TAG;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkAndRequestPermissions()){
            mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        /*
           Checando si TelephonyManager esta activo en la API del telefono
         */
            if (isTelephonyEnabled()) {
                Log.d("", "TelephonyManager abilitado");
            /*
               Inicializacion del metodo para corroborar el permiso dado
             */

            } else{
                disableCallButton();
            }
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void llamarNumero(View view) {
        TextView textview = findViewById(R.id.numero_a_llamar);

        /*
            Formato del numero de celular
         */
        String numeroCelular = String.format("tel: %s", textview.getText().toString());
        Intent callIntent = new Intent(Intent.ACTION_CALL);

        /*
         *Estableciendo el Uri con el numero telefonico
         */
        callIntent.setData(Uri.parse(numeroCelular));

        /*
          Si el paquete abre una aplicación, enviar el Intent
         */
        if (callIntent.resolveActivity(getPackageManager()) != null) startActivity(callIntent);
        else {
            Log.e("Intent Action_dial", "No se encuentra aplicacion para el intent ACTION_DIAL");
            disableCallButton();
        }
    }

    /*
        Corroborando que el telefono tenga tarjeta SIM
    * */
    private boolean isTelephonyEnabled() {
        if (mTelephonyManager != null) {
            return mTelephonyManager.getSimState() == TelephonyManager.SIM_STATE_READY;
        }
        return false;
    }

    /*  Metodo para obtencion multiple de permisos
    * */

    private  boolean checkAndRequestPermissions() {
        int permisoUbicacion_Segundoplano = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        int permisoUbicacion = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int permisoLlamadas = ContextCompat.checkSelfPermission(this
                , Manifest.permission.CALL_PHONE);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (permisoUbicacion != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (permisoLlamadas != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE);
        }
        if(permisoUbicacion_Segundoplano != PackageManager.PERMISSION_GRANTED);{
            listPermissionsNeeded.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    public void disableCallButton() {
        if (ContextCompat.checkSelfPermission(this
                , Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            FloatingActionButton fab = findViewById(R.id.call_button);
            fab.setEnabled(false);
        }
    }
    public void abrirClaseMapa(View view) {
        Log.d(LOG_TAG, "Boton presionado");
        startActivity(new Intent(MainActivity.this,MapsActivity_fragment.class));
    }

}
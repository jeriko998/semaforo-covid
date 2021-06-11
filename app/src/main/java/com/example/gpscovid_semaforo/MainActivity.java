package com.example.gpscovid_semaforo;

import android.Manifest;
import android.annotation.SuppressLint;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private TelephonyManager mTelephonyManager;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private String LOG_TAG;
    private static final int REQUEST_LOCATION_PERMISSION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        /*
           Checando si TelephonyManager esta activo en la API del telefono
         */

        if (isTelephonyEnabled()) {
            Log.d("", "TelephonyManager abilitado");
            /*
               Inicializacion del metodo para corroborar el permiso dado
             */
            checkForPhonePermissions();
        } else{
            disableCallButton();
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
            Log.e("Intent Action_dial", "No se encuentra aplicacion para el intent ACTIOJN_DIAL");
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

    private void checkForPhonePermissions() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            Log.d("Permiso denegado", "Permiso denegado");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        }
    }

    /*
       Metodo de mensaje emergente
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void permisoDenegado() {
        String mMensajeDenegado = "Permiso de llamadas denegado";
    }

    public void disableCallButton() {
        FloatingActionButton fab = findViewById(R.id.call_button);
        fab.setEnabled(false);
    }

    public void abrirClaseMapa(View view) {
        Log.d(LOG_TAG, "Boton presionado");
        Intent sec_map = new Intent(this, MapsActivity_fragment.class);
        startActivity(sec_map);
    }

}
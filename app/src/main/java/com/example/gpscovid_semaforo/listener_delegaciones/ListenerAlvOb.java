package com.example.gpscovid_semaforo.listener_delegaciones;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.gpscovid_semaforo.PoligonosMapa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mapbox.mapboxsdk.maps.Style;

public class ListenerAlvOb {
    private String TAG_onDataChange = "onDataChange";
    private String Layer_AO = "clase condicional alvaro obregon";
    PoligonosMapa poligonosMapa = new PoligonosMapa();
    DatabaseReference databaseReference;
    DatabaseReference mDatosRef;
    private ValueEventListener mDatosListener;

    public void ListenerAO(Style style){
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mDatosRef=databaseReference.child("ocupacion").child("ocu_alvaroo");
        mDatosListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                float ocu_ccv = Float.parseFloat(snapshot.child("ocu_camas_c_venti").getValue().toString());
                float ocu_chgral = Float.parseFloat(snapshot.child("ocu_camas_h_gral").getValue().toString());
                float ocu_cvuci = Float.parseFloat(snapshot.child("ocu_camas_vent_uci").getValue().toString());

                float resultado = (ocu_ccv + ocu_chgral + ocu_cvuci)/3;
                if(snapshot.exists()){

                    if(resultado > 70){
                        poligonosMapa.addAlvObLayerRojo(style);
                        Log.e(TAG_onDataChange,"layer rojo"+ Layer_AO);
                    }else if((resultado > 50) && (resultado < 70)){
                        poligonosMapa.addAlvObLayerAmarillo(style);
                        Log.e(TAG_onDataChange,"layer amarillo "+Layer_AO);
                    }else if((resultado > 0) && (resultado < 50)){
                        poligonosMapa.addAlvObLayerVerde(style);
                        Log.e(TAG_onDataChange,"layer verde clase "+ Layer_AO);
                    }else if (resultado == 0){
                        poligonosMapa.addAlObSinDatos(style);
                        Log.e(TAG_onDataChange,"layer s/d" + Layer_AO);
                    }else{
                        Log.e(TAG_onDataChange,"error en condicionales"+Layer_AO);
                    }

                    Log.d(TAG_onDataChange,"snapshot"+Layer_AO+" existente");
                }else{
                    Log.e(TAG_onDataChange,"snapshot"+Layer_AO +" inexistente");
                }
                Log.d(TAG_onDataChange,"datos leidos "+Layer_AO);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("","datos cancelados"+Layer_AO + error.getMessage());
            }
        };
        mDatosRef.addValueEventListener(mDatosListener);
    }
}


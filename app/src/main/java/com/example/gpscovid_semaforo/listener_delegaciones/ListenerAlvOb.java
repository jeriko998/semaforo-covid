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
    public void AlvOb(Style style){
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mDatosRef=databaseReference.child("ocupacion");
        mDatosListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Float ocu_alo = Float.valueOf(snapshot.child("ocu_alvaroo").getValue().toString());

                if(snapshot.exists()){

                    if(ocu_alo > 70){
                        poligonosMapa.addAlvObLayerRojo(style);
                        Log.e(TAG_onDataChange,"layer rojo"+ Layer_AO);
                    }else if((ocu_alo > 50) && (ocu_alo < 70)){
                        poligonosMapa.addAlvObLayerAmarillo(style);
                        Log.e(TAG_onDataChange,"layer amarillo "+Layer_AO);
                    }else if((ocu_alo > 0) && (ocu_alo < 50)){
                        poligonosMapa.addAlvObLayerVerde(style);
                        Log.e(TAG_onDataChange,"layer verde clase "+ Layer_AO);
                    }else if (ocu_alo == 0){
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


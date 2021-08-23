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

public class ListenerCuauh {
    private final String TAG_onDataChange = "onDataChange";
    private final String Layer= "clase condicional Cuauhtemoc";
    PoligonosMapa poligonosMapa = new PoligonosMapa();
    DatabaseReference databaseReference;
    DatabaseReference mDatosRef;
    private ValueEventListener mDatosListener;

    public void ListenerCuauhtemoc(Style style){
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mDatosRef=databaseReference.child("ocupacion");
        mDatosListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Float ocu_cuauh = Float.valueOf(snapshot.child("ocu_cuauh").getValue().toString());

                if(snapshot.exists()){

                    if(ocu_cuauh > 70){
                        poligonosMapa.addCuauhLayerRojo(style);
                        Log.e(TAG_onDataChange,"layer rojo"+ Layer);
                    }else if((ocu_cuauh > 50) && (ocu_cuauh < 70)){
                        poligonosMapa.addCuauhLayerAmarillo(style);
                        Log.e(TAG_onDataChange,"layer amarillo "+Layer);
                    }else if((ocu_cuauh > 0) && (ocu_cuauh < 50)){
                        poligonosMapa.addCuauhLayerVerde(style);
                        Log.e(TAG_onDataChange,"layer verde clase "+ Layer);
                    }else if (ocu_cuauh == 0){
                        poligonosMapa.addCuauhLayerSinDatos(style);
                        Log.e(TAG_onDataChange,"layer s/d" + Layer);
                    }else{
                        Log.e(TAG_onDataChange,"error en condicionales"+Layer);
                    }

                    Log.d(TAG_onDataChange,"snapshot"+Layer+" existente");
                }else{
                    Log.e(TAG_onDataChange,"snapshot"+Layer +" inexistente");
                }
                Log.d(TAG_onDataChange,"datos leidos "+Layer);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("","datos cancelados"+Layer + error.getMessage());
            }
        };
        mDatosRef.addValueEventListener(mDatosListener);
    }
}
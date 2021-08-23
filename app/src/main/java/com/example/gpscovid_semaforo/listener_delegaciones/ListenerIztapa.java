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

public class ListenerIztapa {
    private final String TAG_onDataChange = "onDataChange";
    private final String Layer= "clase condicional Iztapalapa";
    PoligonosMapa poligonosMapa = new PoligonosMapa();
    DatabaseReference databaseReference;
    DatabaseReference mDatosRef;
    private ValueEventListener mDatosListener;

    public void ListenerIztapaM(Style style){
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mDatosRef=databaseReference.child("ocupacion");
        mDatosListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Float ocu_iztapa = Float.valueOf(snapshot.child("ocu_iztapalapa").getValue().toString());

                if(snapshot.exists()){

                    if(ocu_iztapa > 70){
                        poligonosMapa.addIztapaLayerRojo(style);
                        Log.e(TAG_onDataChange,"layer rojo"+ Layer);
                    }else if((ocu_iztapa > 50) && (ocu_iztapa < 70)){
                        poligonosMapa.addIztapaLayerAmarillo(style);
                        Log.e(TAG_onDataChange,"layer amarillo "+Layer);
                    }else if((ocu_iztapa > 0) && (ocu_iztapa < 50)){
                        poligonosMapa.addIztapaLayerVerde(style);
                        Log.e(TAG_onDataChange,"layer verde clase "+ Layer);
                    }else if (ocu_iztapa == 0){
                        poligonosMapa.addIztapaLayerSD(style);
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

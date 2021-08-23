package com.example.gpscovid_semaforo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mapbox.mapboxsdk.maps.Style;

public class CondicionalAzcapo {

    private String TAG_onDataChange = "onDataChange";
    PoligonosMapa poligonosMapa = new PoligonosMapa();
    DatabaseReference databaseReference;
    DatabaseReference mDatosRef;
    private ValueEventListener mDatosListener;

    public void AzcaListener(Style style){
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mDatosRef=databaseReference.child("ocupacion");
        mDatosListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Float ocu_azca = Float.valueOf(snapshot.child("ocu_azca").getValue().toString());

                if(snapshot.exists()){

                    if(ocu_azca > 70){
                        poligonosMapa.addAzcaLayerRojo(style);
                        Log.e(TAG_onDataChange,"layer rojo clase Condicional Azcapo");
                    }else if((ocu_azca > 50) && (ocu_azca < 70)){
                        poligonosMapa.addAzcaLayerAmarillo(style);
                        Log.e(TAG_onDataChange,"layer amarillo clase Condicional Azcapo");
                    }else if((ocu_azca > 0) && (ocu_azca < 50)){
                        poligonosMapa.addAzcaLayerVerde(style);
                        Log.e(TAG_onDataChange,"layer verde clase Condicional Azcapo");
                    }else if (ocu_azca == 0){
                        poligonosMapa.addAzcaSinDatos(style);
                        Log.e(TAG_onDataChange,"layer s/d clase Condicional Azcapo");
                    }else{
                        Log.e(TAG_onDataChange,"error en condicionales clase Condicional Azcapo");
                    }

                    Log.d(TAG_onDataChange,"snapshot clase Condicional Azcapo existente ");
                }else{
                    Log.e(TAG_onDataChange,"snapshot clase Condicional Azcapo inexistente");
                }
                Log.d(TAG_onDataChange,"datos leidos clase Condicional Azcapo");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("","datos cancelados clase Condicional Azcapo "+ error.getMessage());
            }
        };
        mDatosRef.addValueEventListener(mDatosListener);
    }
}

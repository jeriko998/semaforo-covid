package com.example.gpscovid_semaforo;

import androidx.annotation.NonNull;

import com.mapbox.mapboxsdk.maps.Style;

public class AbrirPoligonos {

    PoligonosMapa poligonosMapa = new PoligonosMapa();

    protected void abrirPoligonos(@NonNull Style style){
        poligonosMapa.createGeoJsonSource(style);
        poligonosMapa.addAlvObLayer(style);
        poligonosMapa.addAzcaLayer(style);
        poligonosMapa.addCuLayer(style);
        poligonosMapa.addTlalpanLayer(style);
        poligonosMapa.addBJLayer(style);
        poligonosMapa.addCoLayer(style);
        poligonosMapa.addCuauhLayer(style);
        poligonosMapa.addGALayer(style);
        poligonosMapa.addXoLayer(style);
        poligonosMapa.addVCLayer(style);
        poligonosMapa.addTlahuacLayer(style);
        poligonosMapa.addMHLayer(style);
        poligonosMapa.addIztacalcoLayer(style);
        poligonosMapa.addIztapalapaLayer(style);
        poligonosMapa.addMCLayer(style);
        poligonosMapa.addMALayer(style);

    }
}

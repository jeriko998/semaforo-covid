package com.example.gpscovid_semaforo;

import com.mapbox.mapboxsdk.maps.Style;

public class CondicionalDele {
    CondicionalAzcapo condicionalAzcapo = new CondicionalAzcapo();
    CondicionalAO condicionalAO = new CondicionalAO();
    public void abrirCondicionales(Style style){
        condicionalAO.AlvOb(style);
        condicionalAzcapo.AzcaListener(style);
    }
}

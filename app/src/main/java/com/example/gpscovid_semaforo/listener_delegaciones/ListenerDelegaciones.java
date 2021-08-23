package com.example.gpscovid_semaforo.listener_delegaciones;

import com.mapbox.mapboxsdk.maps.Style;

public class ListenerDelegaciones {
    ListenerAzca listenerAzca = new ListenerAzca();
    ListenerAlvOb listenerAlvOb = new ListenerAlvOb();
    public void abrirCondicionales(Style style){
        listenerAlvOb.AlvOb(style);
        listenerAzca.AzcaListener(style);
    }
}

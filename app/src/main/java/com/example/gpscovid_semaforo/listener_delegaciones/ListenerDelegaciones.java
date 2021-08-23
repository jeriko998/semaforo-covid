package com.example.gpscovid_semaforo.listener_delegaciones;

import com.mapbox.mapboxsdk.maps.Style;

public class ListenerDelegaciones {
    ListenerAzca listenerAzca = new ListenerAzca();
    ListenerAlvOb listenerAlvOb = new ListenerAlvOb();
    ListenerBenJu listenerBenJu = new ListenerBenJu();



    public void abrirDelegaciones(Style style){
        listenerAlvOb.ListenerAO(style);
        listenerAzca.ListenerAz(style);
        listenerBenJu.ListenerBJ(style);
    }
}

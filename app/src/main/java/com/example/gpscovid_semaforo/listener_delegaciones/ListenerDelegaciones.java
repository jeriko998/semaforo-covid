package com.example.gpscovid_semaforo.listener_delegaciones;

import com.mapbox.mapboxsdk.maps.Style;

public class ListenerDelegaciones {
    ListenerAzca listenerAzca = new ListenerAzca();
    ListenerAlvOb listenerAlvOb = new ListenerAlvOb();
    ListenerBenJu listenerBenJu = new ListenerBenJu();
    ListenerCoyoacan listenerCoyoacan = new ListenerCoyoacan();
    ListenerCuajimalpa listenerCuajimalpa = new ListenerCuajimalpa();
    ListenerCuauh listenerCuauh = new ListenerCuauh();
    ListenerGAM listenerGAM = new ListenerGAM();
    ListenerIztaca listenerIztaca = new ListenerIztaca();
    ListenerIztapa listenerIztapa=new ListenerIztapa();
    ListenerMagC listenerMC = new ListenerMagC();
    ListenerMH listenerMH = new ListenerMH();
    ListenerMilpaAlta listenerMA = new ListenerMilpaAlta();

    public void abrirDelegaciones(Style style){
        listenerAlvOb.ListenerAO(style);
        listenerAzca.ListenerAz(style);
        listenerBenJu.ListenerBJ(style);
        listenerCoyoacan.ListenerCoy(style);
        listenerCuajimalpa.ListenerCu(style);
        listenerCuauh.ListenerCuauhtemoc(style);
        listenerGAM.ListenerGaM(style);
        listenerIztaca.ListenerIztacalcoM(style);
        listenerIztapa.ListenerIztapaM(style);
        listenerMC.ListenerMC(style);
        listenerMH.ListenerMHM(style);
        listenerMA.ListenerMa(style);
    }
}

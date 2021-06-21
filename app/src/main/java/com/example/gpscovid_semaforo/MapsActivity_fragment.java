package com.example.gpscovid_semaforo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.geojson.GeoJsonLayer;
import com.google.maps.android.geojson.GeoJsonPolygonStyle;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;

import java.io.IOException;

public class MapsActivity_fragment extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener {

    public String LOG_TAG;
    public GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_fragment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        Log.d(LOG_TAG, "error");
        Log.i(LOG_TAG, "");

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Agregar marcador de la CDMX
        LatLng cdmx = new LatLng(19.4978, -99.1269);

        //agregar marcador a "cdmx"
        mMap.addMarker(new MarkerOptions().position(cdmx).title(" "));

        //mover pocision de la camara a "cdmx"
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cdmx));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cdmx, 9));


        try {
            GeoJsonLayer layerAO = new GeoJsonLayer(mMap,R.raw.alvaro_obregon_map,this);
            GeoJsonLayer layerAz = new GeoJsonLayer(mMap,R.raw.azcapotzalco_map,this);
            GeoJsonLayer layerBJ = new GeoJsonLayer(mMap,R.raw.benito_juarez_map,this);
            GeoJsonLayer layerCo = new GeoJsonLayer(mMap,R.raw.coyoacan_map,this);
            GeoJsonLayer layerCM = new GeoJsonLayer(mMap,R.raw.cuajimalpa_morelos_map,this);
            GeoJsonLayer layerCu = new GeoJsonLayer(mMap,R.raw.cuauhtemoc_map,this);
            GeoJsonLayer layerGAM = new GeoJsonLayer(mMap,R.raw.gustavo_amadero_map,this);
            GeoJsonLayer layerIztacalco = new GeoJsonLayer(mMap,R.raw.iztacalco_map,this);
            GeoJsonLayer layerIztapalapa = new GeoJsonLayer(mMap,R.raw.iztapalapa_map,this);
            GeoJsonLayer layerMH = new GeoJsonLayer(mMap,R.raw.miguel_hidalgo_map,this);
            GeoJsonLayer layerMA = new GeoJsonLayer(mMap,R.raw.milpa_alta_map,this);
            GeoJsonLayer layerTlahuac = new GeoJsonLayer(mMap,R.raw.tlahuac_map,this);
            GeoJsonLayer layerTlalpan = new GeoJsonLayer(mMap,R.raw.tlalpan_map,this);
            GeoJsonLayer layerVC = new GeoJsonLayer(mMap,R.raw.venustiano_carranza_map,this);
            GeoJsonLayer layerXo = new GeoJsonLayer(mMap,R.raw.xochimilco_map,this);


            //Añadiendo el poligono al con el archivo GeoJson
            GeoJsonPolygonStyle pS_AO=layerAO.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_Az=layerAO.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_Co=layerCo.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_CM=layerCM.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_Cu=layerCu.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_GAM=layerGAM.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_Iztacalco=layerIztacalco.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_Iztapalapa=layerIztapalapa.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_MH=layerMH.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_MA=layerMA.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_Tlahuac=layerTlahuac.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_Tlalpan=layerTlalpan.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_VC=layerVC.getDefaultPolygonStyle();
            GeoJsonPolygonStyle pS_Xo=layerXo.getDefaultPolygonStyle();

            //Se añade el ancho del poligono
            pS_AO.setStrokeWidth(3);
            pS_Az.setStrokeWidth(3);
            pS_Co.setStrokeWidth(3);
            pS_CM.setStrokeWidth(3);
            pS_Cu.setStrokeWidth(3);
            pS_GAM.setStrokeWidth(3);
            pS_Iztacalco.setStrokeWidth(3);
            pS_Iztapalapa.setStrokeWidth(3);
            pS_MH.setStrokeWidth(3);
            pS_MA.setStrokeWidth(3);
            pS_Tlahuac.setStrokeWidth(3);
            pS_Tlalpan.setStrokeWidth(3);
            pS_VC.setStrokeWidth(3);
            pS_Xo.setStrokeWidth(3);

            layerAO.addLayerToMap();
            layerAz.addLayerToMap();
            layerCo.addLayerToMap();
            layerCM.addLayerToMap();
            layerCu.addLayerToMap();
            layerGAM.addLayerToMap();
            layerIztacalco.addLayerToMap();
            layerIztapalapa.addLayerToMap();
            layerMH.addLayerToMap();
            layerMA.addLayerToMap();
            layerTlahuac.addLayerToMap();
            layerTlalpan.addLayerToMap();
            layerVC.addLayerToMap();
            layerXo.addLayerToMap();
            layerBJ.addLayerToMap();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }


    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT)
                .show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

}
package com.example.gpscovid_semaforo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity_fragment extends FragmentActivity implements OnMapReadyCallback {

    private String LOG_TAG;
    private GoogleMap mMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean permisoDenegado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_fragment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Log.d(LOG_TAG, "error");
        Log.i(LOG_TAG, "");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng cdmx = new LatLng(19.4978, -99.1269);
        //agregar marcador a "cdmx"
        mMap.addMarker(new MarkerOptions().position(cdmx).title(" "));
        //mover posicion de la camara a "cdmx"
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cdmx));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cdmx, 9));

        Polygon poligono1 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(19.232728, -99.322420), new LatLng(19.232809, -99.324394), new LatLng(19.264898, -99.323622),
                        new LatLng(19.274864, -99.317356), new LatLng(19.282115, -99.315639), new LatLng(19.286085, -99.316497),
                        new LatLng(19.289974, -99.315668), new LatLng(19.294592, -99.316955), new LatLng(19.313547, -99.300132),
                        new LatLng(19.321971, -99.300218), new LatLng(19.317030, -99.294467), new LatLng(19.321485, -99.290433),
                        new LatLng(19.328855, -99.291205), new LatLng(19.333310, -99.288201), new LatLng(19.336550, -99.284424),
                        new LatLng(19.349832, -99.258074), new LatLng(19.372991, -99.270090), new LatLng(19.392909, -99.238418),
                        new LatLng(19.403676, -99.192241), new LatLng(19.393718, -99.188464), new LatLng(19.382707, -99.191897),
                        new LatLng(19.363598, -99.191210), new LatLng(19.361817, -99.184000), new LatLng(19.364732, -99.177820),
                        new LatLng(19.359550, -99.172327), new LatLng(19.347403, -99.180567), new LatLng(19.346593, -99.182970),
                        new LatLng(19.344487, -99.183828), new LatLng(19.337522, -99.191553), new LatLng(19.333230, -99.200136),
                        new LatLng(19.333473, -99.196703), new LatLng(19.330071, -99.194901), new LatLng(19.322134, -99.195158),
                        new LatLng(19.311928, -99.201424), new LatLng(19.311199, -99.200651), new LatLng(19.305853, -99.206058),
                        new LatLng(19.307959, -99.215671), new LatLng(19.312414, -99.220134), new LatLng(19.320109, -99.221507),
                        new LatLng(19.326832, -99.212752), new LatLng(19.335984, -99.206916), new LatLng(19.337847, -99.207688),
                        new LatLng(19.336632, -99.214640), new LatLng(19.324807, -99.237986), new LatLng(19.328695, -99.243308),
                        new LatLng(19.326994, -99.254981), new LatLng(19.317841, -99.261762), new LatLng(19.313629, -99.266225),
                        new LatLng(19.314439, -99.267942), new LatLng(19.31176596733435, -99.27068858444444),
                        new LatLng(19.307553847739612, -99.27146106057873), new LatLng(19.30496172021836, -99.26940112422065),
                        new LatLng(19.303179608717755, -99.27266269012094), new LatLng(19.301073451913425, -99.27017360035494),
                        new LatLng(19.29912928310485, -99.27171855262348), new LatLng(19.293944720013567, -99.27309184352886),
                        new LatLng(19.28916505501098, -99.27652507077164), new LatLng(19.28527641137328, -99.27369265827927),
                        new LatLng(19.276850700034725, -99.28433566279602), new LatLng(19.270693175369694, -99.28656726051727),
                        new LatLng(19.26866762326038, -99.29274706959151), new LatLng(19.263239019593215, -99.29695277424322),
                        new LatLng(19.256432755795792, -99.31557803214753), new LatLng(19.244196976143325, -99.31806712191354),
                        new LatLng(19.23949689736852, -99.32330279384857), new LatLng(19.23301380977419, -99.32278780975905),
                        new LatLng(19.232728, -99.322420)));
        poligono1.setTag("alvaro");
    }

    public void regresarMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
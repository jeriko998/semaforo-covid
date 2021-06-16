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

        Polygon poligonoAO = googleMap.addPolygon(new PolygonOptions()
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
        poligonoAO.setTag("Alvaro Obregón");

        Polygon poligonoAzca = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(19.475100795302353, -99.22109556568195),new LatLng(19.47129751020387, -99.20684767177292),
                        new LatLng(19.47340146614661, -99.20105410035544),new LatLng(19.47040736672058, -99.19041109526678),
                        new LatLng(19.464661777774985, -99.19058275663917),new LatLng(19.46385252353364, -99.18800783605322),
                        new LatLng(19.461020101878866, -99.188351158798),new LatLng(19.456407194867918, -99.16371775099338),
                        new LatLng(19.459239697097594, -99.16320276687621),new LatLng(19.460858247587883, -99.16105699972124),
                        new LatLng(19.4641762255844, -99.15925455531107),new LatLng(19.462962339072032, -99.15084314806357),
                        new LatLng(19.46506640325027, -99.14311838630566),new LatLng(19.50269216783832, -99.15702295746989),
                        new LatLng(19.50835550411632, -99.17298746510288),new LatLng(19.50625200236078, -99.17710733804041),
                        new LatLng(19.50819369780927, -99.18440294654273),new LatLng(19.50964995368547, -99.18775034330446),
                        new LatLng(19.51110619644783, -99.1920418776144),new LatLng(19.514665845765244, -99.20414400436844),
                        new LatLng(19.512562426095524, -99.20920801485418),new LatLng(19.475100795302353, -99.22109556568195)
                        ));
        poligonoAzca.setTag("Azcapotzalco");

        Polygon poligonoBenJu = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(19.36356654886595, -99.19098169254072),new LatLng(19.363080694776137, -99.18814927989617),
                        new LatLng(19.361785076791566, -99.18634683548598),new LatLng(19.361785076791566, -99.18368608421382),
                        new LatLng(19.363404597663557, -99.17965204196248),new LatLng(19.36534800147404, -99.1778495975523),
                        new LatLng(19.360003585252407, -99.17235643363557),new LatLng(19.35878892077096, -99.17003900510821),
                        new LatLng(19.358626964823173, -99.16840822207043),new LatLng(19.357250332772974, -99.14008409562481),
                        new LatLng(19.39660122858253, -99.13115770426012),new LatLng(19.399110942555684, -99.13107187357393),
                        new LatLng(19.399272858256968, -99.13725168298025),new LatLng(19.402673050761297, -99.13673669886305),
                        new LatLng(19.4032397426029, -99.13759500572505),new LatLng(19.40404929895206, -99.15664941806119),
                        new LatLng(19.397410817964495, -99.17922288853148),new LatLng(19.397248900410332, -99.18188363980363),
                        new LatLng(19.39603451361865, -99.18437272970341),new LatLng(19.395467796681217, -99.18900758675815),
                        new LatLng(19.39352475219929, -99.18849260264095),new LatLng(19.38316145657721, -99.19175416871653),
                        new LatLng(19.373607209173738, -99.1922691528337),new LatLng(19.369234739588197, -99.19192583008892),
                        new LatLng(19.367129434614338, -99.19098169254072),new LatLng(19.36356654886595, -99.19098169254072)
                        ));
        poligonoBenJu.setTag("Benito Juarez");
    }

    public void regresarMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
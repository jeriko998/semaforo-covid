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
        // Agregar marcador de la CDMX
        LatLng cdmx = new LatLng(19.4978, -99.1269);
        //agregar marcador a "cdmx"
        mMap.addMarker(new MarkerOptions().position(cdmx).title(" "));
        //mover pocision de la camara a "cdmx"
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cdmx));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cdmx, 9));

        //Poligono de la delegación Alvaro Obregón
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

        //Poligono de la delegación Azcapotzalco
        Polygon poligonoAzca = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(19.475100795302353, -99.22109556568195), new LatLng(19.47129751020387, -99.20684767177292),
                        new LatLng(19.47340146614661, -99.20105410035544), new LatLng(19.47040736672058, -99.19041109526678),
                        new LatLng(19.464661777774985, -99.19058275663917), new LatLng(19.46385252353364, -99.18800783605322),
                        new LatLng(19.461020101878866, -99.188351158798), new LatLng(19.456407194867918, -99.16371775099338),
                        new LatLng(19.459239697097594, -99.16320276687621), new LatLng(19.460858247587883, -99.16105699972124),
                        new LatLng(19.4641762255844, -99.15925455531107), new LatLng(19.462962339072032, -99.15084314806357),
                        new LatLng(19.46506640325027, -99.14311838630566), new LatLng(19.50269216783832, -99.15702295746989),
                        new LatLng(19.50835550411632, -99.17298746510288), new LatLng(19.50625200236078, -99.17710733804041),
                        new LatLng(19.50819369780927, -99.18440294654273), new LatLng(19.50964995368547, -99.18775034330446),
                        new LatLng(19.51110619644783, -99.1920418776144), new LatLng(19.514665845765244, -99.20414400436844),
                        new LatLng(19.512562426095524, -99.20920801485418), new LatLng(19.475100795302353, -99.22109556568195)
                ));
        poligonoAzca.setTag("Azcapotzalco");

        //Poligono de la delegación Benito Juarez
        Polygon poligonoBenJu = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(19.36356654886595, -99.19098169254072), new LatLng(19.363080694776137, -99.18814927989617),
                        new LatLng(19.361785076791566, -99.18634683548598), new LatLng(19.361785076791566, -99.18368608421382),
                        new LatLng(19.363404597663557, -99.17965204196248), new LatLng(19.36534800147404, -99.1778495975523),
                        new LatLng(19.360003585252407, -99.17235643363557), new LatLng(19.35878892077096, -99.17003900510821),
                        new LatLng(19.358626964823173, -99.16840822207043), new LatLng(19.357250332772974, -99.14008409562481),
                        new LatLng(19.39660122858253, -99.13115770426012), new LatLng(19.399110942555684, -99.13107187357393),
                        new LatLng(19.399272858256968, -99.13725168298025), new LatLng(19.402673050761297, -99.13673669886305),
                        new LatLng(19.4032397426029, -99.13759500572505), new LatLng(19.40404929895206, -99.15664941806119),
                        new LatLng(19.397410817964495, -99.17922288853148), new LatLng(19.397248900410332, -99.18188363980363),
                        new LatLng(19.39603451361865, -99.18437272970341), new LatLng(19.395467796681217, -99.18900758675815),
                        new LatLng(19.39352475219929, -99.18849260264095), new LatLng(19.38316145657721, -99.19175416871653),
                        new LatLng(19.373607209173738, -99.1922691528337), new LatLng(19.369234739588197, -99.19192583008892),
                        new LatLng(19.367129434614338, -99.19098169254072), new LatLng(19.36356654886595, -99.19098169254072)
                ));
        poligonoBenJu.setTag("Benito Juarez");

        //Poligono de la delegación Coyoacan
        Polygon poligonoCoyo = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(19.311675776822977, -99.20116664945104), new LatLng(19.311513774140124, -99.20039417327524),
                        new LatLng(19.306410607473524, -99.20520069170239), new LatLng(19.306653619021056, -99.20562984513337),
                        new LatLng(19.305681570664476, -99.20571567581958), new LatLng(19.304871525954315, -99.20168163356823),
                        new LatLng(19.302117343933272, -99.19490100935852), new LatLng(19.303413435366696, -99.17859317898073),
                        new LatLng(19.30114526861936, -99.16142704174096), new LatLng(19.299606137559998, -99.15893795184121),
                        new LatLng(19.296932875518884, -99.15670635400004), new LatLng(19.297985983962544, -99.15224315720162),
                        new LatLng(19.3008212422329, -99.1476083001469), new LatLng(19.29976815203926, -99.14263012034735),
                        new LatLng(19.308111680725183, -99.13473369721706), new LatLng(19.3016819357757, -99.11754610174722),
                        new LatLng(19.299525130229146, -99.10924198273725), new LatLng(19.300092180479496, -99.10100223686214),
                        new LatLng(19.320423683530322, -99.09919979200555), new LatLng(19.328361193460026, -99.10778286062543),
                        new LatLng(19.337027218124494, -99.11396267015473), new LatLng(19.341481537732, -99.11482097701672),
                        new LatLng(19.350551776408263, -99.12022831024724), new LatLng(19.35767803912293, -99.12203075472803),
                        new LatLng(19.358649778051426, -99.1312146381513), new LatLng(19.356706294404272, -99.13293125187528),
                        new LatLng(19.356463357378217, -99.13387538978337), new LatLng(19.358487822118185, -99.16734935790889),
                        new LatLng(19.359459556221395, -99.17172672290503), new LatLng(19.356706294557004, -99.17310001388422),
                        new LatLng(19.35209042807938, -99.17739154819415), new LatLng(19.349822937058352, -99.17970897672153),
                        new LatLng(19.34731246381211, -99.18065311426972), new LatLng(19.347393447422927, -99.18271305073847),
                        new LatLng(19.343587174269437, -99.18400051103147), new LatLng(19.337189195756586, -99.1912961199848),
                        new LatLng(19.335326446095614, -99.19824840556689), new LatLng(19.3335446656661, -99.20005084997707),
                        new LatLng(19.33362565610738, -99.19644596115671), new LatLng(19.33030501507909, -99.19498683949135),
                        new LatLng(19.321881622847453, -99.19490100880515), new LatLng(19.311675776822977, -99.20116664945104),
                        new LatLng(19.311675776822977, -99.20116664945104)
                ));
        poligonoCoyo.setTag("Coyoacan");

        //Poligono de Cuajimalpa de Morelos
        Polygon poligonoCuajim = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(19.232975297792976, -99.32454396817919),new LatLng(19.264739987583802, -99.3236856613172),
                        new LatLng(19.27446264238623, -99.31767751328327),new LatLng(19.282078319036064, -99.3159608995593),
                        new LatLng(19.285967038623465, -99.31699086779368),new LatLng(19.289693641567514, -99.3159608995593),
                        new LatLng(19.2924480327, -99.31699086779368),new LatLng(19.2956884335149, -99.31733419053849),
                        new LatLng(19.304113175337235, -99.31235601073894),new LatLng(19.306705316306513, -99.31184102662176),
                        new LatLng(19.307353345129822, -99.30978109015298),new LatLng(19.30524724206612, -99.3094377674082),
                        new LatLng(19.31124146414434, -99.30360128074666),new LatLng(19.309621425789874, -99.30154134427791),
                        new LatLng(19.312375481442086, -99.30154134427791),new LatLng(19.31383349212458, -99.30033971467111),
                        new LatLng(19.318207446743322, -99.30222798994059),new LatLng(19.3222572998115, -99.30033971484421),
                        new LatLng(19.317073469900667, -99.2950182122999),new LatLng(19.320475376825797, -99.29330159857592),
                        new LatLng(19.321609330064856, -99.29055501661756),new LatLng(19.324201193634565, -99.29158498485192),
                        new LatLng(19.333434373435704, -99.28849508014879),new LatLng(19.330680672673765, -99.28849508014879),
                        new LatLng(19.33003273633531, -99.28712178916959),new LatLng(19.331166623240822, -99.28746511191439),
                        new LatLng(19.336511984044662, -99.28506185270082),new LatLng(19.33489219621782, -99.28059865701849),
                        new LatLng(19.336188027764763, -99.2800836729013),new LatLng(19.33732187193232, -99.28145696388049),
                        new LatLng(19.34218111522254, -99.26823903785052),new LatLng(19.34201914278772, -99.26823903785052),
                        new LatLng(19.344610682456736, -99.26703740824375),new LatLng(19.34979363833748, -99.25862600099626),
                        new LatLng(19.350279532621784, -99.25965596934913),new LatLng(19.360644919546555, -99.2615442444455),
                        new LatLng(19.36404591858005, -99.26669408561743),new LatLng(19.37068576019963, -99.26617910140006),
                        new LatLng(19.368580473969196, -99.26892568335842),new LatLng(19.373600727003826, -99.2697839902204),
                        new LatLng(19.375382069935487, -99.2630891966969),new LatLng(19.385745860637712, -99.2479829959259),
                        new LatLng(19.390117887027536, -99.24884130278788),new LatLng(19.39319442780697, -99.24678136631911),
                        new LatLng(19.394004034136735, -99.2472963504363),new LatLng(19.393518270822142, -99.25244619160824),
                        new LatLng(19.395299395887534, -99.2546777894494),new LatLng(19.393518270822142, -99.25484945082181),
                        new LatLng(19.392870584147456, -99.25896932375935),new LatLng(19.394165954919416, -99.25965596924894),
                        new LatLng(19.396594747327907, -99.25587941905619),new LatLng(19.399994995799513, -99.25484945082181),
                        new LatLng(19.40323326161271, -99.25587941905619),new LatLng(19.40096648231148, -99.25690938729056),
                        new LatLng(19.402585613606764, -99.25845433964214),new LatLng(19.40436663941855, -99.25776769415258),
                        new LatLng(19.402099875910224, -99.25931264650416),new LatLng(19.398699671426783, -99.26429082630368),
                        new LatLng(19.395461315381443, -99.26686574688965),new LatLng(19.390927508659676, -99.2694406674756),
                        new LatLng(19.38947018682263, -99.27253057217877),new LatLng(19.387850925036393, -99.27321721766836),
                        new LatLng(19.3778111425455, -99.28540517510858),new LatLng(19.376515641660635, -99.28557683648098),
                        new LatLng(19.377001455699762, -99.28798009569455),new LatLng(19.36809463482323, -99.29879476215561),
                        new LatLng(19.36760879422908, -99.29913808490042),new LatLng(19.369390202660842, -99.30119802136917),
                        new LatLng(19.377001455699762, -99.30188466685877),new LatLng(19.377163393390855, -99.30497457156193),
                        new LatLng(19.371495478431235, -99.30806447626509),new LatLng(19.37068576019963, -99.31321431743702),
                        new LatLng(19.366151263757764, -99.3152742539058),new LatLng(19.36663710869631, -99.31699086762977),
                        new LatLng(19.360644919924418, -99.32076741782252),new LatLng(19.358053634951066, -99.31905080409854),
                        new LatLng(19.35837754782459, -99.32282735429129),new LatLng(19.353842709052905, -99.32660390448405),
                        new LatLng(19.339103612466637, -99.33141042291118),new LatLng(19.30670531762656, -99.35681630695535),
                        new LatLng(19.30265507930985, -99.35630132283815),new LatLng(19.29730861118263, -99.34994985205944),
                        new LatLng(19.278027472598247, -99.36488439145805),new LatLng(19.27608302936384, -99.36213780988233),
                        new LatLng(19.274300603458997, -99.3485765614629),new LatLng(19.271059779409363, -99.34600164087693),
                        new LatLng(19.267818891267826, -99.33930684735343),new LatLng(19.26717070594929, -99.33965017009821),
                        new LatLng(19.264091790683253, -99.33793355637427),new LatLng(19.2410791189328, -99.34239675216597),
                        new LatLng(19.237837638372753, -99.3308954402153),new LatLng(19.232651136363494, -99.32677556727776),
                        new LatLng(19.232975297792976, -99.32454396817919)
                ));
        poligonoCuajim.setTag("Cuajimalpa de Morelos");
    }

    public void regresarMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
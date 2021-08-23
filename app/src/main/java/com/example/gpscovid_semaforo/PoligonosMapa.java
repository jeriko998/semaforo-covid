package com.example.gpscovid_semaforo;

import static com.mapbox.mapboxsdk.style.expressions.Expression.eq;
import static com.mapbox.mapboxsdk.style.expressions.Expression.literal;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.FillLayer;
import com.mapbox.mapboxsdk.style.layers.LineLayer;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.net.URI;
import java.net.URISyntaxException;

public class PoligonosMapa {


    // Variables de archivos GeoJSON con referencia
    public static final String GEOJSON_SOURCE_AO = "Alvaro obregon";
    private static final String GEOJSON_SOURCE_AZ = "Azcapotzalco";
    private static final String GEOJSON_SOURCE_BJ = "Benito Juarez";
    private static final String GEOJSON_SOURCE_Co = "Coyoacan";
    private static final String GEOJSON_SOURCE_Cu = "Cuajimalpa";
    private static final String GEOJSON_SOURCE_Cuauh = "Cuauhtemoc";
    private static final String GEOJSON_SOURCE_GA = "Gustavo Amadero";
    private static final String GEOJSON_SOURCE_Iztacalco = "Iztacalco";
    private static final String GEOJSON_SOURCE_Iztapalapa = "Iztapalapa";
    private static final String GEOJSON_SOURCE_MC = "Magdalena Contreras";
    private static final String GEOJSON_SOURCE_MH = "Miguel Hidalgo";
    private static final String GEOJSON_SOURCE_MA = "Milpa Alta";
    private static final String GEOJSON_SOURCE_Tlahuac = "Tlahuac";
    private static final String GEOJSON_SOURCE_Tlalpan = "Tlalpan";
    private static final String GEOJSON_SOURCE_VC = "Venustiano Carranza";
    private static final String GEOJSON_SOURCE_Xo = "Xochimilco";
    private static final String Color_Naranja= "#ff8c00";


    protected void createGeoJsonSource(@NonNull Style loadedMapStyle) {
        try {
            // Cargar informacion respecto a los municipios desde los
            // archivos geojson en la carpeta "assets"
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_AO,
                    new URI("asset://alvaro_obregon_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_AZ,
                    new URI("asset://azcapotzalco_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_BJ,
                            new URI("asset://benito_juarez_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_Co,
                    new URI("asset://coyoacan_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_Cu,
                    new URI("asset://cuajimalpa_morelos_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_Cuauh,
                    new URI("asset://cuauhtemoc_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_GA,
                    new URI("asset://gustavo_amadero_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_Iztacalco,
                    new URI("asset://iztacalco_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_Iztapalapa,
                    new URI("asset://iztapalapa_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_MC,
                    new URI("asset://magdalena_contreras_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_MH,
                    new URI("asset://miguel_hidalgo_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_MA,
                    new URI("asset://milpa_alta_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_Tlahuac,
                    new URI("asset://tlahuac_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_Tlalpan,
                    new URI("asset://tlalpan_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_VC,
                    new URI("asset://venustiano_carranza_map.geojson")));
            loadedMapStyle.addSource(new GeoJsonSource(GEOJSON_SOURCE_Xo,
                    new URI("asset://xochimilco_map.geojson")));
        } catch (URISyntaxException exception) {
            //Timber.d(exception);
        }
    }// fin de createGeoJsonSource


    // Inicio de metodos para cargar la capa en el mapa
    // No cambiar los "layerid"

    public void addAlvObLayerVerde(@NonNull Style loadedMapStyle) {
                FillLayer countryPolygonFillLayer = new FillLayer("polygon alvaro V", GEOJSON_SOURCE_AO);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        countryPolygonFillLayer.getFillOutlineColor();
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("LL AO V",GEOJSON_SOURCE_AO).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addAlvObLayerAmarillo(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon alvaro A", GEOJSON_SOURCE_AO);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        countryPolygonFillLayer.getFillOutlineColor();
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("LL AO A",GEOJSON_SOURCE_AO).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    protected void addAlvObLayerNaranja(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon alvaro N", GEOJSON_SOURCE_AO);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color_Naranja),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        countryPolygonFillLayer.getFillOutlineColor();
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("LL AO N",GEOJSON_SOURCE_AO).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addAlvObLayerRojo(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon alvaro R ", GEOJSON_SOURCE_AO);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        countryPolygonFillLayer.getFillOutlineColor();
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("LL AO R",GEOJSON_SOURCE_AO).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    public void addAlObSinDatos(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("poligon alob sn", GEOJSON_SOURCE_AZ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer AlvOb sn",GEOJSON_SOURCE_AZ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    public void addAzcaLayerVerde(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon azcapo ", GEOJSON_SOURCE_AZ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("Ll A V",GEOJSON_SOURCE_AZ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    public void addAzcaLayerAmarillo(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon azcapo a", GEOJSON_SOURCE_AZ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("LL A A",GEOJSON_SOURCE_AZ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    protected void addAzcaLayerNaranja(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon azcapo a", GEOJSON_SOURCE_AZ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color_Naranja),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("LL AZ N",GEOJSON_SOURCE_AZ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    public void addAzcaLayerRojo(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon azcapo r", GEOJSON_SOURCE_AZ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("LL AZ R",GEOJSON_SOURCE_AZ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    public void addAzcaSinDatos(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon azcapo sn", GEOJSON_SOURCE_AZ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Azcapo sn",GEOJSON_SOURCE_AZ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }





    protected void addBJLayer(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon benito ", GEOJSON_SOURCE_BJ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Benito",GEOJSON_SOURCE_BJ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    protected void addCoLayer(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon coyoacan ", GEOJSON_SOURCE_Co);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Coyoacan",GEOJSON_SOURCE_Co).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    protected  void addCuLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon cuajimalpa ", GEOJSON_SOURCE_Cu);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Cuajimalpa",GEOJSON_SOURCE_Cu).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    protected  void addCuauhLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon cuauhtemoc ", GEOJSON_SOURCE_Cuauh);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Cuauhtemoc",GEOJSON_SOURCE_Cuauh).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }

    protected  void addGALayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Gustavo Amadero ", GEOJSON_SOURCE_GA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Gustavo Amdero",GEOJSON_SOURCE_GA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addIztacalcoLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztacalco ", GEOJSON_SOURCE_Iztacalco);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Iztacalco",GEOJSON_SOURCE_Iztacalco).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addIztapalapaLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztapalapa ", GEOJSON_SOURCE_Iztapalapa);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Iztapalapa",GEOJSON_SOURCE_Iztapalapa).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addMCLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MC ", GEOJSON_SOURCE_MC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MC",GEOJSON_SOURCE_MC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addMHLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MH ", GEOJSON_SOURCE_MH);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MH",GEOJSON_SOURCE_MH).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addMALayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MA ", GEOJSON_SOURCE_MA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MA",GEOJSON_SOURCE_MA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addTlahuacLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlahuac ", GEOJSON_SOURCE_Tlahuac);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Tlahuac",GEOJSON_SOURCE_Tlahuac).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addTlalpanLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlalpan ", GEOJSON_SOURCE_Tlalpan);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Tlalpan",GEOJSON_SOURCE_Tlalpan).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addVCLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon VC ", GEOJSON_SOURCE_VC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer VC",GEOJSON_SOURCE_VC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    protected  void addXoLayer(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Xo ", GEOJSON_SOURCE_Xo);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Xo",GEOJSON_SOURCE_Xo).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
}

package com.example.gpscovid_semaforo;

import static com.mapbox.mapboxsdk.style.expressions.Expression.eq;
import static com.mapbox.mapboxsdk.style.expressions.Expression.literal;

import android.graphics.Color;
import android.util.Log;

import androidx.annotation.NonNull;

import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.FillLayer;
import com.mapbox.mapboxsdk.style.layers.LineLayer;
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
            Log.e("Clase poligonos ","error al cargar archivos GeoJson");
        }
    }// fin de createGeoJsonSource


    // Inicio de metodos para cargar la capa en el mapa
    // No cambiar los "layerid"

    //[INICIO] metodos de Alvaro Obregon
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
        FillLayer countryPolygonFillLayer = new FillLayer("poligon alob sn", GEOJSON_SOURCE_AO);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer AlvOb sn",GEOJSON_SOURCE_AO).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos de capas para Azcapotzalco
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
    }//[FIN]

    //[INICIO] metodos para capas de Benito Juarez
    public void addBJLayerRojo(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("poligono BJ R ", GEOJSON_SOURCE_BJ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Benito R",GEOJSON_SOURCE_BJ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addBJLayerAmarillo(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("poligono BJ A ", GEOJSON_SOURCE_BJ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Benito A",GEOJSON_SOURCE_BJ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addBJLayerVerde(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("poligono BJ V ", GEOJSON_SOURCE_BJ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Benito V",GEOJSON_SOURCE_BJ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addBJSinDatos(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon BJ SD", GEOJSON_SOURCE_BJ);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer BJ SD",GEOJSON_SOURCE_BJ).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Coyoacan
    public void addCoLayerRojo(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon coyoacan R", GEOJSON_SOURCE_Co);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Coyoacan R",GEOJSON_SOURCE_Co).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addCoLayerVerde(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon coyoacan V", GEOJSON_SOURCE_Co);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Coyoacan V",GEOJSON_SOURCE_Co).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addCoLayerAmarillo(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon coyoacan ", GEOJSON_SOURCE_Co);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Coyoacan",GEOJSON_SOURCE_Co).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addCoSinDatos(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon CO SD", GEOJSON_SOURCE_Co);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer CO SD", GEOJSON_SOURCE_Co).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Cuajimalpa
    public  void addCuLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon cuajimalpa R", GEOJSON_SOURCE_Cu);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Cuajimalpa R",GEOJSON_SOURCE_Cu).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public  void addCuLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon cuajimalpa A", GEOJSON_SOURCE_Cu);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Cuajimalpa A",GEOJSON_SOURCE_Cu).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public  void addCuLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon cuajimalpa V", GEOJSON_SOURCE_Cu);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Cuajimalpa V",GEOJSON_SOURCE_Cu).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addCuLayerSinDatos(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Cu SD", GEOJSON_SOURCE_Cu);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Cu SD", GEOJSON_SOURCE_Cu).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Cuauhtemoc
    public  void addCuauhLayerRojo(@NonNull Style loadedMapStyle){
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
    public  void addCuauhLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon cuauhtemoc ", GEOJSON_SOURCE_Cuauh);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Cuauhtemoc",GEOJSON_SOURCE_Cuauh).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public  void addCuauhLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon cuauhtemoc ", GEOJSON_SOURCE_Cuauh);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Cuauhtemoc",GEOJSON_SOURCE_Cuauh).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }
    public void addCuauhLayerSinDatos(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Cuauh SD", GEOJSON_SOURCE_Cuauh);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Cuauh SD", GEOJSON_SOURCE_Cuauh).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Gustavo A Madero
    public  void addGAMLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Gustavo Amadero R", GEOJSON_SOURCE_GA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Gustavo Amdero R",GEOJSON_SOURCE_GA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addGAMLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Gustavo Amadero A", GEOJSON_SOURCE_GA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Gustavo Amdero ",GEOJSON_SOURCE_GA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addGAMLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Gustavo Amadero V", GEOJSON_SOURCE_GA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Gustavo Amdero V",GEOJSON_SOURCE_GA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addGAMLayerSinDatos(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon CAM SD", GEOJSON_SOURCE_GA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer GAM SD", GEOJSON_SOURCE_GA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Iztacalco
    public  void addIztacaLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztacalco R", GEOJSON_SOURCE_Iztacalco);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Iztacalco R",GEOJSON_SOURCE_Iztacalco).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addIztacaLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztacalco A", GEOJSON_SOURCE_Iztacalco);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Iztacalco A",GEOJSON_SOURCE_Iztacalco).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addIztacaLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztacalco V", GEOJSON_SOURCE_Iztacalco);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Iztacalco V",GEOJSON_SOURCE_Iztacalco).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addIztacaLayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztaca SD", GEOJSON_SOURCE_Iztacalco);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Iztaca SD", GEOJSON_SOURCE_Iztacalco).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Iztapalapa
    public  void addIztapaLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztapalapa R", GEOJSON_SOURCE_Iztapalapa);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Iztapalapa R",GEOJSON_SOURCE_Iztapalapa).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addIztapaLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztapalapa A", GEOJSON_SOURCE_Iztapalapa);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Iztapalapa A",GEOJSON_SOURCE_Iztapalapa).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    public  void addIztapaLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Iztapalapa V", GEOJSON_SOURCE_Iztapalapa);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Iztapalapa V",GEOJSON_SOURCE_Iztapalapa).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addIztapaLayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygoN Iztapa SD", GEOJSON_SOURCE_Iztapalapa);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Iztapa SD", GEOJSON_SOURCE_Iztapalapa).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    public  void addMCLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MC R", GEOJSON_SOURCE_MC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MC R",GEOJSON_SOURCE_MC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addMCLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MC R", GEOJSON_SOURCE_MC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MC R",GEOJSON_SOURCE_MC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addMCLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MC V ", GEOJSON_SOURCE_MC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MC V",GEOJSON_SOURCE_MC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addMCLayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygoN MC SD", GEOJSON_SOURCE_MC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer MC SD", GEOJSON_SOURCE_MC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Miguel Hidalgo
    public  void addMHLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MH R", GEOJSON_SOURCE_MH);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MH R",GEOJSON_SOURCE_MH).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addMHLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MH A", GEOJSON_SOURCE_MH);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MH A",GEOJSON_SOURCE_MH).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addMHLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MH V", GEOJSON_SOURCE_MH);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MH V",GEOJSON_SOURCE_MH).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    public void addMHLayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygoN MH SD", GEOJSON_SOURCE_MH);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer MH SD", GEOJSON_SOURCE_MH).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Milpa Alta
    public  void addMALayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MA R", GEOJSON_SOURCE_MA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MA R",GEOJSON_SOURCE_MA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addMALayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MA a", GEOJSON_SOURCE_MA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MA a",GEOJSON_SOURCE_MA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addMALayerVede(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon MA v", GEOJSON_SOURCE_MA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer MA V",GEOJSON_SOURCE_MA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addMALayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygoN Ma SD", GEOJSON_SOURCE_MA);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Ma SD", GEOJSON_SOURCE_MA).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para capas de Tlahuac
    public  void addTlahuacLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlahuac R ", GEOJSON_SOURCE_Tlahuac);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Tlahuac R",GEOJSON_SOURCE_Tlahuac).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addTlahuacLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlahuac A", GEOJSON_SOURCE_Tlahuac);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Tlahuac A",GEOJSON_SOURCE_Tlahuac).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }

    public  void addTlahuacLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlahuac V", GEOJSON_SOURCE_Tlahuac);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Tlahuac V",GEOJSON_SOURCE_Tlahuac).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addTlahuacLayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlahuac SD", GEOJSON_SOURCE_Tlahuac);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Tlahuac SD", GEOJSON_SOURCE_Tlahuac).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metods para capas de Tlalpan
    public  void addTlalpanLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlalpan V", GEOJSON_SOURCE_Tlalpan);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Tlalpan V",GEOJSON_SOURCE_Tlalpan).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addTlalpanLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlalpan A", GEOJSON_SOURCE_Tlalpan);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Tlalpan A",GEOJSON_SOURCE_Tlalpan).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public  void addTlalpanLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlalpan R", GEOJSON_SOURCE_Tlalpan);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Tlalpan R",GEOJSON_SOURCE_Tlalpan).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addTlalpanLayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Tlalpan SD", GEOJSON_SOURCE_Tlalpan);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Tlalpan SD", GEOJSON_SOURCE_Tlalpan).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos capa para Venustiano Carranza
    public void addVCLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon VC R", GEOJSON_SOURCE_VC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer VC R",GEOJSON_SOURCE_VC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addVCLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon VC A", GEOJSON_SOURCE_VC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer VC A",GEOJSON_SOURCE_VC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addVCLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon VC V", GEOJSON_SOURCE_VC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer VC V",GEOJSON_SOURCE_VC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addVCLayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon VC SD", GEOJSON_SOURCE_VC);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer VC SD", GEOJSON_SOURCE_VC).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]

    //[INICIO] metodos para Xochimilco
    public void addXoLayerRojo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Xo R", GEOJSON_SOURCE_Xo);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.RED),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Xo R",GEOJSON_SOURCE_Xo).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addXoLayerAmarillo(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Xo A", GEOJSON_SOURCE_Xo);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.YELLOW),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Xo A",GEOJSON_SOURCE_Xo).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addXoLayerVerde(@NonNull Style loadedMapStyle){
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Xo V", GEOJSON_SOURCE_Xo);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.GREEN),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);

        loadedMapStyle.addLayer(new LineLayer("linelayer Xo V",GEOJSON_SOURCE_Xo).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK))
        );
    }
    public void addXoLayerSD(@NonNull Style loadedMapStyle) {
        FillLayer countryPolygonFillLayer = new FillLayer("polygon Xo SD", GEOJSON_SOURCE_Xo);
        countryPolygonFillLayer.setProperties(
                PropertyFactory.fillColor(Color.LTGRAY),
                PropertyFactory.fillOpacity(.4f));
        countryPolygonFillLayer.setFilter(eq(literal("$type"), literal("Polygon")));
        loadedMapStyle.addLayer(countryPolygonFillLayer);


        loadedMapStyle.addLayer(new LineLayer("linelayer Xo SD", GEOJSON_SOURCE_Xo).withProperties(
                PropertyFactory.lineWidth(.9f),
                PropertyFactory.lineColor(Color.BLACK)));
    }//[FIN]
}

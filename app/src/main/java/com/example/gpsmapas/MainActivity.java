package com.example.gpsmapas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLatitud, txtLongitud;

    GoogleMap mMap;

    private void agregarMarcador(double latitud, double longitud, String titulo) {
        LatLng ubicacion = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(ubicacion).title(titulo));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud=findViewById(R.id.txt_Latitud);
        txtLongitud=findViewById(R.id.txt_Longitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng Chile = new LatLng(-35.675147, -71.542969);
        mMap.addMarker(new MarkerOptions().position(Chile).title("aki me voy a colgar"));

        agregarMarcador(-18.4833871,-70.310538, "UST ARICA");
        agregarMarcador(-20.2397652,-70.1449384, "UST IQUIQUE");
        agregarMarcador(-20.2397652,-70.1449384, "UST IQUIQUE");
        agregarMarcador(-23.6346504,-70.3952542, "UST ANTOFAGASTA");
        agregarMarcador(-29.9051211,-71.2613075, "UST LA SERENA");
        agregarMarcador(-33.0370433,-71.5248022, "UST VIÑA DEL MAR");
        agregarMarcador(-33.4465657,-70.6709836, "UST SANTIAGO");
        agregarMarcador(-35.4287043,-71.6754899, "UST TALCA");
        agregarMarcador(-37.4720519,-72.3565698, "UST CONCEPCION");
        agregarMarcador(-38.7365479,-72.6027667, "UST TEMUCO");
        agregarMarcador(-39.8174128,-73.2357077, "UST VALDIVIA");
        agregarMarcador(-40.5717867,-73.1402901, "UST OSORNO");
        agregarMarcador(-41.4728097,-72.9314069, "UST PTO MONTT");



        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chile));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng){
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

        agregarMarcador(latLng.latitude, latLng.longitude, "Marcador de toque");
    }
    @Override
    public void onMapLongClick(@NonNull LatLng latLng){
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

        agregarMarcador(latLng.latitude, latLng.longitude, "Marcador de toque largo");
    }
}
package com.example.vinoth.activitynavigator;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;


public class Googlemap extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;

    private LocationManager locationManager;
    private Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = locationManager.getLastKnownLocation(provider);
        locationManager.requestLocationUpdates(provider, 2000, 0, this);


    }

    public void showSettingsAlert(String provider) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                Googlemap.this);

        alertDialog.setTitle(provider + " SETTINGS");

        alertDialog.setMessage(provider
                + " is not enabled! Want to go to settings menu?");

        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        Googlemap.this.startActivity(intent);
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }


    @Override public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setBuildingsEnabled(true);
        mMap.setMyLocationEnabled(true);
        LatLng Banglore = new LatLng(12.9165249,77.5925866);
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.9165249,77.5925866)).
                title("Felight Java & Testing Training Institute").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.suv)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.919454,77.616313)).
                title("My Pg").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.921754, 77.620846)).
                title("Madivala").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.carc)));

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(12.920021, 77.606920))   //set center
                .radius(300)   //set radius in meters
                .fillColor(0x4000A300)  //semi-transparent
                .strokeColor(Color.BLUE)
                .strokeWidth(2));

        mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(12.889096, 77.596895), new LatLng(12.888369, 77.599990), new LatLng(12.884395, 77.598295))
                .strokeColor(Color.RED)
                .fillColor(0x4000A300)
                .strokeWidth(2));





        //mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(Banglore ,10));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(Banglore)      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));






    }

    @Override
    public void onLocationChanged(Location location) {

    }

    private void drawMapMaker(Location location) {
        mMap.clear();
        LatLng sydney = new LatLng(location.getLatitude(),location.getLongitude());
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(sydney , 14.0f) );

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}





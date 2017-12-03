package com.example.fpapp.Functions;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fpapp.Activities.MainPage;
import com.example.fpapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by chenxiaojie on 2017-12-01.
 */

public class Location extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(googleServicesAvailable()){
            Toast.makeText(this, "Perfect!", Toast.LENGTH_LONG);
            setContentView(R.layout.location);
            initMap();
        }else{
            // No Google Maps Layout
        }


    }

    private void initMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
    }

    //test google services is abailable or not
    public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        }else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        }else{
            Toast.makeText(this, "Cant connect to play services", Toast.LENGTH_LONG).show();
        }
        return false;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
    }
}

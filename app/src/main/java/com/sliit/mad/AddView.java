package com.sliit.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddView extends FragmentActivity implements OnMapReadyCallback , GoogleMap.OnMapLongClickListener {

    Button add,back;
    EditText name,phone;
    double lon=0,lat=0;

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);

        name = (EditText) findViewById(R.id.txtName);
        phone = (EditText) findViewById(R.id.txtPhone);

        add = (Button) findViewById(R.id.add);
        back = (Button) findViewById(R.id.back);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddView.this,MainActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation(name.getText().toString(),phone.getText().toString())){
                    insertData();
                }
            }
        });

    }

    private void insertData() {

        HashMap<String,String> map= new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("phone",phone.getText().toString());
        map.put("longitude",String.valueOf(lon));
        map.put("latitude",String.valueOf(lat));
        FirebaseDatabase.getInstance().getReference().child("service_stations").push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                name.setText("");
                phone.setText("");
                lon=0;
                lat=0;
                map.clear();
                Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Inserted Unsuccessfully",Toast.LENGTH_LONG).show();
            }
        });

    }

    public boolean validation(String name,String phone){

        if(name.equals("")){
            Toast.makeText(getApplicationContext(),"Enter Name!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(phone.equals("")){
            Toast.makeText(getApplicationContext(),"Enter Phone Number!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(lat==0&&lon==0){
            Toast.makeText(getApplicationContext(),"Map Long Press!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        LatLng sri = new LatLng(7.053540882023482,79.863846);
        map.addMarker(new MarkerOptions().position(sri).title("Long Press for Mark"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sri));
        map.moveCamera(CameraUpdateFactory.zoomTo(12));

        map.setOnMapLongClickListener(this);

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        map.clear();
        map.addMarker(new MarkerOptions().position(latLng));
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        lon=latLng.longitude;
        lat=latLng.latitude;

    }
}
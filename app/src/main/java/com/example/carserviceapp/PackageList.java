package com.example.carserviceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class PackageList extends AppCompatActivity {

    RecyclerView recyclerView;
    PackageAdapter packageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_package_list);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Details> options =
                new FirebaseRecyclerOptions.Builder<Details>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Details"), Details.class)

                        .build();

        packageAdapter = new PackageAdapter(options);
        recyclerView.setAdapter(packageAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        packageAdapter.startListening();

    }

    @Override

    protected void onStop() {
        super.onStop();
        packageAdapter.stopListening();

    }
}
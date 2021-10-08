package com.example.carserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerList extends AppCompatActivity {


    RecyclerView recyclerView;
    CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_customer_list);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Details> options =
                new FirebaseRecyclerOptions.Builder<Details>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Details"), Details.class)

                        .build();

        customerAdapter = new CustomerAdapter(options);
        recyclerView.setAdapter(customerAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        customerAdapter.startListening();

    }

    @Override

    protected void onStop() {
        super.onStop();
        customerAdapter.stopListening();

    }
}

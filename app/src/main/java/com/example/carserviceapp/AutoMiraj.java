package com.example.carserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class AutoMiraj extends AppCompatActivity {

    TextView viewa, viewb, viewc;
    public Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_automiraj);

        viewa = findViewById(R.id.view1);
        viewb = findViewById(R.id.view2);
        viewc = findViewById(R.id.view4);

        String PNo = getIntent().getStringExtra("packageNo");
        String PName = getIntent().getStringExtra("pcompany");
        String PVDetails = getIntent().getStringExtra("pdetails");


        viewa.setText(PNo);
        viewb.setText(PName);
        viewc.setText(PVDetails);

        button4 = findViewById(R.id.btn12);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(AutoMiraj.this, BookNow.class);
                startActivity(intent5);
            }
        });

    }
}
package com.example.carserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class Packages extends AppCompatActivity {

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_packages);



        button1 = findViewById(R.id.btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Packages.this, AutoMiraj.class);
                startActivity(intent1);
            }
        });


/*

        button2 = findViewById(R.id.btn3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Packages.this, Login.class);
                startActivity(intent2);
            }
        });

        button3 = findViewById(R.id.btn4);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Packages.this, Registration.class);
                startActivity(intent3);
            }
        });

*/

        button4 = findViewById(R.id.button9);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Packages.this, PackagesForm.class);
                startActivity(intent4);
            }
        });

        button2 = findViewById(R.id.button12);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Packages.this, PackagesForm.class);
                startActivity(intent1);
            }
        });

        button3 = findViewById(R.id.button13);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Packages.this, PackagesForm.class);
                startActivity(intent1);
            }
        });

    }
}
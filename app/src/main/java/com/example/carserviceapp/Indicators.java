package com.example.carserviceapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Indicators extends AppCompatActivity {

    public Button buttonW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicators);

        buttonW = (Button) findViewById(R.id.button8);
        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(Indicators.this,Warning.class);
                startActivity(intent);*/
            }
        });

    }
}
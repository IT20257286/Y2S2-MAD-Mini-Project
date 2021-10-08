package com.example.carserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginCompany extends AppCompatActivity {

    EditText logincemail,logincpass;
    Button btnlc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_login_company);

        logincemail = findViewById(R.id.logincemail);
        logincpass = findViewById(R.id.logincpass);
        btnlc = findViewById(R.id.btnlc);

        btnlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(logincemail.getText().toString().equals("automiraj@gmail.com")&& logincpass.getText().toString().equals("auto123")){
                    Intent intentc = new Intent(LoginCompany.this, Packages.class);
                    startActivity(intentc);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid Password or Email",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
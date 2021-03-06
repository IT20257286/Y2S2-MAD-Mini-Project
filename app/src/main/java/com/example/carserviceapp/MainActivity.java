package com.example.carserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public Button button;


    EditText eowner, emodel, eno, ephone;
    Button btn_save;
    Client cliObj;
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn11);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });




        eowner = findViewById(R.id.name);
        emodel = findViewById(R.id.model);
        eno = findViewById(R.id.no);
        ephone = findViewById(R.id.phone);
        btn_save = findViewById(R.id.btn1);

        cliObj = new Client();


    }


    public void ClearControls() {

        eowner.setText("");
        emodel.setText("");
        eno.setText("");
        ephone.setText("");
    }

    public void CreateData(View view) {

        dbRef = FirebaseDatabase.getInstance().getReference().child("Client");
        try {
            if (TextUtils.isEmpty(eowner.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(emodel.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter the model name", Toast.LENGTH_LONG).show();


            else if (TextUtils.isEmpty(eno.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter car no", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(ephone.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter valid phone number", Toast.LENGTH_LONG).show();
            else {
                cliObj.setOwner(eowner.getText().toString().trim());
                cliObj.setModel(emodel.getText().toString().trim());
                cliObj.setCarNo(eno.getText().toString().trim());
                cliObj.setPhoneNo(Integer.parseInt(ephone.getText().toString().trim()));

                dbRef.push().setValue(cliObj);
                Toast.makeText(getApplicationContext(), "Data saved Successfully", Toast.LENGTH_LONG).show();
                ClearControls();

            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_LONG).show();

        }
    }
}



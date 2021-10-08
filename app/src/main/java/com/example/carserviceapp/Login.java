package com.example.carserviceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

public class Login extends AppCompatActivity {

    EditText eusername, epassword;
    Button btn20;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_login);


        eusername = findViewById(R.id.user);
        epassword = findViewById(R.id.pass);
        btn20 = findViewById(R.id.btnl1);

        mAuth = FirebaseAuth.getInstance();

//        final EditText user = findViewById(R.id.user);
//        final EditText password = findViewById(R.id.password);
//        final Button login = findViewById(R.id.login);
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String userTxt = user.getText().toString();
//                final String passwordTxt = password.getText().toString();
//
//                if(userTxt.isEmpty() || passwordTxt.isEmpty())
//                {
//                    Toast.makeText(Login.this,"Invalid Email or Password", Toast.LENGTH_SHORT).show();
//                }
//                else {
//
//                }
            //}
        //});

    }
    public void login(View btn20) {

    String Username = (eusername.getText().toString().trim());
    String Password = (epassword.getText().toString().trim());

        mAuth.signInWithEmailAndPassword(Username, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    startActivity(new Intent(Login.this, Home.class));
                } else {
//                    Toast.makeText(getApplicationContext(),"error in sign in",Toast.LENGTH_LONG).show();
                    Snackbar snackbar = Snackbar.make(btn20, "Wrong Email or Password! try again", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }

}
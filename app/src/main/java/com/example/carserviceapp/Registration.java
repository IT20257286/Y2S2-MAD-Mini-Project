
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

public class Registration extends AppCompatActivity {

    public Button button10;

    EditText ecompany, eemail, ephoneno, epassword, ecpassword;
    Button btn1;
    DatabaseReference dbRef;
    private FirebaseAuth mAuth;
    Users uObj;

   //DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://car-service-app-97493-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen


        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        button10 = findViewById(R.id.button6);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent10 = new Intent(Registration.this, Login.class);
                startActivity(intent10);
            }
        });


        //useObj = new Users();

    }

    public void signup(View view) {

        try {
            ecompany = findViewById(R.id.cuser);
            eemail = findViewById(R.id.cemail);
            ephoneno = findViewById(R.id.cphone);
            epassword = findViewById(R.id.cpass);
            ecpassword = findViewById(R.id.crepass);
            btn1 = findViewById(R.id.button11);

                    String Company = (ecompany.getText().toString().trim());
                    String Email = (eemail.getText().toString().trim());
                    String PhoneNo = (ephoneno.getText().toString().trim());
                    String Password = (epassword.getText().toString().trim());
                    String RePassword = (ecpassword.getText().toString().trim());

            mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Users uObj = new Users (Company, Email, PhoneNo, Password, RePassword);
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(uObj).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Snackbar snackbar=Snackbar.make(btn1,"Data Saved successfully for future use", Snackbar.LENGTH_LONG);
                                    snackbar.show();

                                } else {
                                    Snackbar snackbar=Snackbar.make(btn1,"server error in our side sorry for the inconvenience!", Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                }

                            }

                        });
                    } else {
                        Snackbar snackbar=Snackbar.make(btn1,"Check your Internet Connection and try again!!", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
            });
            startActivity(new Intent(this,Login.class));


        } catch (Exception e){
            Toast.makeText(getApplicationContext(),"error"+e,Toast.LENGTH_LONG).show();
        }

    }

/*    public void ClearControls() {

        ecompany.setText("");
        eemail.setText("");
        ephoneno.setText("");
        epassword.setText("");
        ecpassword.setText("");
    }

    public void CreateData(View view) {

        dbRef = FirebaseDatabase.getInstance().getReference().child("Users");
        try {

            *//*if(!epassword.equals(ecpassword)) {
                Toast.makeText(getApplicationContext(),"Passwords are not matching",Toast.LENGTH_SHORT).show();
            }*//*
            if (TextUtils.isEmpty(ecompany.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter your company name", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(eemail.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter the email", Toast.LENGTH_LONG).show();


            else if (TextUtils.isEmpty(ephoneno.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter phone no", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(epassword.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(ecpassword.getText().toString()))
                Toast.makeText(getApplicationContext(), " Re-Enter Password", Toast.LENGTH_LONG).show();


            else {
                useObj.setCompany(ecompany.getText().toString().trim());
                useObj.setEmail(eemail.getText().toString().trim());
                useObj.setPhone(Integer.parseInt(ephoneno.getText().toString().trim()));
                useObj.setPassword(epassword.getText().toString().trim());
                useObj.setRePassword(ecpassword.getText().toString().trim());

                dbRef.push().setValue(useObj);
                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();
                ClearControls();

            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_LONG).show();

        }*/
    //}
}



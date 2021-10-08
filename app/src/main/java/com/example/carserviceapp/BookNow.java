package com.example.carserviceapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.TimeZone;

public class BookNow extends AppCompatActivity {

    TextView edate;
    EditText eowner, emodel, ecar, eno;
    Button btn15,btn16;
    Client cliObj;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        setContentView(R.layout.activity_book_now);
        edate = findViewById(R.id.date);
        eowner = findViewById(R.id.owner);
        emodel = findViewById(R.id.model);
        ecar = findViewById(R.id.carNo);
        eno = findViewById(R.id.phoneO);
        btn15 = findViewById(R.id.book2);
        btn16 = findViewById(R.id.button7);

        cliObj = new Client();

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();
        long today = MaterialDatePicker.todayInUtcMilliseconds();

        CalendarConstraints.Builder constraintBuilder = new CalendarConstraints.Builder();
        constraintBuilder.setValidator(DateValidatorPointForward.now());

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("SELECT A DATE");
        builder.setSelection(today);
        builder.setCalendarConstraints(constraintBuilder.build());
        final MaterialDatePicker materialDatePicker = builder.build();
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                edate.setText("Selected Date : " + materialDatePicker.getHeaderText());
                materialDatePicker.getHeaderText();
            }
        });

    }

    public void ClearControls() {

        eowner.setText("");
        emodel.setText("");
        ecar.setText("");
        eno.setText("");
        edate.setText("");

    }

    public void CreateData(View view) {

        dbRef = FirebaseDatabase.getInstance().getReference().child("Client");
        try {

            /*if(!epassword.equals(ecpassword)) {
                Toast.makeText(getApplicationContext(),"Passwords are not matching",Toast.LENGTH_SHORT).show();
            }*/
            if (TextUtils.isEmpty(eowner.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(emodel.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter Car model", Toast.LENGTH_LONG).show();


            else if (TextUtils.isEmpty(ecar.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter car no", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(eno.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter phone no", Toast.LENGTH_LONG).show();


            else {
                cliObj.setOwner(eowner.getText().toString().trim());
                cliObj.setModel(emodel.getText().toString().trim());
                cliObj.setCarNo(ecar.getText().toString().trim());
                cliObj.setPhone(Integer.parseInt(eno.getText().toString().trim()));
                cliObj.setDate(edate.getText().toString().trim());

                dbRef.push().setValue(cliObj);
                Toast.makeText(getApplicationContext(), "Booked Successfully", Toast.LENGTH_LONG).show();
                ClearControls();

            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_LONG).show();

        }

    }
}
package com.example.carserviceapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText noteNo, noteName, note;
    Button btnSave, btnEdit, btnDelete, btnView;
    DatabaseReference dbRef;
    VehicleNote vNote;

    //button to go to next activity
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Home.class);
                startActivity(intent);
                startActivity(intent);
            }
        });


        noteNo = findViewById(R.id.editTextTextPersonName5);
        noteName = findViewById(R.id.editTextTextPersonName6);
        note = findViewById(R.id.editTextTextMultiLine3);
        btnSave = findViewById(R.id.button);
        btnEdit = findViewById(R.id.button2);
        btnDelete = findViewById(R.id.button3);
        btnView = findViewById(R.id.button4);

        vNote = new VehicleNote();


    }



    private void clearControls(){
        noteNo.setText("");
        noteName.setText("");
        note.setText("");

    }

    public void CreateData(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("vehicle");
        try {
            if (TextUtils.isEmpty(noteNo.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter Note No.", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(noteName.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter Note Name", Toast.LENGTH_LONG).show();

            else if (TextUtils.isEmpty(note.getText().toString()))
                Toast.makeText(getApplicationContext(), "Enter Your Note Here", Toast.LENGTH_LONG).show();
            else {
                vNote.setNoteNo(noteNo.getText().toString().trim());
                vNote.setNoteName(noteName.getText().toString().trim());
                vNote.setNote(note.getText().toString().trim());

                dbRef.push().setValue(vNote);
                Toast.makeText(getApplicationContext(), "Data saved Successfully", Toast.LENGTH_LONG).show();
                clearControls();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_LONG).show();
        }

    }

}
package com.example.carserviceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;import java.util.UUID;

public class PackagesForm extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Button pChooseImage;
    private ImageView pImageView;
    private Uri curl;

    public Button button8;

    FirebaseStorage storage;
    StorageReference storageReference;

    EditText ppackages, pcompany, pdetails, pservicea, pserviceb, pservicec, pserviced, pservicee, pservicef, pserviceg, ppricea,ppriceb,ppricec,ppriced,ppricee,ppricef,ppriceg;
    Button btn5;
    DatabaseReference dbRef;
    Details detObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen


        setContentView(R.layout.activity_packages_form);

        button8 = findViewById(R.id.button);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(PackagesForm.this, PackageList.class);
                startActivity(intent8);
            }
        });


        // initialise views
        pChooseImage = findViewById(R.id.btnChoose);
        pImageView = findViewById(R.id.imgView);

// get the Firebase  storage reference
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

// on pressing ChooseImage SelectImage() is called
        pChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });


        ppackages = findViewById(R.id.packagep);
        pcompany = findViewById(R.id.name2);
        pdetails = findViewById(R.id.details2);
        pservicea = findViewById(R.id.service);
        ppricea = findViewById(R.id.price3);
        pserviceb = findViewById(R.id.service2);
        ppriceb = findViewById(R.id.price4);
        pservicec = findViewById(R.id.service3);
        ppricec = findViewById(R.id.price5);
        pserviced = findViewById(R.id.service4);
        ppriced = findViewById(R.id.price6);
        pservicee = findViewById(R.id.service5);
        ppricee = findViewById(R.id.price7);
        pservicef = findViewById(R.id.service6);
        ppricef = findViewById(R.id.price8);
        pserviceg = findViewById(R.id.service7);
        ppriceg = findViewById(R.id.price9);

        btn5 = findViewById(R.id.button11);

        detObj = new Details();

    }
                public void ClearControls() {

                    ppackages.setText("");
                    pcompany.setText("");
                    pdetails.setText("");
                    pservicea.setText("");
                    ppricea.setText("");
                    pserviceb.setText("");
                    ppriceb.setText("");
                    pservicec.setText("");
                    ppricec.setText("");
                    pserviced.setText("");
                    ppriced.setText("");
                    pservicee.setText("");
                    ppricee.setText("");
                    pservicef.setText("");
                    ppricef.setText("");
                    pserviceg.setText("");
                    ppriceg.setText("");


                }

                public void CreateData(View view) {

                    dbRef = FirebaseDatabase.getInstance().getReference().child("Details");
                    try {

            /*if(!epassword.equals(ecpassword)) {
                Toast.makeText(getApplicationContext(),"Passwords are not matching",Toast.LENGTH_SHORT).show();
            }*/
                        if (TextUtils.isEmpty(ppackages.getText().toString()))
                            Toast.makeText(getApplicationContext(), "Enter Package no", Toast.LENGTH_LONG).show();

                        else if (TextUtils.isEmpty(pcompany.getText().toString()))
                            Toast.makeText(getApplicationContext(), "Enter Company name", Toast.LENGTH_LONG).show();


                        else if (TextUtils.isEmpty(pdetails.getText().toString()))
                            Toast.makeText(getApplicationContext(), "Enter details", Toast.LENGTH_LONG).show();


                        else {
                            detObj.setPackageNo(ppackages.getText().toString().trim());
                            String PackageNo = detObj.getPackageNo();

                            detObj.setPCompany(pcompany.getText().toString().trim());
                            String Company = detObj.getPCompany();

                            detObj.setPDetails(pdetails.getText().toString().trim());
                            String DDetails = detObj.getPDetails();

                            detObj.setServicea(pservicea.getText().toString().trim());
                            String AService = detObj.getServicea();

                            detObj.setPricea(ppricea.getText().toString().trim());
                            String APrice = detObj.getPricea();

                            detObj.setServiceb(pserviceb.getText().toString().trim());
                            String BService = detObj.getServiceb();

                            detObj.setPriceb(ppriceb.getText().toString().trim());
                            String BPrice = detObj.getPriceb();

                            detObj.setServicec(pservicec.getText().toString().trim());
                            String CService = detObj.getServicec();

                            detObj.setPricec(ppricec.getText().toString().trim());
                            String CPrice = detObj.getPricec();

                            detObj.setServiced(pserviced.getText().toString().trim());
                            String DService = detObj.getServiced();

                            detObj.setPriced(ppriced.getText().toString().trim());
                            String DPrice = detObj.getPriced();

                            detObj.setServicee(pservicee.getText().toString().trim());
                            String EService = detObj.getServicee();

                            detObj.setPricee(ppricee.getText().toString().trim());
                            String EPrice = detObj.getPricee();

                            detObj.setServicef(pservicef.getText().toString().trim());
                            String FService = detObj.getServicef();

                            detObj.setPricef(ppricef.getText().toString().trim());
                            String FPrice = detObj.getPricef();

                            detObj.setServiceg(pserviceg.getText().toString().trim());
                            String GService = detObj.getServiceg();

                            detObj.setPriceg(ppriceg.getText().toString().trim());
                            String GPrice = detObj.getPriceg();




                            dbRef.push().getKey();
                            Details detObj = new Details(PackageNo, Company, DDetails,AService,APrice,BService,BPrice,CService,CPrice,DService,DPrice,EService,EPrice,FService,FPrice,GService,GPrice);
                            dbRef.child(String.valueOf(PackageNo)).setValue(detObj);
                            Toast.makeText(PackagesForm.this, "Package added successfully", Toast.LENGTH_SHORT).show();
                            uploadImage();
                            ClearControls();

                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_LONG).show();

                    }
                }
                    // Select Image method
    private void SelectImage()
    {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            curl = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                curl);
                pImageView.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    // UploadImage method
    private void uploadImage() {
        if (curl != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageReference
                    .child(
                            "Details/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(curl)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot) {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(PackagesForm.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(PackagesForm.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot) {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int) progress + "%");
                                }
                            });
        }

                }
}
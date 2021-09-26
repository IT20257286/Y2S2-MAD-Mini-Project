package com.sliit.mad;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> implements OnMapReadyCallback , GoogleMap.OnMapLongClickListener{

    double lon=0,lat=0;

    GoogleMap map;

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final model model)
    {
       holder.name.setText(model.getName());
       holder.phone.setText(model.getPhone());
       holder.longitude.setText(model.getLongitude());
       holder.latitude.setText(model.getLatitude());

                    holder.edit.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onClick(View view) {
                            final DialogPlus dialogPlus=DialogPlus.newDialog(view.getContext())
                                    .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                                    .setExpanded(true,1100)
                                    .create();

                            View myview=dialogPlus.getHolderView();
                            final EditText edit_name= myview.findViewById(R.id.edit_name);
                            final EditText edit_phone= myview.findViewById(R.id.edit_phone);
                            final TextView edit_latitude= myview.findViewById(R.id.edit_latitude);
                            final TextView edit_longitude= myview.findViewById(R.id.edit_longitude);
                            Button submit= myview.findViewById(R.id.edit_button);

                            edit_name.setText(model.getName());
                            edit_phone.setText(model.getPhone());
                            edit_latitude.setText(model.getLatitude());
                            edit_longitude.setText(model.getLongitude());
                            lat = Double.valueOf(model.latitude);
                            lon = Double.valueOf(model.longitude);

                            dialogPlus.show();

                            submit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if (!(edit_name.getText().toString().equals(""))){
                                        if(!(edit_phone.getText().toString().equals(""))){

                                            HashMap<String,Object> map= new HashMap<>();
                                            map.put("name",edit_name.getText().toString());
                                            map.put("phone",edit_phone.getText().toString());
                                            map.put("longitude",String.valueOf(lon));
                                            map.put("latitude",String.valueOf(lat));

                                            FirebaseDatabase.getInstance().getReference().child("service_stations").child(getRef(position).getKey()).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    dialogPlus.dismiss();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    dialogPlus.dismiss();
                                                }
                                            });


                                        }else {
                                            Toast.makeText(view.getContext(),"Enter Phone",Toast.LENGTH_LONG).show();
                                        }
                                    }else {
                                        Toast.makeText(view.getContext(),"Enter Name",Toast.LENGTH_LONG).show();
                                    }

                                }
                            });

                        }
                    });


                    holder.delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                            builder.setTitle("Delete Station");
                            builder.setMessage("Delete...?");

                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    FirebaseDatabase.getInstance().getReference().child("service_stations")
                                            .child(getRef(position).getKey()).removeValue();
                                }
                            });

                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                            builder.show();
                        }
                    });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);

       return new myviewholder(view);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        map.clear();
        map.addMarker(new MarkerOptions().position(latLng));
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        lon=latLng.longitude;
        lat=latLng.latitude;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {



    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        Button edit,delete;
        TextView name,phone,longitude,latitude;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nametext);
            phone=(TextView)itemView.findViewById(R.id.phonetext);
            longitude=(TextView)itemView.findViewById(R.id.longitudetext);
            latitude=(TextView)itemView.findViewById(R.id.latitudetext);

            edit=(Button)itemView.findViewById(R.id.editicon);
            delete=(Button)itemView.findViewById(R.id.deleteicon);

        }

    }
}

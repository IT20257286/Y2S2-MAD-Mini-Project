package com.example.carserviceapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomerAdapter extends FirebaseRecyclerAdapter<Details, CustomerAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */


    public CustomerAdapter(@NonNull FirebaseRecyclerOptions<Details> options) {

        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Details model) {

        holder.item1.setText(model.getPackageNo());
        holder.item2.setText(model.getPCompany());
        holder.item3.setText(model.getPDetails());

        holder.item4.setText(model.getServicea());
        holder.item5.setText(model.getPricea());

        holder.item6.setText(model.getServiceb());
        holder.item7.setText(model.getPriceb());

        holder.item8.setText(model.getServicec());
        holder.item9.setText(model.getPricec());

        holder.item10.setText(model.getServiced());
        holder.item11.setText(model.getPriced());

        holder.item12.setText(model.getServicee());
        holder.item13.setText(model.getPricee());

        holder.item14.setText(model.getServicef());
        holder.item15.setText(model.getPricef());

        holder.item16.setText(model.getServiceg());
        holder.item17.setText(model.getPriceg());


        Glide.with(holder.img.getContext())

                .load(model.getUrl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

       /* holder.pdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.item1.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data cannot be recovered!");



                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Details").child(getRef(position).getKey()).removeValue();
                    }

                });


                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.item1.getContext(),"Cancelled", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();



            }
        });
*/



      holder.pbdetails.setOnClickListener((view)->{

            Intent order = new Intent(holder.item1.getContext(), AutoMiraj.class);
            order.putExtra("packageNo", model.getPackageNo());
           order.putExtra("pcompany", model.getPCompany());
            order.putExtra("pdetails", model.getPDetails());
          order.putExtra("servicea", model.getServicea());
          order.putExtra("serviceb", model.getServiceb());
          order.putExtra("servicec", model.getServicec());
          order.putExtra("serviced", model.getServiced());
          order.putExtra("servicee", model.getServicee());
          order.putExtra("servicef", model.getServicef());

            holder.pbdetails.getContext().startActivity(order);

        });

    }

    @NonNull
    @Override

    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_userpackages,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img;
        TextView item1, item2, item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17;
        Button pbdetails;
        //Button pdelete;

        public myViewHolder(@NonNull View itemView) {

            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            item1 = (TextView)itemView.findViewById(R.id.rname);
            item2 = (TextView)itemView.findViewById(R.id.rcompany);
            item3 = (TextView)itemView.findViewById(R.id.rdetails);

            item4 = (TextView)itemView.findViewById(R.id.textView18);
            item5 = (TextView)itemView.findViewById(R.id.textView19);

            item6 = (TextView)itemView.findViewById(R.id.pservice20);
            item7 = (TextView)itemView.findViewById(R.id.textView21);

            item8 = (TextView)itemView.findViewById(R.id.textView22);
            item9 = (TextView)itemView.findViewById(R.id.textView23);

            item10 = (TextView)itemView.findViewById(R.id.textView24);
            item11 = (TextView)itemView.findViewById(R.id.textView25);

            item12 = (TextView)itemView.findViewById(R.id.textView26);
            item13 = (TextView)itemView.findViewById(R.id.textView27);

            item14 = (TextView)itemView.findViewById(R.id.textView16);
            item15 = (TextView)itemView.findViewById(R.id.textView17);

            item16 = (TextView)itemView.findViewById(R.id.textView28);
            item17 = (TextView)itemView.findViewById(R.id.textView29);


            pbdetails = (Button) itemView.findViewById(R.id.bttn18);
            //pdelete = (Button)itemView.findViewById(R.id.btnDelete);

        }

    }
}


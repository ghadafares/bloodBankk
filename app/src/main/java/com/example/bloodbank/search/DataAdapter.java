package com.example.bloodbank.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodbank.register.Donor;
import com.example.bloodbank.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.holder> {
    ArrayList<Donor> arrItemt;

    public DataAdapter(ArrayList<Donor> arrItemt) {
        this.arrItemt = arrItemt;
    }

    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donor_item, parent, false);
        holder holder = new holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.mname.setText(arrItemt.get(position).getName());
        holder.mphone.append(arrItemt.get(position).getPhone());
        holder.mlocation.append(arrItemt.get(position).getLocation());
        holder.mbloodtype.append(arrItemt.get(position).getBloodType());

    }

    @Override
    public int getItemCount() {
        return arrItemt.size();
    }

    public class holder extends RecyclerView.ViewHolder {

        TextView mname, mphone, mlocation,mbloodtype;

        public holder(@NonNull View itemView) {
            super(itemView);
            mname = itemView.findViewById(R.id.name);
            mphone = itemView.findViewById(R.id.phone);
            mlocation = itemView.findViewById(R.id.location);
            mbloodtype = itemView.findViewById(R.id.bloodtype);

        }
    }
}


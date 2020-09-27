package com.example.bloodbank.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.bloodbank.R;
import com.example.bloodbank.register.Donor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchResults extends AppCompatActivity {

    RecyclerView mrecyclerView;
    DataAdapter adabters;

    FirebaseDatabase database;
    DatabaseReference myRef;
    private String location , bloodType ;
    ArrayList<Donor> result =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);


        //init firebase
        {
            // Write a message to the database
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("donors");
        }

        location = getIntent().getStringExtra("location");
        bloodType = getIntent().getStringExtra("bloodType");

        {
            mrecyclerView = findViewById(R.id.resulr_rv);

            adabters = new DataAdapter(result);
            mrecyclerView.setAdapter(adabters);
            RecyclerView.LayoutManager lm = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            mrecyclerView.setLayoutManager(lm);
        }

        loadData();
    }

    private void loadData() {
        // Read from the database
        myRef.orderByChild("bloodType").equalTo(bloodType)
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                result.clear();
                if(dataSnapshot.exists()){
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                    for(DataSnapshot child  : children ){
                        Donor donor = child.getValue(Donor.class);
                        if(donor.getLocation().equals(location)){
                            result.add(donor);
                            Log.d("TAG", "Value is: " + donor.getName());
                        }
                    }
                    adabters.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}
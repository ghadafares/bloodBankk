package com.example.bloodbank.register;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bloodbank.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterDonor extends AppCompatActivity {

    EditText donorName , donorPhone ;
    Spinner donorLocation , donorBlood ;

    String name , phone , location , bloodType ;

    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //init views
        {
            donorName = findViewById(R.id.doner_name);
            donorPhone = findViewById(R.id.donor_phone);
            donorLocation = findViewById(R.id.donor_location);
            donorBlood = findViewById(R.id.donor_blood_type);
        }

        //init firebase
        {
            // Write a message to the database
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("donors");
        }
    }
    public Boolean validData(){
        name = donorName.getText().toString();
        phone= donorPhone.getText().toString();
        location = donorLocation.getSelectedItem().toString();
        bloodType= donorBlood.getSelectedItem().toString();

        if(name.matches("")){
            donorName.setError("please Enter ur Name");
        }else if(phone.matches("")){
            donorPhone.setError("please Enter ur Phone");
        }else if(donorLocation.getSelectedItemId()==0){
            donorLocation.requestFocus();
            TextView errorText = (TextView)donorLocation.getSelectedView();
            errorText.setError("please choose ur location");
            errorText.setTextColor(Color.RED);
            errorText.setText("please choose ur location");
        }else if(donorBlood.getSelectedItemId()==0){
            donorBlood.requestFocus();
            TextView errorText = (TextView)donorBlood.getSelectedView();
            errorText.setError("please choose ur Blood Type");
            errorText.setTextColor(Color.RED);
            errorText.setText("please choose ur Blood Type");
        }else {
            return true;
        }
        return false;
    }

    public void addDonor(View view) {
        if(validData()){
            Donor donor = new Donor(name , phone , location , bloodType);
            myRef.push().setValue(donor);

            donorName.setText("");
            donorPhone.setText("");
            donorLocation.setSelection(0);
            donorBlood.setSelection(0);
        }

    }
}
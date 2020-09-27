package com.example.bloodbank.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bloodbank.R;

public class SearchActivity extends AppCompatActivity {
  Button btn_search;
    Spinner location , bloodType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bloodType=findViewById(R.id.blood_spinner);
        location=findViewById(R.id.city);

       btn_search=findViewById(R.id.btn_search);
       btn_search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(SearchActivity.this, SearchResults.class);
               intent.putExtra("location" , location.getSelectedItem().toString());
               intent.putExtra("bloodType" ,bloodType.getSelectedItem().toString() );

               if(location.getSelectedItemId()==0){
                   location.requestFocus();
                   TextView errorText = (TextView)location.getSelectedView();
                   errorText.setError("please choose ur location");
                   errorText.setTextColor(Color.RED);
                   errorText.setText("please choose ur location");
               }else if(bloodType.getSelectedItemId()==0){
                   bloodType.requestFocus();
                   TextView errorText = (TextView)bloodType.getSelectedView();
                   errorText.setError("please choose ur Blood Type");
                   errorText.setTextColor(Color.RED);
                   errorText.setText("please choose ur Blood Type");
               }else {
                   startActivity(intent);
               }
           }
       });
    }

}
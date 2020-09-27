package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bloodbank.register.RegisterDonor;
import com.example.bloodbank.search.SearchActivity;

public class login extends AppCompatActivity {
    ImageView iv_newDonor;
    ImageView iv_searchDonor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iv_newDonor = findViewById(R.id.iv_newDonor);
        iv_searchDonor = findViewById(R.id.iv_searchDonor);

        iv_newDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, RegisterDonor.class);
                startActivity(intent);
            }
        });
        iv_searchDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, SearchActivity.class);
                startActivity(intent);
            }
        });

    }
}
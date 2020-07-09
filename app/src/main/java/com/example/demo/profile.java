package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class profile extends AppCompatActivity {
    TextView username, email, mobile, address;
    String username_, email_, mobile_;
    String addressstring;
    Toolbar toolbar;
    JSONObject addressobject;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.phone);
        address = findViewById(R.id.address);

        Bundle b = getIntent().getExtras();
        username_ = b.getString("user");
        email_ = b.getString("email");
        mobile_ = b.getString("mobile");
        addressstring = getIntent().getStringExtra("address");


        toolbar.setTitle(username_);
        email.setText(email_);
        mobile.setText(mobile_);
        try {
            addressobject = new JSONObject(addressstring);
            address.setText(addressobject.getString("street") + ", " + addressobject.getString("suite") + ", " + addressobject.getString("city") + ", " + addressobject.getString("zipcode"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
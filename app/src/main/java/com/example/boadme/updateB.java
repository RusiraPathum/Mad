package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class updateB extends AppCompatActivity {

    private EditText ownerName,phone,price,location,details2,address,email;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_b);

       /*ownerName = findViewById(R.id.ownerName1);
        phone = findViewById(R.id.phone);
        price = findViewById(R.id.price);
        location = findViewById(R.id.location);
        details2 = findViewById(R.id.details2);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);

        update = findViewById(R.id.update);*/
    }
}

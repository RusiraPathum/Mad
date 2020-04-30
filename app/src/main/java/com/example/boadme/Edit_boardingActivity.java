package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_boardingActivity extends AppCompatActivity {

    EditText ownerName,phone,price,location,details2,address,email;
    private Button update;
    private DbHandler dbHandler;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_boarding);

        context = this;
        dbHandler = new DbHandler(context);

        ownerName = findViewById(R.id.ownerName1);
        phone = findViewById(R.id.phone);
        price = findViewById(R.id.price);
        location = findViewById(R.id.location);
        address = findViewById(R.id.address);
        details2 = findViewById(R.id.details2);
        email = findViewById(R.id.email);

        update = findViewById(R.id.update);

        final String id = getIntent().getStringExtra("Id");
        Boarding boarding = dbHandler.getSingleBoarding(Integer.parseInt(id));

        ownerName.setText(boarding.getOwnerName());
        phone.setText(boarding.getPhone());
        price.setText(boarding.getPrice());
        location.setText(boarding.getLocation());
        address.setText(boarding.getAddress());
        details2.setText(boarding.getDetails2());
        email.setText(boarding.getEmail());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String OwnerName = ownerName.getText().toString();
                String Phone = phone.getText().toString();
                String Price = price.getText().toString();
                String Location = location.getText().toString();
                String Details2 = details2.getText().toString();
                String Address = address.getText().toString();
                String Email = email.getText().toString();

               Boarding boarding = new Boarding(Integer.parseInt(id), OwnerName, Phone, Price, Location, Details2,Address,Email);
                int state = dbHandler.updateBoarding(boarding);
                startActivity(new Intent(context,BoardingHome.class));
            }
        });


    }
}

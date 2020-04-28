package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class updateB extends AppCompatActivity {

    private EditText ownerName,phone,price,location,details2,address,email;
    private Button update;
    private DbHandler dbHandler;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_b);

        context = this;
        dbHandler = new DbHandler(context);

        ownerName = findViewById(R.id.ownerName1);
        phone = findViewById(R.id.phone);
        price = findViewById(R.id.price);
        location = findViewById(R.id.location);
        details2 = findViewById(R.id.details2);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);

        update = findViewById(R.id.update);

        final String i = getIntent().getStringExtra("id");
        Boarding boarding = dbHandler.getSingleBoarding(Integer.parseInt(i));

        location.setText(boarding.getLocation());
        price.setText(boarding.getPrice());
        details2.setText(boarding.getDetails2());
        ownerName.setText(boarding.getOwnerName());
        address.setText(boarding.getAddress());
        email.setText(boarding.getEmail());
        phone.setText(boarding.getPhone());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String OwnerName = ownerName.getText().toString();
                String Phone = phone.getText().toString();
                String Price = price.getText().toString();
                String Location = location.getText().toString();
                String Details2 = details2.getText().toString();
                String Address = address.getText().toString();
                String Email = email.getText().toString();

            }
        });

    }
}

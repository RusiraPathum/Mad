package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class getDetails extends AppCompatActivity {

    EditText ownerName,phone,price,location,details2,address,email;
    Button submit;
    private Context context;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_details);

        ownerName = findViewById(R.id.ownerName);
        phone = findViewById(R.id.phone);
        price = findViewById(R.id.price);
        location = findViewById(R.id.location);
        details2 = findViewById(R.id.details2);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);

        submit = findViewById(R.id.submit);

        context = this;
        dbHandler = new DbHandler(context);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String OwnerName = ownerName.getText().toString();
                String Phone = phone.getText().toString();
                String Price = price.getText().toString();
                String Location = location.getText().toString();
                String Details2 = details2.getText().toString();
                String Address = address.getText().toString();
                String Email = email.getText().toString();

                Boarding boarding = new Boarding(OwnerName,Phone,Price,Location,Details2,Address,Email);
                dbHandler.getDetailsBoarding(boarding);


            }
        });



    }
}

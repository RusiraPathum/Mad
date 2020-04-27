package com.example.boadme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class homefeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_homefeedback);
        Button send = findViewById (R.id.fdbutton);
        Button closefd = findViewById (R.id.buttonclosefdhomepage);
       closefd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homefeedbackActivity.this, Addfeedback.class);


                startActivity(intent);

            }
        });
        Button sendRATE = findViewById (R.id.RATE);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homefeedbackActivity.this, Addfeedback.class);


                startActivity(intent);

            }
        });
        sendRATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homefeedbackActivity.this, AddRate.class);


                startActivity(intent);

            }
        });


    }
}
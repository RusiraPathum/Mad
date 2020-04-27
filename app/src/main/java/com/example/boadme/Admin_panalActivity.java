package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin_panalActivity extends AppCompatActivity {

    TextView add_boarding, boarding_list, add_hostal, hostal_list, add_feedback, feedback_list, add_booking, booking_list, login_text;
    Button backtohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panal);

        add_boarding = findViewById(R.id.boarding_panal_addboard);
        boarding_list = findViewById(R.id.boarding_panal_boardinglist);
        add_hostal = findViewById(R.id.hostal_panal_addhostal);
        hostal_list = findViewById(R.id.hostal_panal_hostallist);
        add_feedback = findViewById(R.id.feedback_panal_addfeedback);
        feedback_list = findViewById(R.id.feedback_panal_feedbacklist);
        add_booking = findViewById(R.id.booking_panal_addbooking);
        booking_list = findViewById(R.id.booking_panal_bookinglist);
        login_text = findViewById(R.id.login_text);
        backtohome = findViewById(R.id.backtohome);

        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_panalActivity.this,User_loginActivity.class);
                startActivity(intent);
            }
        });
        
        add_boarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_panalActivity.this,getDetails.class);
                startActivity(intent);
        });
            
        boarding_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_panalActivity.this,displayDetailsB.class);
                startActivity(intent);
            }
        }); 

        add_hostal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_panalActivity.this,Addhostal.class);
                startActivity(intent);
            }
        });

        hostal_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_panalActivity.this,Hostal_listviewActivity.class);
                startActivity(intent);
            }
        });

        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_panalActivity.this,HomepageActivity.class);
                startActivity(intent);
            }
        });
        //feedback panal
        add_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_panalActivity.this,Addfeedback.class);
                startActivity(intent);
            }
        });
        feedback_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_panalActivity.this,Feedback_listviewActivity.class);
                startActivity(intent);
            }
        });
    }
}

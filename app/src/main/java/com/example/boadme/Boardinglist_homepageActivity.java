package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Boardinglist_homepageActivity extends AppCompatActivity {

    Button add_boarding, btn_feedback;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardinglist_homepage);

        add_boarding = findViewById(R.id.add_boarding);
        login = findViewById(R.id.login_text);
        btn_feedback = findViewById(R.id.feedback_btn);

        add_boarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Boardinglist_homepageActivity.this,Addhostal.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Boardinglist_homepageActivity.this,User_loginActivity.class);
                startActivity(intent);
            }
        });
        
        btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Boardinglist_homepageActivity.this,Addfeedback.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomepageActivity extends AppCompatActivity {

    TextView login, boarding, hostal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        login = findViewById(R.id.login_text);
        boarding = findViewById(R.id.textView1);
        hostal = findViewById(R.id.textView2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this,User_loginActivity.class);
                startActivity(intent);
            }
        });

        boarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this,BoardingList_homepage.class);
                startActivity(intent);
            }
        });

        hostal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this,Hostallist_homepageActivity.class);
                startActivity(intent);
            }
        });
    }
}

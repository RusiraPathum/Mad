package com.example.boadme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Hostallist_homepageActivity extends AppCompatActivity {

    Button add_hostal;
    TextView login;
    private ListView listview;
    Context context;
    private DbHandler dbHandler;
    private List<Hostal> hostalList;
    private TextView count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostallist_homepage);

        context = this;
        dbHandler = new DbHandler(context);
        listview = findViewById(R.id.hostal_list);
        count = findViewById(R.id.hostal_count);

        hostalList = new ArrayList<>();
        hostalList = dbHandler.getAllHostal();

        HostalAdapter hostalAdapter = new HostalAdapter(context,R.layout.singale_hostal,hostalList);

        add_hostal = findViewById(R.id.add_hostal);
        login = findViewById(R.id.login_text);

        add_hostal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hostallist_homepageActivity.this,Addhostal.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hostallist_homepageActivity.this,User_loginActivity.class);
                startActivity(intent);
            }
        });

        listview.setAdapter(hostalAdapter);

        int count_Hostal = dbHandler.countHostal();
        count.setText("Available "+count_Hostal+ " Hostal");


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Hostal hostal = hostalList.get(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle(hostal.getOwner_name());
                builder.setMessage(hostal.getHostal_location());


                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(context,Hostallist_homepageActivity.class));
                    }
                });



                builder.setNeutralButton("Book Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context, Edit_hostalActivity.class);
                        intent.putExtra("id", String.valueOf(hostal.getId()));
                        startActivity(intent);


                    }
                });

                builder.show();
            }
        });


    }
}

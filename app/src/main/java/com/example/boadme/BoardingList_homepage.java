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

import java.util.ArrayList;
import java.util.List;

public class BoardingList_homepage extends AppCompatActivity {
   // private Button addNew;
    private ListView listview;
    Context context;
    private DbHandler dbHandler;
    private List<Boarding> boardingList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding_list_homepage);
        context = this;
        dbHandler = new DbHandler(context);

       // addNew = findViewById(R.id.addNew);
        listview = findViewById(R.id.listview);

        boardingList = new ArrayList<>();
        boardingList = dbHandler.displayDetailsB();

        BoardingAdapter boardingAdapter = new BoardingAdapter(context,R.layout.single_boarding,boardingList);

        listview.setAdapter(boardingAdapter);

       /* addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,getDetails.class));

            }
        });*/

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                final Boarding boarding = boardingList.get(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle(boarding.getLocation());
                builder.setMessage(boarding.getDetails2());
                builder.setMessage(boarding.getDetails2());
                builder.setMessage(boarding.getOwnerName());
                builder.setMessage(boarding.getAddress());
                builder.setMessage(boarding.getEmail());
                builder.setMessage(boarding.getPhone());


                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(context,BoardingList_homepage.class));
                    }
                });


                builder.setNeutralButton("Book Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(context,BoardingHome.class));
                    }
                });

                builder.show();
            }
        });

    }
}

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
    private ListView listview;
    Button add_board1, feedback_btn1;
    Context context;
    private DbHandler dbHandler;
    private List<Boarding> boardingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding_list_homepage);
        context = this;
        dbHandler = new DbHandler(context);

        add_board1 = findViewById(R.id.add_board);
        feedback_btn1 = findViewById(R.id.feedback_btn);

        listview = findViewById(R.id.listview);

        boardingList = new ArrayList<>();
        boardingList = dbHandler.displayDetailsB();

        BoardingAdapter boardingAdapter = new BoardingAdapter(context,R.layout.single_boarding,boardingList);

        listview.setAdapter(boardingAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                final Boarding boarding = boardingList.get(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle(boarding.getLocation());
                builder.setMessage(boarding.getPrice());

                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(context,BoardingList_homepage.class));
                    }
                });


                builder.setNeutralButton("Book Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(context,Add.class));
                    }
                });

                builder.show();
            }
        });

        add_board1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BoardingList_homepage.this,getDetails.class);
                startActivity(intent);
            }
        });

        feedback_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BoardingList_homepage.this,Addfeedback.class);
                startActivity(intent);
            }
        });

    }
}

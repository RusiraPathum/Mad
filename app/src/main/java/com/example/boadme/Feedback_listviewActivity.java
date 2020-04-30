package com.example.boadme;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Feedback_listviewActivity extends AppCompatActivity {

    Context context;
    private DbHandler dbHandler;
    private List<Feedback> feedbackList;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setContentView (R.layout.activity_feedback_listview);

      context = this;
        dbHandler = new DbHandler(context);

       Button add = findViewById (R.id.add);

        ListView listview = findViewById (R.id.feedback_list);
        TextView count = findViewById (R.id.feedback_count);

        feedbackList = new ArrayList<>();
        feedbackList = dbHandler.getAllFeedback ();

        Button  closefeedbacklist= findViewById(R.id.buttonclosefeedbacklist);
        closefeedbacklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feedback_listviewActivity.this,HomepageActivity.class);
                startActivity(intent);
            }
        });


        FeedbackAdapter feedbackAdapter = new FeedbackAdapter (context,R.layout.feedbacklayout,feedbackList);

        listview.setAdapter(feedbackAdapter);

        int count_Feedback = dbHandler.countFeedback ();
        count.setText("Available "+count_Feedback+ " Feedbacks");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,Addfeedback.class));
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Feedback feedback = feedbackList.get(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle(feedback.getCustomer_name ());
                builder.setMessage(feedback.getCustomer_email ());


                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(context,Feedback_listviewActivity.class));
                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHandler.deleteFeedback (feedback.getId());
                        startActivity(new Intent(context,Feedback_listviewActivity.class));
                    }
                });

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context, Edit_feedbackActivity.class);
                        intent.putExtra("id", String.valueOf(feedback.getId()));
                        startActivity(intent);


                    }
                });

                builder.show();
            }
        });

    }
}

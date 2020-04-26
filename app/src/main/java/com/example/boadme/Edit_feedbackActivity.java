package com.example.boadme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Edit_feedbackActivity extends AppCompatActivity {

    private EditText customer_name,customer_email,customer_comment;
    private DbHandler dbHandler;
    private Context context;
    private Long updateDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_edit_feedback);

        context = this;
        dbHandler = new DbHandler(context);

        customer_name= findViewById(R.id.edit_edit_name);
        customer_email = findViewById(R.id.edit_edit_email);
        customer_comment = findViewById(R.id.edit_edit_comment);


        Button btnupdate = findViewById (R.id.btnupdate);

        final String id = getIntent().getStringExtra("id");


        final Feedback feedback = dbHandler.getfeedbacklayout (Integer.parseInt(id));

        customer_name.setText(feedback.getCustomer_name ());
        customer_email.setText(feedback.getCustomer_email ());
        customer_comment.setText(feedback.getCustomer_comment ());


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit_name=  customer_name.getText().toString();
                String edit_email =customer_email.getText().toString();
                String edit_comment =customer_comment.getText().toString();


                updateDate = System.currentTimeMillis();

                Feedback feedback= new Feedback (Integer.parseInt(id),edit_name,edit_email,edit_comment,updateDate,0);
                int state = dbHandler.updateFeedback (feedback);
                startActivity(new Intent (context,Feedback_listviewActivity.class));
            }
        });

    }


}

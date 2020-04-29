package com.example.boadme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Button closeupdate = findViewById (R.id.buttoncloseupdate);
        closeupdate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                //Getting the rating and displaying it on the toast

                Intent intent = new Intent(Edit_feedbackActivity.this, Feedback_listviewActivity.class);



                startActivity(intent);

            }

        });
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
                if(edit_name.length ()==0){
                   customer_name.requestFocus ();
                    customer_name.setError("Name cannot be empty");
                    boolean b = false;
                    return;
                }
                String editvalidemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";
                String edit_email =customer_email.getText().toString();
                Matcher matcher= Pattern.compile(editvalidemail).matcher(edit_email);


                if (matcher.matches()){
                    customer_email.setError(null);
                    boolean b = true;



                }
                else {
                    customer_email.setError("Please enter a valid email address");
                    boolean b = false;
                    return;

                }
                String edit_comment =customer_comment.getText().toString();

                if(edit_comment.length ()==0){
                    customer_comment.requestFocus ();
                    customer_comment.setError("Comment cannot be empty");
                    boolean b = false;
                    return;
                }

                updateDate = System.currentTimeMillis();

                Feedback feedback= new Feedback (Integer.parseInt(id),edit_name,edit_email,edit_comment,updateDate,0);
                int state = dbHandler.updateFeedback (feedback);
                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent (context,Feedback_listviewActivity.class));
            }
        });

    }


}

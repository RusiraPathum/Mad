package com.example.boadme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Addfeedback extends AppCompatActivity {

    private EditText editname, editemail, editcomment;

    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_addfeedback);
        editname = findViewById(R.id.editname);
        editemail = findViewById(R.id.editemail);
        editcomment = findViewById(R.id. editcomment);

        Button send = findViewById (R.id.sending);

        Context context = this;
        dbHandler = new DbHandler(context);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Addfeedback.this, Feedback_listviewActivity.class);

                String Name = editname.getText().toString();
                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";


                String Email =  editemail.getText().toString();
                Matcher matcher= Pattern.compile(validemail).matcher(Email);


                if (matcher.matches()){
                    editemail.setError(null);
                    boolean b = true;



                }
                else {
                    editemail.setError("Please enter a valid email address");
                    boolean b = false;
                    return;

                }



                String Comment = editcomment.getText().toString();


                long started = System.currentTimeMillis();

                Feedback feedback  = new Feedback ( Name,Email,Comment,started,0);
                dbHandler.add_Feedback (feedback);

                startActivity(intent);

            }
        });

    }
}

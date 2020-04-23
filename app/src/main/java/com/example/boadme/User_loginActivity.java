package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class User_loginActivity extends AppCompatActivity {

    private EditText email1, password1;
    private TextView register;
    private Button login_btn;
    DbHandel dbHandel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        dbHandel = new DbHandel(this);

        email1 = findViewById(R.id.edit_loginemail);
        password1 = findViewById(R.id.edit_loginpassword);
        login_btn = findViewById(R.id.btn_login);
        register = findViewById(R.id.text_register);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login_email = email1.getText().toString();
                String login_password = password1.getText().toString();

                Boolean chkemailpassword = dbHandel.emaillpassword(login_email,login_password);

                if (chkemailpassword == true){
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(User_loginActivity.this,HomepageActivity.class);
                    startActivity(intent);
                }



                else
                    Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_loginActivity.this,User_registerActivity.class);
                startActivity(intent);
            }
        });

    }
}

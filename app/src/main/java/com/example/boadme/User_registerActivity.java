package com.example.boadme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_registerActivity extends AppCompatActivity {

    DbHandel dbHandel;

    private EditText user_edit_name, user_edit_email, user_edit_password,user_edit_conformpassword;
    private Button add_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        user_edit_name = findViewById(R.id.edit_name);
        user_edit_email = findViewById(R.id.edit_email);
        user_edit_password = findViewById(R.id.edit_password);
        user_edit_conformpassword = findViewById(R.id.edit_confompassword);

        add_user = findViewById(R.id.add_user);

        dbHandel = new DbHandel(this);


        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = user_edit_name.getText().toString();
                String email1 = user_edit_email.getText().toString();
                String password1 = user_edit_password.getText().toString();
                String conformPassword1 = user_edit_conformpassword.getText().toString();

                if (name1.equals("") || email1.equals("") || password1.equals("") || conformPassword1.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password1.equals(conformPassword1)){
                        Boolean chkemail = dbHandel.chkemail(email1);
                        if (chkemail == true){
                            Boolean insert = dbHandel.add_user(name1,email1,password1);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(User_registerActivity.this,User_loginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}

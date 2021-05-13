package com.example.yawaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register_page extends AppCompatActivity {

    EditText text_username, text_password, text_retype_password;
    Button button_register, button_go_back;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        text_username = (EditText) findViewById(R.id.txt_username_2);
        text_password = (EditText) findViewById(R.id.txt_password_2);
        text_retype_password = (EditText) findViewById(R.id.txt_retype_password);
        button_register = (Button) findViewById(R.id.btn_login);
        button_go_back = (Button) findViewById(R.id.btn_signup);
        DB = new DBHelper(this);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = text_username.getText().toString();
                String pass = text_password.getText().toString();
                String repassword = text_retype_password.getText().toString();

                if (user.equals("") || pass.equals("") || repassword.equals(""))
                    Toast.makeText(Register_page.this, "Not all fields are entered", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repassword)) {
                        Boolean checkuser = DB.checkusername(user);

                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);

                            if (insert == true) {
                                Toast.makeText(Register_page.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                               
                            } else {
                                Toast.makeText(Register_page.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Register_page.this, "User Already Registered Please Sign In", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register_page.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        button_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Login_page.class);
                startActivity(intent);

            }
        });
    }
}
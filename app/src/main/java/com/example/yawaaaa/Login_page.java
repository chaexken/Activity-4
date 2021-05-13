package com.example.yawaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login_page extends AppCompatActivity {

    EditText text_username_2, text_password_2;
    Button button_login, button_signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        text_username_2 = (EditText)findViewById(R.id.txt_username_2);
        text_password_2 = (EditText)findViewById(R.id.txt_password_2);

        button_login = (Button) findViewById(R.id.btn_login);
        button_login = (Button) findViewById(R.id.btn_login);

        DB = new DBHelper(this);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register_page.class);
                startActivity(intent);
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = text_username_2.getText().toString();
                String pass = text_password_2.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(Login_page.this, "Not all field are answered", Toast.LENGTH_SHORT).show();

                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);

                    if (checkuserpass = true)
                    {
                        Toast.makeText(Login_page.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login_page.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
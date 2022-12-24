package com.example.error404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class LoginInterface extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_interface);


        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.Login);
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("user") && password.getText().toString().equals("password")) {
                    Toast.makeText(LoginInterface.this, "LOGIN SUCESSFUL", Toast.LENGTH_SHORT).show();
                    openMainScreen();
                } else {
                    Toast.makeText(LoginInterface.this, "LOGIN UNSUCESSFUL", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void openMainScreen() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

package com.example.error404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class SigninInterface extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_interface);

        MaterialButton signUp = (MaterialButton) findViewById(R.id.Signup);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    TextView username = (TextView) findViewById(R.id.username);
                    TextView password = (TextView) findViewById(R.id.password);
                    openMainScreen();
                }
            });
        }






    private void openMainActicity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void openMainScreen() {
        Intent intent = new Intent(this,MainScreen.class);
        startActivity(intent);
    }

    public void back(View view) {
        openMainActicity();
    }
}
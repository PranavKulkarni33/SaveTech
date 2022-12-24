package com.example.error404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.SignIn);
        findViewById(R.id.LogIn);
    }

    public void SignIn(View view) {
        openSigninInterface();
    }
    public void openSigninInterface(){
        Intent intent = new Intent(this, SigninInterface.class);
        startActivity(intent);
    }

    public void LogIn(View view) {
        openLoginInterface();
    }

    private void openLoginInterface() {
        Intent intent = new Intent(this, LoginInterface.class);
        startActivity(intent);
    }
}
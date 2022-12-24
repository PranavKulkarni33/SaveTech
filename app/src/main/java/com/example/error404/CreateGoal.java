package com.example.error404;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CreateGoal extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    public String text;
    public String goalName;
    public String Amount;
    public Button setreminder;
    public double notificationAmount;
    public String notification;
    public CheckBox weeklycheck;
    public CheckBox monthlycheck;
    public double numamount;
    public String checker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_goal);
        Spinner mySpinner = (Spinner) findViewById(R.id.Time);
        weeklycheck = findViewById(R.id.weakcheckBox);
        monthlycheck = findViewById(R.id.monthcheckBox);
        TextView goalname = (TextView) findViewById(R.id.name);
        TextView amount = (TextView) findViewById(R.id.amount);
        goalName = goalname.toString();
        Amount = amount.getText().toString();


        weeklycheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(weeklycheck.isChecked()){
                  if(text.equals("1 Month")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 4;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    if(text.equals("2 Month")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 8;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    if(text.equals("3 Month")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 12;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    if(text.equals("6 Month")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 26;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    if(text.equals("1 Year")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 52;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    checker = "week";


                }
            }
        });

        monthlycheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(monthlycheck.isChecked()){
                    notification = "600";
                    if(text.equals("1 Month")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 1;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    if(text.equals("2 Month")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 2;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    if(text.equals("3 Month")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 3;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    if(text.equals("6 Month")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 6;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    if(text.equals("1 Year")) {
                        notificationAmount = (Double.parseDouble(amount.getText().toString())) / 12;
                        notification = String.valueOf(notificationAmount);
                        notification = String.format("%.2f",notificationAmount);
                    }
                    checker = "month";

                }
            }
        });


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(CreateGoal.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.items));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);

        setreminder = findViewById(R.id.setreminder);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My notification","My notifiction", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        setreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(CreateGoal.this,"My notification");
                builder.setContentTitle("SaveTech");
                builder.setContentText("For your Goal of " + goalname.getText().toString() +". Please transfer "+ notification +" to your Savings account this " + checker + ".");
                builder.setSmallIcon(R.drawable.notificationlogo);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(CreateGoal.this);
                managerCompat.notify(1,builder.build());
            }
        });
    }






    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text + " Selected",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void back(View view) {
        Intent intent = new Intent(this,MainScreen.class);
        startActivity(intent);
    }
}
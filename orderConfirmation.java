package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class orderConfirmation extends AppCompatActivity {
    TextView showResponse;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        showResponse = findViewById(R.id.result);
        Intent intent = getIntent();
        String pizzaType = intent.getStringExtra("TYPE");
        String orderDate = intent.getStringExtra("DATE");
        String orderTime = intent.getStringExtra("TIME");
        showResponse.setText("Congratulations! Your order is placed." + "\npizza type: " + pizzaType + "\nTime of order: " + orderTime + "\nDate of order: " + orderDate);
    }
}
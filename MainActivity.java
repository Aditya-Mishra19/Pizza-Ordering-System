package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Complier
    Spinner pizzaMenu;
    String selectedResponse, dateOfOrder, timeOfOrder;
    String[] pizzaTypes = {"FarmHouse", "Onion", "Tandoori Paneer"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // identity
        pizzaMenu = findViewById(R.id.selectMenu);
        // Spinner
        ArrayAdapter<String> fetchData = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pizzaTypes);
        fetchData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pizzaMenu.setAdapter(fetchData);
        pizzaMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedResponse = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                    //ignore
            }
        });
    }
    public void selectTime(View v){
        Calendar calender = Calendar.getInstance();
        int currHour = calender.get(Calendar.HOUR);
        int currMin = calender.get(Calendar.MINUTE);
        TimePickerDialog clockView = new TimePickerDialog(this, android.R.style.Theme_DeviceDefault_DialogWhenLarge,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        timeOfOrder = hour + " : " + minute; // 4 : 50
                    }
                }, currHour, currMin, false);
        clockView.show();
    }

    public void selectDate(View v) {
        Calendar calender = Calendar.getInstance();
        int currYear = calender.get(Calendar.YEAR);
        int currMonth = calender.get(Calendar.MONTH);
        int currDate = calender.get(Calendar.DATE);
        DatePickerDialog calendarView = new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_DialogWhenLarge,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dateOfMonth) {
                        dateOfOrder = dateOfMonth + "/" + month + "/" + year;
                    }
                }, currYear, currMonth, currDate);
        calendarView.show();

    }
    public void placeOrder(View v) {
        Intent intent = new Intent(getApplicationContext(), orderConfirmation.class);
        intent.putExtra("TYPE", selectedResponse);
        intent.putExtra("DATE", dateOfOrder);
        intent.putExtra("TIME", timeOfOrder);
        startActivity(intent);
    }
}
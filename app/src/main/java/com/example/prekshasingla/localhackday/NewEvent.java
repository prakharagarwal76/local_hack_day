package com.example.prekshasingla.localhackday;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class NewEvent extends AppCompatActivity {
    EditText event, date, location;
    Calendar date1;
    Button save, cancel;
    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;
    FirebaseDatabase mDatabase;
    int mHour;
    int mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        widgets();
        mDatabase=FirebaseDatabase.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(date!=null && location!=null && event!=null) {
                    DatabaseReference ref1 = mDatabase.getReference().child("events");

                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event.setText("");
                date.setText("");
                location.setText("");

            }
        });
    }

    public void widgets() {
        event = (EditText) findViewById(R.id.event);
        date = (EditText) findViewById(R.id.date);
        location = (EditText) findViewById(R.id.location);
        save = (Button) findViewById(R.id.button);
        cancel = (Button) findViewById(R.id.button2);


    }

    private void datePicker() {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        //*************Call Time Picker Here ********************
date.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


}

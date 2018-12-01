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

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.util.Calendar;

public class NewEvent extends AppCompatActivity {
    EditText event, date, location;
    Calendar date1;
    Button save,cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        widgets();
        showDateTimePicker();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateTimePicker();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        save=(Button)findViewById(R.id.button);
        cancel=(Button)findViewById(R.id.button2);



    }

    public void showDateTimePicker() {
        final Calendar currentDate = Calendar.getInstance();
        date1 = Calendar.getInstance();
        new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date1.set(year, monthOfYear, dayOfMonth);
                new TimePickerDialog(getApplicationContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        date1.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        date1.set(Calendar.MINUTE, minute);
                        Log.v("TAG", "The choosen one " + date1.getTime());
                    }
                }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();
            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
    }


}

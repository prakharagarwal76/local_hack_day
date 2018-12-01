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
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class NewEvent extends AppCompatActivity {
    EditText event, date, location, year, month;
    Calendar date1;
    int date12;
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

        mDatabase = FirebaseDatabase.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (date != null && location != null && event != null) {
                    DatabaseReference ref1 = mDatabase.getReference().child("events");
                    EventItem eventItem = new EventItem();
                    eventItem.setDate(Integer.parseInt(date.getText().toString()));
                    eventItem.setLocation(location.getText().toString());
                    eventItem.setTitle(event.getText().toString());
                    eventItem.setMonth(month.getText().toString());
                    eventItem.setYear(Integer.parseInt(year.getText().toString()));
                    eventItem.setSponsor_requirement("Sponsor should provide a quotation on how much they want to sponsor.");
                    eventItem.setOrganiser_requirement("Organiser should be available throughout the event duration. Should have organised some events before. Is responsible for managing the Attendees at the time of event.");
                    eventItem.setVenue_requirement("Organiser should be available throughout the event duration. Should have organised some events before. Is responsible for managing the Attendees at the time of event.");
                    eventItem.setDescription("Come and enjoy at dance night with DJ Polygon. Complimentary snacks and drinks available. Doors open at 9PM.");
                    eventItem.setVenue_requirement("Provide details about the location, size and capacity of the venue.");
                    eventItem.setImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/landscape-green-dance-night-club-event-purple-poster-template-19b1b3d866deade7cff1ce2edfb8dff5_screen.jpg?ts=1456004683");
                    ref1.push().setValue(eventItem);
                    Toast.makeText(getApplicationContext(),"DATA SAVED",Toast.LENGTH_LONG).show();

                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event.setText("");
                date.setText("");
                location.setText("");
                month.setText("");
                year.setText("");


            }
        });
    }

    public void widgets() {
        event = (EditText) findViewById(R.id.event);
        date = (EditText) findViewById(R.id.date);
        year = (EditText) findViewById(R.id.year);
        month = (EditText) findViewById(R.id.month);
        location = (EditText) findViewById(R.id.location);
        save = (Button) findViewById(R.id.button);
        cancel = (Button) findViewById(R.id.button2);


    }


}

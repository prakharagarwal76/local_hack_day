package com.example.prekshasingla.localhackday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_event_detail);
        TextView eventName=findViewById(R.id.event_name);
        TextView eventDate=findViewById(R.id.event_date);
        TextView eventDescription=findViewById(R.id.event_desc);
        TextView eventLocation=findViewById(R.id.event_location);
        Button button=findViewById(R.id.event_button);
        ImageView imageView=findViewById(R.id.event_image);

        Intent intent=getIntent();
        eventName.setText(intent.getStringExtra("title"));
        eventDate.setText(intent.getIntExtra("date",1)+" "+intent.getStringExtra("month")+" "+intent.getIntExtra("year",2018));
        eventDescription.setText(intent.getStringExtra("description"));
        eventLocation.setText(intent.getStringExtra("location"));
        Picasso.with(this)
                .load(intent.getStringExtra("image"))
                .into(imageView);

        if(SharedPreferenceUtil.getInstance(this).getType()==5)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EventDetailActivity.this, "Successfully registered for event", Toast.LENGTH_SHORT).show();
            }
        });
        else
        if(SharedPreferenceUtil.getInstance(this).getType()==1)
        {
            button.setText("Close Event");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(EventDetailActivity.this, "Event has been closed", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else
        if(SharedPreferenceUtil.getInstance(this).getType()==2)
        {
            button.setText("Sponsor Event");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(EventDetailActivity.this, "Your request has been sent to admin", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else
        if(SharedPreferenceUtil.getInstance(this).getType()==3)
        {
            button.setText("Offer Venue");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(EventDetailActivity.this, "Your request has been sent to admin", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else
        if(SharedPreferenceUtil.getInstance(this).getType()==4)
        {
            button.setText("Become Organiser");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(EventDetailActivity.this, "Your request has been sent to admin", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}

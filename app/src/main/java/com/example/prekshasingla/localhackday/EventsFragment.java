package com.example.prekshasingla.localhackday;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    RecyclerView eventsRecycler;
    EventsRecyclerAdapter eventsRecyclerAdapter;
    List<EventItem> eventItemList;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_events, container, false);


//        eventItemList=new ArrayList<>();
//        EventItem eventItem=new EventItem();
//        eventItem.setTitle("Dance Night with DJ Polygon");
//        eventItem.setDate(25);
//        eventItem.setMonth("Feb");
//        eventItem.setYear(2019);
//        eventItem.setLocation("Hauz Khas, Delhi");
//        eventItem.setDescription("Come and enjoy at dance night with DJ Polygon. Complimentary snacks and drinks available. Doors open at 9PM.");
//        eventItem.setImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/landscape-green-dance-night-club-event-purple-poster-template-19b1b3d866deade7cff1ce2edfb8dff5_screen.jpg?ts=1456004683");
//
//        eventItemList.add(eventItem);
//
//        EventItem eventItem1=new EventItem();
//        eventItem1.setTitle("Winter Solstice Lantern Festival");
//        eventItem1.setDate("21");
//        eventItem1.setMonth("Dec");
//        eventItem1.setYear("2018");
//        eventItem1.setLocation("INA, Delhi");
//        eventItem1.setDescription("Come and enjoy at 20th Annual Winter Solstice Lantern Festival. Complimentary snacks and drinks available. Live music also available.");
//        eventItem1.setImage("https://ktnguyen89.files.wordpress.com/2014/08/ws-event-poster-2013.jpg");
//
//        eventItemList.add(eventItem1);
//
//
//        EventItem eventItem2=new EventItem();
//        eventItem2.setTitle("Music and Dance Event");
//        eventItem2.setDate(23);
//        eventItem2.setMonth("March");
//        eventItem2.setYear(2019);
//        eventItem2.setLocation("Central City Hall, Delhi");
//        eventItem2.setDescription("Come and enjoy at the music and dance festival at central city hall. Complimentary snacks and drinks available. Doors open at 6PM.");
//        eventItem2.setImage("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/landscape-concert-with-four-4-singer-poster-template-3ea581c32b2bca035d8df33729c67874_screen.jpg?ts=1458598391");
//        eventItemList.add(eventItem2);
//
//        eventsRecycler=rootView.findViewById(R.id.event_recycler);
//
//
//        eventsRecyclerAdapter=new EventsRecyclerAdapter(eventItemList, getActivity());
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        eventsRecycler.setLayoutManager(mLayoutManager);
//        eventsRecycler.setAdapter(eventsRecyclerAdapter);




        return rootView;
    }

}

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


        eventItemList=new ArrayList<>();
        eventsRecycler=rootView.findViewById(R.id.event_recycler);

        eventsRecyclerAdapter=new EventsRecyclerAdapter(eventItemList, getActivity());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        eventsRecycler.setLayoutManager(mLayoutManager);
        eventsRecycler.setAdapter(eventsRecyclerAdapter);




        return rootView;
    }

}

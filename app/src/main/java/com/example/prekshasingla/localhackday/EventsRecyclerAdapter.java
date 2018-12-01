package com.example.prekshasingla.localhackday;

import android.app.Activity;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsRecyclerAdapter.EventsRecyclerAdapterViewHolder> {

    private List<EventItem> items;
    final private Activity mContext;


    EventsRecyclerAdapter.EventsRecyclerAdapterViewHolder holder;
    private boolean headerEnabled;

    public EventsRecyclerAdapter(List<EventItem> items, Activity mContext) {
        this.items = items;
        this.mContext = mContext;
    }



    @Override
    public EventsRecyclerAdapter.EventsRecyclerAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_events, parent, false);
        holder = new EventsRecyclerAdapter.EventsRecyclerAdapterViewHolder(view);
        return holder;

    }


    @Override
    public void onBindViewHolder(EventsRecyclerAdapter.EventsRecyclerAdapterViewHolder holder, int position) {
        EventItem item= items.get(position);

        Picasso.with(mContext)
                .load(item.getImage())
                .into(holder.imageURL);
        holder.title.setText(item.getTitle());
        holder.location.setText(item.getLocation());
        holder.date.setText(item.getDate());

    }



    @Override
    public int getItemCount() {

        return items.size();
    }


    public class EventsRecyclerAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ImageView imageURL;
        public TextView title;
        public TextView location;
        public TextView date;
        public TextView month;
        public TextView details;


        public EventsRecyclerAdapterViewHolder(View itemView) {
            super(itemView);

            imageURL = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            location=(TextView) itemView.findViewById(R.id.location);
            date=(TextView) itemView.findViewById(R.id.date);
            details=(TextView)itemView.findViewById(R.id.details);
            details.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos=getAdapterPosition();
            Intent intent=new Intent(mContext,EventDetailActivity.class);
            intent.putExtra("title",items.get(pos).getTitle());
            intent.putExtra("location",items.get(pos).getLocation());
//            intent.putExtra("date",items.get(pos).getDate()+" "+items.get(pos).getMonth()+" "+items.get(pos).getYear());

            intent.putExtra("date",items.get(pos).getDate());
            intent.putExtra("month",items.get(pos).getMonth());
            intent.putExtra("year",items.get(pos).getYear());
            intent.putExtra("location", items.get(pos).getLocation());
            intent.putExtra("image",items.get(pos).getImage());
            intent.putExtra("description",items.get(pos).getDescription());
            intent.putExtra("sponsor",items.get(pos).getSponsor());
            intent.putExtra("venue",items.get(pos).getVenue());
            intent.putExtra("organiser",items.get(pos).getOrganiser());




            mContext.startActivity(intent);
        }
    }


    public void addAll(List<EventItem> items) {
        this.items = items;
    }
}

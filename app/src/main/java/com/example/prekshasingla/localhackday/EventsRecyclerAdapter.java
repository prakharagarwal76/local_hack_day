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
//        Picasso.with(mContext)
//                .load(item.getImageURL())
//                .into(holder.imageURL);
//        holder.name.setText(item.getName());
//        holder.quantity.setText("Qty: "+item.getQuantity()+"pc");
//        holder.price.setText("Rs."+item.getPrice()+"/-");
//        holder.customerName.setText("Customer Name: "+item.getCustomerName());
//        holder.address.setText("Address: "+item.getAddress());
//        holder.status.setText("Status: "+item.getStatus());
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
            Intent intent=new Intent(mContext,EventDetailActivity.class);
//            intent.putExtra();
            mContext.startActivity(intent);
        }
    }


    public void addAll(List<EventItem> items) {
        this.items = items;
    }
}

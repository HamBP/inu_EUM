package org.algosketch.eum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FCMRecyclerAdapter extends RecyclerView.Adapter<FCMRecyclerAdapter.FeedHolder> {
    List<FeedVO.Feed> feeds = new ArrayList<>();

    FCMRecyclerAdapter(List<FeedVO.Feed> feeds) {
        this.feeds = feeds;
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new FeedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedHolder holder, int position) {
        holder.field1.setText(feeds.get(position).field1);
        holder.field2.setText(feeds.get(position).field2);
        holder.field3.setText(feeds.get(position).field3);
        holder.dataID.setText(feeds.get(position).entry_id);
        holder.date.setText(feeds.get(position).created_at);
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    class FeedHolder extends RecyclerView.ViewHolder {
        TextView field1;
        TextView field2;
        TextView field3;
        TextView dataID;
        TextView date;
        public FeedHolder(@NonNull View itemView) {
            super(itemView);
            field1 = itemView.findViewById(R.id.field1);
            field2 = itemView.findViewById(R.id.field2);
            field3 = itemView.findViewById(R.id.field3);
            dataID = itemView.findViewById(R.id.data_number);
            date = itemView.findViewById(R.id.created_at);
        }
    }
}

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
    List<FeedVO.Feed> feeds = null;
    List<String> fieldNames = null;

    FCMRecyclerAdapter(List<FeedVO.Feed> feeds, ArrayList<String> fieldNames) {
        this.feeds = feeds;
        this.fieldNames = fieldNames;
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new FeedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedHolder holder, int position) {
        holder.field1.setText(fieldNames.get(0) + " : " + feeds.get(position).field1 + "V");
        holder.field2.setText(fieldNames.get(1) + " : " + feeds.get(position).field2 + "mA");
        holder.field3.setText(fieldNames.get(2) + " : " + feeds.get(position).field3 + "mW");
        holder.dataID.setText("id : " + feeds.get(position).entry_id);
        holder.date.setText("update : " + parseLocaleTime(feeds.get(position).created_at));
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

    String parseLocaleTime(String date) {
        String mmss = "";
        mmss += date.charAt(14);
        mmss += date.charAt(15);
        mmss += ':';
        mmss += date.charAt(17);
        mmss += date.charAt(18);

        String hh = "";
        hh += date.charAt(11);
        hh += date.charAt(12);
        int temp = Integer.parseInt(hh);
        temp = (temp + 9) % 24;
        String zero = temp < 10 ? "0" : ""; // 시간이 10보다 작으면 앞에 0 붙인다.
        return zero + Integer.valueOf(temp) + ":" + mmss;
    }
}

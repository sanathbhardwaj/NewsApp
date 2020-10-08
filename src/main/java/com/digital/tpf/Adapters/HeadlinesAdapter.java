package com.digital.tpf.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.digital.tpf.HeadlineDescriptionActivity;
import com.digital.tpf.R;
import com.digital.tpf.model.HeadlinesModel;

import java.util.List;

public class HeadlinesAdapter extends RecyclerView.Adapter<HeadlinesAdapter.ViewHolder>{

    private List<HeadlinesModel> headlinesModels;
    Context mContext;

    public HeadlinesAdapter(List<HeadlinesModel> headlinesModels) {
        this.headlinesModels = headlinesModels;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.single_headline_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String title = headlinesModels.get(position).getTitle();
        String date = headlinesModels.get(position).getPublishDate();
        holder.setDetails(title, date);

    }

    @Override
    public int getItemCount() {
        return headlinesModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView dateTextView;
        public CardView cardView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), HeadlineDescriptionActivity.class));
                }
            });

        }
        private void setDetails(String title, String date){

            nameTextView.setText(title);
            dateTextView.setText(date);
        }
    }
}

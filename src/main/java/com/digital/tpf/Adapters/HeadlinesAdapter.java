package com.digital.tpf.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    static String image;
    static String content;

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        String title = headlinesModels.get(position).getTitle();
        String date = headlinesModels.get(position).getPublishDate();
        String image = headlinesModels.get(position).getUrlToImage();
        String description = headlinesModels.get(position).getDescription();
        holder.setDetails(title, date, image, description);
    }

    @Override
    public int getItemCount() {
        return headlinesModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView dateTextView;
        public CardView cardView;
        String url;
        Context context;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

            context = itemView.getContext();

//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    itemView.getContext().startActivity(new Intent(itemView.getContext(), HeadlineDescriptionActivity.class)
//                    .putExtra("news", url.get));
//                }
//            });

        }
        private void setDetails(String title, String date, final String image, final String description){

            nameTextView.setText(title);
            dateTextView.setText(date);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(image);
                    System.out.println(description);

                    itemView.getContext().startActivity(new Intent(itemView.getContext(), HeadlineDescriptionActivity.class)
                            .putExtra("image", image)
                            .putExtra("description", description));
                }
            });
        }
    }
}

package com.example.android.ymediacoding.ui.followers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ymediacoding.R;
import com.example.android.ymediacoding.model.Follower;
import com.example.android.ymediacoding.ui.main.MainContract;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Siris on 2/21/2017.
 */

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder> {

    private Context context;
    private List<Follower> followers;
    private OnItemClickListener listener;

    public FollowersAdapter(Context context, List<Follower> followers, OnItemClickListener listener) {
        this.context = context;
        this.followers = followers;
        this.listener = listener;
    }

    @Override
    public FollowersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.follower_item_view, null);
        FollowersViewHolder viewHolder = new FollowersViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FollowersViewHolder holder, int position) {
        Follower follower = followers.get(position);
        Picasso.with(context).load(follower.getAvatarUrl()).into(holder.imgView);
        holder.textView.setText(follower.getLogin());
    }

    @Override
    public int getItemCount() {
        return followers.size();
    }

    class FollowersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView textView;
        protected ImageView imgView;

        public FollowersViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.text_recycler);
            this.imgView = (ImageView) view.findViewById(R.id.img_recycler);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            listener.onItemClick(clickedPosition);
        }
    }
}

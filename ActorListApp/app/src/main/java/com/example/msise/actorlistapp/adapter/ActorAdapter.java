package com.example.msise.actorlistapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.msise.actorlistapp.R;
import com.example.msise.actorlistapp.model.Actor;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder>{
    private List<Actor> mActorList;

    public ActorAdapter(List<Actor> actorList){
        this.mActorList = actorList;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_row, parent, false);
        return new ActorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        Actor currentActor = mActorList.get(position);
        holder.mName.setText(currentActor.getName());
        holder.mFilm.setText(currentActor.getFilm());
    }

    @Override
    public int getItemCount() {
        return mActorList.size();
    }

    public static class ActorViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mFilm;

        public ActorViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.actor_name);
            mFilm = itemView.findViewById(R.id.actor_film);
        }
    }
}

package com.example.msise.actorlistapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.msise.actorlistapp.R
import com.example.msise.actorlistapp.model.Actor

class ActorAdapter(private val mActorList: List<Actor>) : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.actor_row, parent, false)
        return ActorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val currentActor = mActorList[position]
        holder.mName.text = currentActor.name
        holder.mFilm.text = currentActor.film
    }

    override fun getItemCount(): Int {
        return mActorList.size
    }

    class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mName: TextView
        var mFilm: TextView

        init {
            mName = itemView.findViewById(R.id.actor_name)
            mFilm = itemView.findViewById(R.id.actor_film)
        }
    }
}

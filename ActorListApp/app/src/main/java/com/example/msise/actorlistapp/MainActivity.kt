package com.example.msise.actorlistapp

import android.content.res.Configuration
import android.os.Parcelable
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import com.example.msise.actorlistapp.adapter.ActorAdapter
import com.example.msise.actorlistapp.model.Actor

import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var mActorList: MutableList<Actor>? = ArrayList()
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: ActorAdapter? = null
    private var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            mActorList = ArrayList()
        } else {
            mActorList = savedInstanceState.getParcelableArrayList(ACTOR_LIST)
        }
        mRecyclerView = findViewById<View>(R.id.activity_main_rv) as RecyclerView
        if (mActorList != null) {
            mAdapter = ActorAdapter(mActorList!!)
        }
        val mLayoutManager = LinearLayoutManager(applicationContext)
        if (application.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView!!.layoutManager = mLayoutManager
        } else {
            mRecyclerView!!.layoutManager = GridLayoutManager(application, 2)
        }
        mRecyclerView!!.adapter = mAdapter

        fab = findViewById<View>(R.id.activity_main_fab) as FloatingActionButton
        fab!!.setOnClickListener {
            val actor = Actor("John John", "Great Film")
            mActorList!!.add(actor)
            mAdapter!!.notifyDataSetChanged()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (mActorList != null && !mActorList!!.isEmpty()) {
            outState.putParcelableArrayList(ACTOR_LIST, mActorList as ArrayList<out Parcelable>?)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState != null) {
            mActorList = savedInstanceState.getParcelableArrayList(ACTOR_LIST)
        }
    }

    companion object {
        private val ACTOR_LIST = "actor_list"
    }
}

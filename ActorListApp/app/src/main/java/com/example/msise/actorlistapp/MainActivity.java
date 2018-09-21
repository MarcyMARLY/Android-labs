package com.example.msise.actorlistapp;

import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.msise.actorlistapp.adapter.ActorAdapter;
import com.example.msise.actorlistapp.model.Actor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Actor> mActorList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ActorAdapter mAdapter;
    private FloatingActionButton fab;

    private static final String ACTOR_LIST = "actor_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            mActorList = new ArrayList<>();
        }else{
            mActorList = savedInstanceState.getParcelableArrayList(ACTOR_LIST);
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_main_rv);
        mAdapter = new ActorAdapter(mActorList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        if(getApplication().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(mLayoutManager);
        }
        else{
            mRecyclerView.setLayoutManager(new GridLayoutManager(getApplication(), 2));
        }
        mRecyclerView.setAdapter(mAdapter);

        fab = (FloatingActionButton) findViewById(R.id.activity_main_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Actor actor = new Actor("John John", "Great Film");
                mActorList.add(actor);
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mActorList != null && !mActorList.isEmpty()) {
            outState.putParcelableArrayList(ACTOR_LIST, (ArrayList<? extends Parcelable>) mActorList);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            mActorList = savedInstanceState.getParcelableArrayList(ACTOR_LIST);
        }
    }
}

package com.github.corouteam.nappa_kotlin_test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.corouteam.nappa_kotlin_test.R
import com.github.corouteam.nappa_kotlin_test.adapter.RepoListAdapter
import com.github.corouteam.nappa_kotlin_test.model.Repository
import com.github.corouteam.nappa_kotlin_test.viewmodel.RepoListViewModel

class CommitListActivity : AppCompatActivity() {
    val viewModel: RepoListViewModel by viewModels()
    lateinit var commitRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commit_list)
        commitRecyclerView = findViewById(R.id.commitRecyclerView)

        commitRecyclerView.layoutManager = LinearLayoutManager(this)
        //commitRecyclerView.adapter =

    }
}
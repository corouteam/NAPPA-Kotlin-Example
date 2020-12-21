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

class RepoListActivity : AppCompatActivity() {
    val viewModel: RepoListViewModel by viewModels()
    lateinit var repoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)
        repoRecyclerView = findViewById(R.id.repoRecyclerView)

        repoRecyclerView.layoutManager = LinearLayoutManager(this)
        val repo = listOf<Repository>(Repository("Test", "test description", 0, 2, 3))
        repoRecyclerView.adapter = RepoListAdapter(repo)
    }
}
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
import java.util.*

class RepoListActivity : AppCompatActivity() {
    val viewModel: RepoListViewModel by viewModels()
    lateinit var repoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)

        val organizationUid = intent?.getStringExtra("organization") ?: ""

        repoRecyclerView = findViewById(R.id.repoRecyclerView)

        viewModel.initOrganizationId(organizationUid)
        viewModel.getRepoListObservable().observe(this){
            bindView(it)
        }
    }

    fun bindView(listItems: List<Repository>) {
        with (repoRecyclerView) {
            layoutManager = LinearLayoutManager(this@RepoListActivity)
            repoRecyclerView.adapter = RepoListAdapter(listItems)
        }
    }
}
package com.github.corouteam.nappa_kotlin_test.activity

import android.content.Intent
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

        repoRecyclerView = findViewById(R.id.repoRecyclerView)

        viewModel.initOrganizationId(intent?.getStringExtra("organization") ?: "")
        viewModel.getRepoListObservable().observe(this){
            bindView(it)
        }
    }

    fun bindView(listItems: List<Repository>) {
        with (repoRecyclerView) {
            layoutManager = LinearLayoutManager(this@RepoListActivity)
            repoRecyclerView.adapter = RepoListAdapter(listItems) {
                openCommitActivity(viewModel.organizationId, it.name)
            }
        }
    }

    fun openCommitActivity(owner: String, repo: String) {
        val intent = Intent(this, CommitListActivity::class.java)
        intent.putExtra("name", owner)
        intent.putExtra("repo", repo)

        startActivity(intent)
    }
}
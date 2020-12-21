package com.github.corouteam.nappa_kotlin_test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.corouteam.nappa_kotlin_test.R
import com.github.corouteam.nappa_kotlin_test.adapter.ListItemAdapter
import com.github.corouteam.nappa_kotlin_test.model.ListItem
import com.github.corouteam.nappa_kotlin_test.viewmodel.CommitViewModel


class CommitListActivity : AppCompatActivity() {
    private val viewModel: CommitViewModel by viewModels()
    lateinit var commitRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commit_list)
        commitRecyclerView = findViewById(R.id.commitRecyclerView)

        val repo = intent?.getStringExtra("repo") ?: ""
        val name = intent?.getStringExtra("name") ?: ""

        viewModel.getCommitListObservable(name, repo).observe(this) {
            bindView(it)
        }

    }

    fun bindView(listItems: List<ListItem>) {
        with (commitRecyclerView) {
            adapter = ListItemAdapter(listItems){}
            layoutManager = LinearLayoutManager(this@CommitListActivity)
        }
    }
}
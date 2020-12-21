package com.github.corouteam.nappa_kotlin_test.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.corouteam.nappa_kotlin_test.R
import com.github.corouteam.nappa_kotlin_test.adapter.ListItemAdapter
import com.github.corouteam.nappa_kotlin_test.model.ListItem
import com.github.corouteam.nappa_kotlin_test.viewmodel.OrganizationViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: OrganizationViewModel by viewModels()

    private lateinit var searchButton: ImageView
    private lateinit var organizationRecyclerView: RecyclerView
    private lateinit var searchText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.searchButton)
        organizationRecyclerView = findViewById(R.id.organizationRecyclerView)
        searchText = findViewById(R.id.searchText)

        searchButton.setOnClickListener {
            openRepoListActivity(searchText.text.toString())
        }

        viewModel.getOrganizationListObservable().observe(this) {
            bindView(it)
        }
    }

    private fun bindView(listItems: List<ListItem>) {
        with (organizationRecyclerView) {
            adapter = ListItemAdapter(listItems) {
                openRepoListActivity(it.name)
            }
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun openRepoListActivity(name: String) {
        val intent = Intent(this, RepoListActivity::class.java)
        intent.putExtra("organization", name)
        startActivity(intent)
    }
}
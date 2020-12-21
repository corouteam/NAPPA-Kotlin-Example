package com.github.corouteam.nappa_kotlin_test.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.corouteam.nappa_kotlin_test.R
import com.github.corouteam.nappa_kotlin_test.model.ListItem
import com.github.corouteam.nappa_kotlin_test.viewmodel.OrganizationViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: OrganizationViewModel by viewModels()

    private lateinit var searchButton: ImageView
    private lateinit var organizationRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.searchButton)
        val intent = Intent(this, RepoListActivity::class.java)
        searchButton.setOnClickListener {
            startActivity(intent)
        }

        viewModel.getOrganizationListObservable().observe(this) {

        }
    }

    fun bindView(listItems: List<ListItem>) {
        with (organizationRecyclerView) {
            adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}
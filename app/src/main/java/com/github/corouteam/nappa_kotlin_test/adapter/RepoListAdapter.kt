package com.github.corouteam.nappa_kotlin_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.corouteam.nappa_kotlin_test.R
import com.github.corouteam.nappa_kotlin_test.model.Repository


class RepoListAdapter(private val dataSet: List<Repository>,
                      val onClick: (selected: Repository) -> Unit) :
    RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val rootLayout: View = view.findViewById(R.id.rootView)
         val repoTitle: TextView = view.findViewById(R.id.repoTitle)
         val repoDescription: TextView = view.findViewById(R.id.repoDesc)
         val starCount: TextView = view.findViewById(R.id.starCount)
         val forkCount: TextView = view.findViewById(R.id.forkCount)
         val viewersCount: TextView = view.findViewById(R.id.viewersCount)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_repo_overview, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.repoTitle.text = dataSet[position].name
        viewHolder.repoDescription.text = dataSet[position].description
        viewHolder.forkCount.text = "${dataSet[position].forks_count}"
        viewHolder.starCount.text = "${dataSet[position].stargazers_count}"
        viewHolder.viewersCount.text = "${dataSet[position].watchers_count}"
        viewHolder.rootLayout.setOnClickListener { onClick(dataSet[position]) }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

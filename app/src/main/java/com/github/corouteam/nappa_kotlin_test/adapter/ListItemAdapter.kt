package com.github.corouteam.nappa_kotlin_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.corouteam.nappa_kotlin_test.R
import com.github.corouteam.nappa_kotlin_test.model.ListItem

class ListItemAdapter(
    private val dataSet: List<ListItem>,
    private val onClick: (selectedItem: ListItem) -> Unit
) :
    RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rootView: View = view.findViewById(R.id.layoutRoot)
        val repoTitle: TextView = view.findViewById(R.id.repoTitle)
        val repoDescription: TextView = view.findViewById(R.id.repoDesc)
        val metric: TextView = view.findViewById(R.id.metric)
        val metricDescription: TextView = view.findViewById(R.id.metricDescription)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.repoTitle.text = dataSet[position].name
        viewHolder.repoDescription.text = dataSet[position].description

        if (dataSet[position].metric != 0) {
            with (viewHolder.metric) {
                text = "${dataSet[position].metric}"
                visibility = View.VISIBLE
            }
        } else { viewHolder.metric.visibility = View.GONE }

        viewHolder.metricDescription.text = "${dataSet[position].metricDescription}"

        viewHolder.rootView.setOnClickListener { onClick(dataSet[position]) }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

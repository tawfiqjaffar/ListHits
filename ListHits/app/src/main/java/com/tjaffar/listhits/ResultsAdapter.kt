package com.tjaffar.listhits

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.list_layout.view.*

class ResultsAdapter(private val items: ArrayList<SearchInfoList>,
                     private val context : Context)
    : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = items[position]

        holder.listTitle.text = result.title
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ArticlePageDisplay::class.java).apply {
                putExtra(EXTRA_ITEM, "test")
            }
            context.startActivity(intent)
        }

    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val listTitle : TextView = view.list_title
}
package com.tjaffar.listhits

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.list_layout.view.*

class ResultsAdapter(private val items: ArrayList<SearchInfoList>, val context : Context)
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
        holder.listTitle.text = items.get(position).title
//        val result = items[position]

//        holder.listTitle.text = result.title
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val listTitle = view.list_title
}
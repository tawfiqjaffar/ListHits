package com.tjaffar.listhits

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.list_layout.view.*

class ResultsAdapter(private val items: ArrayList<SearchInfoList>,
                     private val context : Context)
    : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = items[position]

        holder.listTitle.text = result.title
        holder.itemView.setOnClickListener {
            val intent = Intent(context.applicationContext, ArticlePageDisplay::class.java)

            intent.putExtra(EXTRA_ITEM, result)
            context.startActivity(intent)
        }
    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val listTitle : TextView = view.list_title
}
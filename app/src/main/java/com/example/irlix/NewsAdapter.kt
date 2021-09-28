package com.example.irlix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.irlix.network.Results

class NewsAdapter(val news: List<Results>): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        return holder.bind(news[position])
    }
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val title:TextView = itemView.findViewById(R.id.movie_title)
    private val description:TextView = itemView.findViewById(R.id.movie_overview)
    private val rating: TextView = itemView.findViewById(R.id.movie_rating)

    fun bind(news: Results){
        title.text = "Title: "+news.title
        description.text = news.description
        rating.text = "pDate : "+news.pubDate
    }
}
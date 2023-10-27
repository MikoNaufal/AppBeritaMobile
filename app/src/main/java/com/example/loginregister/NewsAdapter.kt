package com.example.loginregister

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val list: ArrayList<ArticlesItem>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {


        inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
            val image:ImageView = view.findViewById(R.id.imageVIew)
            val judul:TextView = view.findViewById(R.id.tv_title)
            val description:TextView = view.findViewById(R.id.tv_description)
        }

        override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): NewsAdapter.MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list, parent, false)

            return MyViewHolder(view)
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val value = list[position]
        holder.apply {
            judul.text = value.title.toString()
            description.text = value.description.toString()
            Glide.with (itemView.context)
                .load(value.urlToImage)
                .into(image)    }
    }

    fun setlistNews(news: ArrayList<ArticlesItem>) {
            list.clear()
            list.addAll(news)
            notifyDataSetChanged()
        }
    override fun getItemCount(): Int = list.size


}
package com.prototype.socialmedia.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prototype.socialmedia.model.Post
import com.prototype.socialmedia.R

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.postrow, parent, false)
        val postHolder = ViewHolder(view)
        return postHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPost = posts[position]
        holder.render(itemPost)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}
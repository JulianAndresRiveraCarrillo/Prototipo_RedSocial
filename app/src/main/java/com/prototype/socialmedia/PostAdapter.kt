package com.prototype.socialmedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter : RecyclerView.Adapter<ViewHolder>(){

    private val posts = ArrayList<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.postrow, parent, false)
        val postHolder = ViewHolder(view)
        return postHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]

        holder.userText.text = post.user
        holder.locationText.text = post.location
        holder.descriptionText.text = post.description
        holder.postView.setImageBitmap(post.img)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}
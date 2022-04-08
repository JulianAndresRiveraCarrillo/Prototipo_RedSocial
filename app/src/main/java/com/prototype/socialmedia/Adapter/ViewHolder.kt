package com.prototype.socialmedia.Adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prototype.socialmedia.R
import com.prototype.socialmedia.model.Post

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //UI Controls
    var userText : TextView = itemView.findViewById(R.id.userText)
    var locationText : TextView = itemView.findViewById(R.id.locationText)
    var postView : ImageView = itemView.findViewById(R.id.postView)
    var descriptionText : TextView = itemView.findViewById(R.id.descriptionText)

    //State

    fun render(post : Post){
        userText.text = post.user
        locationText.text = post.location
        postView.setImageURI(post.image)
        descriptionText.text = post.description
    }
}
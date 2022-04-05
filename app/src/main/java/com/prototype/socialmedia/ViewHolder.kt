package com.prototype.socialmedia

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //UI Controls
    var userText : TextView = itemView.findViewById(R.id.userText)
    var locationText : TextView = itemView.findViewById(R.id.locationText)
    var postView : ImageView = itemView.findViewById(R.id.postView)
    var descriptionText : TextView = itemView.findViewById(R.id.descriptionText)

    //State


    init{

    }
}
package com.prototype.socialmedia.Adapter

import android.graphics.Bitmap
import android.net.Uri
import com.prototype.socialmedia.model.Post

class PostProvider {
    companion object{
        val postList = listOf<Post>(
            Post("Pepito", "Cali","Nueva foto, dale like", Uri.parse("julian.jpg")),
            Post("Federico", "Cali","Nueva foto, dale like", Uri.parse("julian.jpg"))

        )
    }
}
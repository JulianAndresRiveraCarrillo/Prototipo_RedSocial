package com.prototype.socialmedia.model

import android.net.Uri

data class Post (
    val user : String,
    val location : String,
    val description : String,
    val image : Uri
        )
package com.prototype.socialmedia

import android.graphics.Bitmap

class Post {

    var img : Bitmap
    var user : String
    var description : String
    var location : String

    constructor(img : Bitmap, user : String, description : String, location : String){
        this.img = img
        this.user = user
        this.description = description
        this.location = location
    }

}
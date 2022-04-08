package com.prototype.socialmedia.model

class User {
    var userName : String
    var email : String
    var password : String

    constructor(userName : String, email : String, password : String){
        this.userName = userName
        this.email = email
        this.password = password
    }
}
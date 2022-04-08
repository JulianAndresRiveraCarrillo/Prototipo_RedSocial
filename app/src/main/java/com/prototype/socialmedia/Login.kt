package com.prototype.socialmedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.prototype.socialmedia.databinding.ActivityLoginBinding
import com.prototype.socialmedia.model.User

class Login : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    private lateinit var user1 : User
    private lateinit var user2 : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener{
            var email = binding.emailText.text.toString()
            var pass = binding.passwordText.text.toString()

            user1 = User("Pepito Perez","alfa@gmail.com", "aplicacionesmoviles")
            user2 = User("Peter Federico","beta@gmail.com", "aplicacionesmoviles")

            if(email.equals(user1.email)){
                if (pass.equals(user1.password)){
                    val intent = Intent(applicationContext, Home :: class.java).apply{}
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Correo o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
                }
            }else if(email.equals(user2.email)){
                if (pass.equals(user2.password)){
                    val intent = Intent(applicationContext, Home :: class.java).apply{}
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Correo o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Correo o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
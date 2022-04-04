package com.prototype.socialmedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.prototype.socialmedia.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    val email1 : String = "alfa@gmail.com"
    val email2 : String = "beta@gmail.com"
    val password : String = "aplicacionesmoviles"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener{
            var email = binding.emailText.text.toString()
            var pass = binding.passwordText.text.toString()

            if(email.equals(email1)){
                if (pass.equals(password)){
                    val intent = Intent(applicationContext, Home :: class.java).apply{}
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Correo o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
                }
            }else if(email.equals(email2)){
                if (pass.equals(password)){
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
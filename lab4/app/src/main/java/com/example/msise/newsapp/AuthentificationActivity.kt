package com.example.msise.newsapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AuthentificationActivity : AppCompatActivity() {

    private lateinit var emailView: EditText
    private lateinit var passwordView: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)
        setupView()
        loginButton.setOnClickListener({ saveLoginInfo() })

        if (!PreferenceManager(this).isUserLogOut()) {
            enterNewsList()
        }
    }

    private fun setupView() {
        emailView = findViewById<EditText>(R.id.activity_et_email)
        passwordView = findViewById<EditText>(R.id.activity_et_password)
        loginButton = findViewById(R.id.activity_button_login)
    }

    private fun saveLoginInfo() {
        val email = emailView.text
        val password = passwordView.text

        PreferenceManager(this).saveLoginDetails(email = email.toString(), password = password.toString())
        if (!PreferenceManager(this).isUserLogOut()) {
            enterNewsList()
        }
    }

    private fun enterNewsList() {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

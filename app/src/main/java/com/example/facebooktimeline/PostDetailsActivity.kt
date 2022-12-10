package com.example.facebooktimeline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextView

class PostDetailsActivity : AppCompatActivity() {
    lateinit var usernameTextView: TextView
    lateinit var profileImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
        val name = intent.getStringExtra("postAuthor")
        val image = intent.getIntExtra("postAuthorImage", R.drawable.ic_post_image)
        usernameTextView = findViewById(R.id.username)
        profileImageView = findViewById(R.id.user_profile_picture)
        usernameTextView.text = name
        profileImageView.setImageResource(image)
    }
}
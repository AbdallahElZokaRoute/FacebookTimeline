package com.example.facebooktimeline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var postsRecylcerView: RecyclerView
    lateinit var adapter: FacebookTimeLineAdapter
    lateinit var postsList: ArrayList<TimelineDataItem>
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postsRecylcerView = findViewById(R.id.facebook_timeline_recycler_view)
        initFacebookTimeline()
        adapter = FacebookTimeLineAdapter(postsList)
        
        adapter.onPostClickListener = object : OnPostClickListener {
            override fun onPostClick(timelineDataItem: TimelineDataItem) {
                val intent = Intent(this@MainActivity, PostDetailsActivity::class.java)
                intent.putExtra("postAuthor", timelineDataItem.postAuthor)
                intent.putExtra("postAuthorImage", timelineDataItem.postAuthorImage)
                startActivity(intent)
            }

        }
        postsRecylcerView.adapter = adapter


    }

    fun initFacebookTimeline() {
        postsList = ArrayList()
        for (i in 0..1000) {
            postsList.add(
                TimelineDataItem(
                    postAuthor = "Posts Author $i",
                    postAuthorImage = R.drawable.ic_user,
                    "2H $i",
                    postDescription = "Post Description $i",
                    postImage = R.drawable.ic_post_image,
                    like = "Like $i",
                    comment = "Comment $i",
                    share = "Share $i"
                )
            )

        }

    }
}
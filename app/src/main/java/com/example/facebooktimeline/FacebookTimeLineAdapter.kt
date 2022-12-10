package com.example.facebooktimeline

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class FacebookTimeLineAdapter(
    val posts: ArrayList<TimelineDataItem>?
) : Adapter<FacebookTimeLineAdapter.TimelineViewHolder>() {
    var onPostClickListener: OnPostClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.timeline_item, parent, false)
        return TimelineViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
        val postItem = posts?.get(position)!!

        holder.profilePicture.setImageResource(postItem?.postAuthorImage ?: R.drawable.ic_comment)
        holder.uploadTime.text = postItem?.uploadDate
        holder.name.text = postItem?.postAuthor
        holder.postImage.setImageResource(postItem?.postImage ?: R.drawable.ic_comment)
        holder.postDescription.text = postItem?.postDescription
        holder.likeButton.text = postItem?.like
        holder.commentButton.text = postItem?.comment
        holder.shareButton.text = postItem?.share
        holder.profilePicture.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                onPostClickListener?.onPostClick(postItem)
            }

        })
        holder.name.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                onPostClickListener?.onPostClick(postItem)
            }

        })


    }

    override fun getItemCount(): Int {
        return posts?.size ?: 0
    }


    class TimelineViewHolder(val itemView: View) : ViewHolder(itemView) {
        var postImage: ImageView
        var profilePicture: ImageView
        var uploadTime: TextView
        var name: TextView
        var postDescription: TextView
        var likeButton: Button
        var commentButton: Button
        var shareButton: Button

        init {
            postImage = itemView.findViewById(R.id.post_image)
            uploadTime = itemView.findViewById(R.id.upload_time)
            name = itemView.findViewById(R.id.username)
            profilePicture = itemView.findViewById(R.id.user_profile_picture)
            postDescription = itemView.findViewById(R.id.post_description)
            likeButton = itemView.findViewById(R.id.like_button)
            commentButton = itemView.findViewById(R.id.comment)
            shareButton = itemView.findViewById(R.id.share_button)
        }

    }


}
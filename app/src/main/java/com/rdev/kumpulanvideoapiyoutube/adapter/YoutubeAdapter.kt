package com.rdev.kumpulanvideoapiyoutube.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rdev.kumpulanvideoapiyoutube.R
import com.rdev.kumpulanvideoapiyoutube.data.Items
import com.rdev.kumpulanvideoapiyoutube.data.Snippet
import com.rdev.kumpulanvideoapiyoutube.detail.PlayVideoActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.video_item.view.*

class YoutubeAdapter(val data: List<Items>?) : RecyclerView.Adapter<YoutubeAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position)?.snippet)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlayVideoActivity::class.java)
            intent.putExtra("videoId", data?.get(position)?.id?.videoId)
            holder.itemView.context.startActivity(intent)
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Snippet?) {
            Glide.with(itemView?.context)
                .load(get?.thumbnails?.high?.url)
                .into(itemView.videoThumbnail)

            itemView.videoTitle.text = get?.title
        }
    }
}
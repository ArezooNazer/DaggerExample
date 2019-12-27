package com.arezoonazer.daggerexample.presentation.home

import android.content.ContentValues.TAG
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.arezoonazer.daggerexample.R
import com.arezoonazer.daggerexample.data.model.Photo
import com.bumptech.glide.Glide

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private val TAG = "HomeFragment"
    private var photoList: ArrayList<Photo>? = null

    fun swapData(photos: ArrayList<Photo>) {
        Log.d(TAG, "HomeAdapter swap data $photos")
        photoList = photos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.home_item, viewGroup, false)
        )
    }

    override fun getItemCount(): Int {
        return photoList?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, index: Int) {
        Log.d(TAG, "onBindViewHolder ${photoList!![index]}")
        photoList?.let {
            holder.onBind(it[index])
        }
    }

    class HomeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(item: Photo) {

            val iv = view.findViewById<ImageView>(R.id.home_item_avatar)
            //todo: inject Glide
            Glide.with(iv.context)
                .load(item.thumbnailUrl)
                .into(iv)

            val tv = view.findViewById<AppCompatTextView>(R.id.home_item_title)
            tv.text = item.title

            Log.d(TAG, "HomeAdapter tv.text ${tv.text}")
        }
    }
}
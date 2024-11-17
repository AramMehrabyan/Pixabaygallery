package com.aram.mehrabyan.utils.imaheloader

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}
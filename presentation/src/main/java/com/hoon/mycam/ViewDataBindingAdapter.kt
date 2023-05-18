package com.hoon.mycam

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.setProfileUrl(url: String?, placeHolder: Drawable?) {
    val ph = placeHolder ?: ContextCompat.getDrawable(context, R.drawable.vt_home_icon)

    Glide.with(context)
        .load(url)
        .placeholder(ph)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}
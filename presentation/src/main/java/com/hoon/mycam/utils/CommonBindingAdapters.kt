package com.hoon.mycam.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.hoon.mycam.R

object CommonBindingAdapters{
    @JvmStatic
    @BindingAdapter("urlRoundImage")
    fun ImageView.setRoundUrlImage(imageUrl: String?) {
        imageUrl?.let {
            Glide.with(this)
                .load(it)
                .transform(CenterCrop(), RoundedCorners(20))
                .error(R.drawable.vt_no_image_icon)
                .into(this)
        }
    }
    @JvmStatic
    @BindingAdapter("urlImage")
    fun ImageView.setUrlImage(imageUrl: String?) {
        imageUrl?.let {
            Glide.with(this)
                .load(it)
                .transform(CenterCrop())
                .error(R.drawable.vt_no_image_icon)
                .into(this)
        }
    }
}

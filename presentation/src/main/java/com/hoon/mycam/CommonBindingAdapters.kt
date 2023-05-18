package com.hoon.mycam

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object CommonBindingAdapters{
    @JvmStatic
    @BindingAdapter("urlImage")
    fun ImageView.setRoundUrlImage(imageUrl: String?) {
        imageUrl?.let {
            Glide.with(this)
                .load(it)
                .transform(CenterCrop(), RoundedCorners(14))
                .error(R.drawable.vt_no_image_icon)
                .into(this)
        }
    }
}

package com.hoon.domain.inquiry.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class ImageInfoItemsVo(val items: ImageInfoItemVo)
data class ImageInfoItemVo(val item: List<ImageInfoVo>)

@Parcelize
data class ImageInfoVo(val contentId: String,
                       val serialnum: String,
                       val imageUrl: String,
                       val createdtime: String,
                       val modifiedtime: String) : Parcelable
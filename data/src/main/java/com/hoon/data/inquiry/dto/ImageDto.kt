package com.hoon.data.inquiry.dto

data class ImageDto(var items: ImageItemDto)
data class ImageItemDto(var item: List<ImageItemInfoDto>)
data class ImageItemInfoDto(var contentId: String?,
                            var serialnum: String?,
                            var imageUrl: String?,
                            var createdtime: String?,
                            var modifiedtime: String?)
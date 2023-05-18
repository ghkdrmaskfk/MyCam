package com.hoon.data.lookup.model

import com.hoon.domain.lookup.model.CampingBasedInfoVo

sealed class HomeRecordItem {
    abstract val id: Long

    data class Item(val item: CampingBasedInfoVo) : HomeRecordItem() { // 아이템 항목
        override val id: Long = item.contentId?.toLong() ?: 0L
    }
    data class Header(val cityName: String) : HomeRecordItem() { // 헤더
        override val id = Long.MIN_VALUE
    }
    object Bottom : HomeRecordItem() { // 항목이 없을 때
        override val id = Long.MAX_VALUE
    }
}
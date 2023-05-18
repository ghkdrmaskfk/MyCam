package com.hoon.data.utils

data class WrappedResponse<T> (val response : Response<T>) {
    data class Response<T> (val header : HeaderResponse?,
                            val body : T)
}

data class HeaderResponse (val responseTime : String? = "",
                           val resultCode : String?,
                           val resultMsg : String?)
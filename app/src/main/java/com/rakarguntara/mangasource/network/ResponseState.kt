package com.rakarguntara.mangasource.network


class ResponseState<T, Boolean, E:Exception> (
    var data: T? = null,
    var loading: Boolean? = null,
    var e: Exception? = null,
)
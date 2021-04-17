package com.example.mobillaborapp.events

data class DeleteImageEvent (
        var code: Int = 0,
        var throwable: Throwable? = null
)
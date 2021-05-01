package com.example.mobillaborapp.events

import com.example.mobillaborapp.model.network.Breed

data class GetBreedsEvent (
    var code: Int = 0,
    var breeds: List<Breed>? = null,
    var throwable: Throwable? = null
)
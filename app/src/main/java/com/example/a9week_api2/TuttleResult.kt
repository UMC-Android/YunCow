package com.example.a9week_api2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TuttleResult {
    @SerializedName("tuttleType")
    @Expose
    var tuttleType: String? = null

    @SerializedName("tuttleList")
    @Expose
    var tuttleList: List<TuttleList>? = null
}
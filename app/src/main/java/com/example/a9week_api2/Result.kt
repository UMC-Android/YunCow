package com.example.a9week_api2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("tuttleResult")
    @Expose
    var tuttleResult: TuttleResult? = null
}
package com.example.a9week_api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("boxOfficeResult")
    @Expose
    var boxOfficeResult: BoxOfficeResult? = null
}
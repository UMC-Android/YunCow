package com.example.a9week_api2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("http://apis.data.go.kr/B553482/SeaTurtleRouteService/getSeaTurtleMeta")
    fun getBoxOffice(
        @Query("key") key: String?
    ): Call<Result?>?
}
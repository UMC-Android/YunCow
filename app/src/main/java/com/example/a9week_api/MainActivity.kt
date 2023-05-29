package com.example.a9week_api

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a9week_api.BoxOfficeResult
import com.example.a9week_api.RetrofitClient
import com.example.a9week_api.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var mAdapter: RecyclerView.Adapter<*>? = null

    private var retrofitClient: RetrofitClient? = null
    private var retrofitInterface: RetrofitInterface? = null

    private lateinit var API_KEY: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        API_KEY = applicationContext.resources.getString(R.string.KEY)

        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.setLayoutManager(layoutManager)

        retrofitClient = RetrofitClient.getInstance()
        retrofitInterface = RetrofitClient.getRetrofitInterface()

        retrofitInterface!!.getBoxOffice(API_KEY, "20230528")?.enqueue(object : Callback<Result?> {
            override fun onResponse(call: Call<Result?>, response: Response<Result?>) {
                val result: Result? = response.body()
                val boxOfficeResult = result?.boxOfficeResult
                Log.d("retrofit", "Data fetch success")
                mAdapter = boxOfficeResult?.dailyBoxOfficeList?.let { MovieAdapter(it) }
                recyclerView.adapter = mAdapter
            }

            override fun onFailure(call: Call<Result?>, t: Throwable) {
                Log.d("retrofit", t.message!!)
            }
        })
    }
}
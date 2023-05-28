package com.example.a8week

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.adapters.AdapterViewBindingAdapter.setOnItemSelectedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a8week.databinding.ActivityMainBinding



class MainActivity :AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var memodata: RoomDatabase? = null
    private var memolist = listOf<Memo>()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        memodata = RoomDatabase.getInstance(this)

        val r = Runnable {
            try {
                memolist = memodata?.MemoDao?.getAll()!!

                runOnUiThread {
                    mainAdapter = MainAdapter(memolist)
                    mainAdapter.notifyDataSetChanged()

                    binding.RecyclerView.adapter = mainAdapter
                    binding.RecyclerView.layoutManager = LinearLayoutManager(this)
                    binding.RecyclerView.setHasFixedSize(true)
                }
            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            }
        }

        val thread = Thread(r)
        thread.start()

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, MemoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        RoomDatabase.destroyInstance()
        memodata = null
        super.onDestroy()
    }
}
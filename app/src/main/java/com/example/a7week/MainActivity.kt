package com.example.a7week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.a7week.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private var total = 5
    private var started = true
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        val handler = Handler(mainLooper)

        viewBinding.btnStart.setOnClickListener {
            viewBinding.tvEnd.text = "  "
            thread(start = true) {
                while (started && total != 0) {
                    Thread.sleep(1000)
                    total -= 1
                    val minute = String.format("%02d", total / 60) // 분
                    val second = String.format("%02d", total % 60) // 초
                    handler.post {
                        viewBinding.tvTime.text = "$minute:$second"
                    }
                }
                total = 5
                handler.post {
                    viewBinding.tvEnd.text = "End"
                    viewBinding.tvTime.text = "00:05"
                }
            }
        }
    }

}
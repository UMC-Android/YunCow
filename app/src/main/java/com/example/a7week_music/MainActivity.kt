package com.example.a7week_music

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.widget.Button
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a7week_music.databinding.ActivityMainBinding
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding
            by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null
    var mp: MediaPlayer? = null
    var seekBar: SeekBar? = null
    var text: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.button1) as Button?
        btn2 = findViewById(R.id.button2) as Button?
        btn3 = findViewById(R.id.button3) as Button?
        text = findViewById(R.id.text1) as TextView?
        mp = MediaPlayer.create(this@MainActivity, R.raw.music)
        seekBar = findViewById(R.id.playbar) as SeekBar?
        seekBar!!.visibility = ProgressBar.VISIBLE
        seekBar!!.max = mp!!.duration
        val handler = Handler(mainLooper)
        seekBar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mp!!.seekTo(progress)
                }
                val m = progress / 60000
                val s = progress % 60000 / 1000
                val strTime = String.format("%02d:%02d", m, s)
                handler.post {
                    text!!.text = strTime
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        btn1!!.setOnClickListener {
            mp!!.start()
            Thread()
        }
        btn2!!.setOnClickListener {
            mp!!.stop()
            try {
                mp!!.prepare()
            } catch (ie: IOException) {
                ie.printStackTrace()
            }
            mp!!.seekTo(0)
        }
        btn3!!.setOnClickListener { mp!!.pause() }
    }

    private fun Thread() {
        val task = Runnable {
            while (mp!!.isPlaying) {
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                }
                seekBar!!.progress = mp!!.currentPosition
            }
        }
        val thread = Thread(task)
        thread.start()
    }




}
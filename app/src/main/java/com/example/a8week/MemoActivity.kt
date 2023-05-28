package com.example.a8week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a8week.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoBinding
    private var memodata: RoomDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addRunnable = Runnable {
            val title = binding.EditTextTitle.text.toString()
            val content = binding.EditText.text.toString()
            val newmemo = Memo(title = title, content = content)
            memodata?.memoDao()?.insert(newmemo)
        }

        binding.goBtn.setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("근디 할말이 있음")
            .setMessage("자네,,,, 더 쓸건가,,,?")
            .setPositiveButton("예") {dialog, which ->
                binding.EditText.setText(content)
            }
            .setNegativeButton("아니요") {dialog, which ->
                binding.EditText.text.clear()
            }
            .create()
            .show()
    }

    override fun onDestroy() {
        RoomDatabase.destroyInstance()
        super.onDestroy()
    }
}
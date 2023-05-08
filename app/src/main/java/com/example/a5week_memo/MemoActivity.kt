package com.example.a5week_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5week_memo.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // MemoActivity 에서 MainActivity 로 data 전달
        viewBinding.btnStore.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("data", viewBinding.edtTxt.text.toString())
            }
            setResult(RESULT_OK, mIntent)
            if(!isFinishing) finish()
        }
    }
}
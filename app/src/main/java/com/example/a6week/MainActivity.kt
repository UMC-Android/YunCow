package com.example.a6week

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.example.a6week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.frameLayout.id, MainFragment())
            .commitAllowingStateLoss()

        binding.bottomNavigationView.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.frameLayout.id, MainFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.frameLayout.id, Fragment1())
                            .commitAllowingStateLoss()
                    }
                    R.id.search -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.frameLayout.id, Fragment2())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.home
        }
    }
}
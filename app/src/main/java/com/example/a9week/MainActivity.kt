package com.example.a9week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a9week.Constants.TAG
import com.example.a9week.databinding.ActivityMainBinding
import com.kakao.sdk.user.Constants
import com.kakao.sdk.user.UserApiClient

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(binding.root)

        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패 $error")
            } else if (user != null) {
                Log.d(TAG, "사용자 정보 요청 성공 : $user")
                binding.txtNickName.text = user.kakaoAccount?.profile?.nickname
                binding.txtAge.text = user.kakaoAccount?.ageRange.toString()
                binding.txtEmail.text = user.kakaoAccount?.email
            }
        }
    }
}
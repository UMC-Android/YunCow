package com.example.a6week

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a6week.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment: Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(LayoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ViewpagerFragmentAdapter = ViewpagerFragmentAdapter(this)
        binding.vpHome.adapter = ViewpagerFragmentAdapter

        val tabTitleArray = arrayOf(
            "One",
            "Two",
        )

        TabLayoutMediator(binding.tabHome, binding.vpHome) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}
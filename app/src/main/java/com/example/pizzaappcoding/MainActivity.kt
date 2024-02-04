package com.example.pizzaappcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pizzaappcoding.adapters.MainViewPagerAdapter
import com.example.pizzaappcoding.databinding.ActivityMainBinding
class MainActivity : BasicActivity() {

    lateinit var mvpa : MainViewPagerAdapter
    private lateinit var binding: ActivityMainBinding
    override fun setupEvents() {

    }

    override fun setValues() {

        //뷰페이저 작업
        mvpa = MainViewPagerAdapter(supportFragmentManager)
        binding.mainViewPager.adapter = mvpa

        //탭레이아웃 연동
        binding.mainTabLayout.setupWithViewPager(binding.mainViewPager)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupEvents()
        setValues()

    }
}
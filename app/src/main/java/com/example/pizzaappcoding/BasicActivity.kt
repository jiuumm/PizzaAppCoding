package com.example.pizzaappcoding

import androidx.appcompat.app.AppCompatActivity

abstract class BasicActivity: AppCompatActivity() {
    val mContext = this

    abstract fun setupEvents()
    abstract fun setValues()

}
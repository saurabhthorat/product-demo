package com.saurabh.demo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saurabh.demo.R
import com.saurabh.demo.ui.home.HomeFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, HomeFragment.newInstance())
            .commit()
    }
}

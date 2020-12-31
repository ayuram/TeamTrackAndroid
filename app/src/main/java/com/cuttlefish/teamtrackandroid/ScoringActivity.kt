package com.cuttlefish.teamtrackandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class ScoringActivity : AppCompatActivity() {
    private var mSectionsPageAdapter: SectionsPageAdapter? = null
    private var mViewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoring_main)
        Log.d(TAG, "onCreate: Starting.")
        mSectionsPageAdapter = SectionsPageAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById<View>(R.id.container) as ViewPager
        setupViewPager(mViewPager)
        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)
    }

    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = SectionsPageAdapter(supportFragmentManager)
        adapter.addFragment(autoScoring(), "Auto")
        adapter.addFragment(teleScoring(), "Tele")
        adapter.addFragment(endgameScoring(), "Endgame")
        viewPager!!.adapter = adapter
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
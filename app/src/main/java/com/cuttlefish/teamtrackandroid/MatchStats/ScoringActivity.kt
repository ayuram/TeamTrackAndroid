package com.cuttlefish.teamtrackandroid.MatchStats

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.cuttlefish.teamtrackandroid.*
import com.google.android.material.tabs.TabLayout
import java.util.*

class ScoringActivity : AppCompatActivity() {
    private var mSectionsPageAdapter: SectionsPageAdapter? = null
    private var mViewPager: ViewPager? = null
    var match: Match? = null
    var selectedTeam: Team? = match?.red?.first
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoring_main)
        Log.d(TAG, "onCreate: Starting.")
        mSectionsPageAdapter = SectionsPageAdapter(supportFragmentManager)
        val bundle = Bundle()
        bundle.putParcelable("autoScore", selectedTeam?.scores?.find { it.id == match?.id }?.autoScore )
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById<View>(R.id.container) as ViewPager
        setupViewPager(mViewPager)
        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)
    }

    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = SectionsPageAdapter(supportFragmentManager)
        adapter.addFragment(autoScoring(), "Autonomous")
        adapter.addFragment(teleScoring(), "Tele-Op")
        adapter.addFragment(endgameScoring(), "Endgame")
        viewPager?.adapter = adapter
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
package com.cuttlefish.teamtrackandroid

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.cuttlefish.teamtrackandroid.MatchStats.ScoringActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val fab = findViewById<FloatingActionButton>(R.id.fab)
        val list = findViewById<ListView>(R.id.eventsList)
        val plus = findViewById<FloatingActionButton>(R.id.Plus)
        plus.setOnClickListener {
            val intent = Intent(this, ScoringActivity::class.java).apply {

            }
            startActivity(intent)
        }
    }
}
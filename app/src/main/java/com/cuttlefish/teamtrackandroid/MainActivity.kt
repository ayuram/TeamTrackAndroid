package com.cuttlefish.teamtrackandroid

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

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
package com.cuttlefish.teamtrackandroid

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cuttlefish.teamtrackandroid.MatchStats.ScoringActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(){
    private var events = ArrayList<Event>()
    private var eventType: EventType = EventType.local
    var list: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val plus = findViewById<FloatingActionButton>(R.id.Plus)
        list = findViewById<ListView>(R.id.eventsList)
        plus.setOnClickListener {
            val intent = Intent(this, ScoringActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
    fun addEvent(name: String){
        events.add(element = Event(eventType, name))
        val textView = TextView(this)
        textView.setText(name)
        list?.addHeaderView(textView)
    }
}
package com.cuttlefish.teamtrackandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment

class teleScoring : Fragment() {
    private var highGoals = 0
    private var midGoals = 0
    private var lowGoals = 0
    private var highGoalUp: ImageButton? = null
    private var highGoalDown: ImageButton? = null
    private var highGoalScore: TextView? = null
    private var midGoalUp: ImageButton? = null
    private var midGoalDown: ImageButton? = null
    private var midGoalScore: TextView? = null
    private var lowGoalUp: ImageButton? = null
    private var lowGoalDown: ImageButton? = null
    private var lowGoalScore: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.tele_scoring, container, false)
        highGoalUp = view.findViewById<View>(R.id.teleHighGoalUp) as ImageButton
        highGoalDown = view.findViewById<View>(R.id.teleHighGoalDown) as ImageButton
        highGoalScore = view.findViewById<View>(R.id.teleHighGoals) as TextView
        midGoalUp = view.findViewById<View>(R.id.teleMiddleGoalUp) as ImageButton
        midGoalDown = view.findViewById<View>(R.id.teleMiddleGoalDown) as ImageButton
        midGoalScore = view.findViewById<View>(R.id.teleMiddleGoals) as TextView
        lowGoalUp = view.findViewById<View>(R.id.teleLowGoalUp) as ImageButton
        lowGoalDown = view.findViewById<View>(R.id.teleLowGoalDown) as ImageButton
        lowGoalScore = view.findViewById<View>(R.id.teleLowGoals) as TextView
        highGoalUp!!.setOnClickListener { highGoalScore!!.text = Integer.toString(++highGoals) }
        highGoalDown!!.setOnClickListener { highGoalScore!!.text = Integer.toString(--highGoals) }
        midGoalUp!!.setOnClickListener { midGoalScore!!.text = Integer.toString(++midGoals) }
        midGoalDown!!.setOnClickListener { midGoalScore!!.text = Integer.toString(--midGoals) }
        lowGoalUp!!.setOnClickListener { lowGoalScore!!.text = Integer.toString(++lowGoals) }
        lowGoalDown!!.setOnClickListener { lowGoalScore!!.text = Integer.toString(--lowGoals) }
        return view
    }

    companion object {
        private const val TAG = "teleScoring"
    }
}
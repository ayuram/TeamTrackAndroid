package com.cuttlefish.teamtrackandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class teleScoring : Fragment() {
    var teleScore =  TeleScore()
    private var highGoals = 0
    private var midGoals = 0
    private var lowGoals = 0
    private var highGoalUp: Button? = null
    private var highGoalDown: Button? = null
    private var highGoalScore: TextView? = null
    private var midGoalUp: Button? = null
    private var midGoalDown: Button? = null
    private var midGoalScore: TextView? = null
    private var lowGoalUp: Button? = null
    private var lowGoalDown: Button? = null
    private var lowGoalScore: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.tele_scoring, container, false)
        highGoalUp = view.findViewById<View>(R.id.teleHighGoalUp) as Button
        highGoalDown = view.findViewById<View>(R.id.teleHighGoalDown) as Button
        highGoalScore = view.findViewById<View>(R.id.teleHighGoals) as TextView
        midGoalUp = view.findViewById<View>(R.id.teleMiddleGoalUp) as Button
        midGoalDown = view.findViewById<View>(R.id.teleMiddleGoalDown) as Button
        midGoalScore = view.findViewById<View>(R.id.teleMiddleGoals) as TextView
        lowGoalUp = view.findViewById<View>(R.id.teleLowGoalUp) as Button
        lowGoalDown = view.findViewById<View>(R.id.teleLowGoalDown) as Button
        lowGoalScore = view.findViewById<View>(R.id.teleLowGoals) as TextView
        highGoalUp?.setOnClickListener {
            highGoals++
            teleScore.hiGoals++
            highGoalScore?.setText(highGoals)
        }
        highGoalDown?.setOnClickListener {
            highGoals--
            teleScore.hiGoals--
            highGoalScore?.setText(highGoals)
        }
        midGoalUp?.setOnClickListener { midGoalScore!!.text = Integer.toString(++midGoals) }
        midGoalDown?.setOnClickListener { midGoalScore!!.text = Integer.toString(--midGoals) }
        lowGoalUp?.setOnClickListener { lowGoalScore!!.text = Integer.toString(++lowGoals) }
        lowGoalDown?.setOnClickListener { lowGoalScore!!.text = Integer.toString(--lowGoals) }
        return view
    }

    companion object {
        private const val TAG = "teleScoring"
    }
}
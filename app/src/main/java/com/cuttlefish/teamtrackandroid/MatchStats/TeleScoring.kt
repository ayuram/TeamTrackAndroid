package com.cuttlefish.teamtrackandroid.MatchStats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cuttlefish.teamtrackandroid.R
import com.cuttlefish.teamtrackandroid.TeleScore

class teleScoring : Fragment() {
    var teleScore =  TeleScore()
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
        setFields()
        highGoalUp?.setOnClickListener {
            teleScore.hiGoals++
            setFields()
        }
        highGoalDown?.setOnClickListener {
            if(teleScore.hiGoals > 0) teleScore.hiGoals--
            setFields()
        }
        midGoalUp?.setOnClickListener {
            teleScore.midGoals ++
            setFields()
        }
        midGoalDown?.setOnClickListener {
            if(teleScore.midGoals > 0) teleScore.midGoals --
            setFields()
        }
        lowGoalUp?.setOnClickListener {
            teleScore.lowGoals ++
            setFields()
        }
        lowGoalDown?.setOnClickListener {
            if(teleScore.lowGoals > 0) teleScore.lowGoals --
            setFields()
        }
        return view
    }
    fun setFields(){
        highGoalScore?.text = Integer.toString(teleScore.hiGoals)
        midGoalScore?.text = Integer.toString(teleScore.midGoals)
        lowGoalScore?.text = Integer.toString(teleScore.lowGoals)
    }
    companion object {
        private const val TAG = "teleScoring"
    }
}
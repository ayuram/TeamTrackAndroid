package com.cuttlefish.teamtrackandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class autoScoring : Fragment() {
    var autoScore = AutoScore()
    private var highGoals = 0
    private var midGoals = 0
    private var lowGoals = 0
    private var wobbles = 0
    private var powerShots = 0
    private var highGoalUp: Button? = null
    private var highGoalDown: Button? = null
    private var highGoalScore: TextView? = null
    private var midGoalUp: Button? = null
    private var midGoalDown: Button? = null
    private var midGoalScore: TextView? = null
    private var lowGoalUp: Button? = null
    private var lowGoalDown: Button? = null
    private var lowGoalScore: TextView? = null
    private var wobbleUp: Button? = null
    private var wobbleDown: Button? = null
    private var wobbleScore: TextView? = null
    private var powerShotUp: Button? = null
    private var powerShotDown: Button? = null
    private var powerShotScore: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.auto_scoring, container, false)
        highGoalUp = view.findViewById<View>(R.id.highGoalUp) as Button
        highGoalDown = view.findViewById<View>(R.id.highGoalDown) as Button
        highGoalScore = view.findViewById<View>(R.id.autoHighGoals) as TextView
        midGoalUp = view.findViewById<View>(R.id.middleGoalUp) as Button
        midGoalDown = view.findViewById<View>(R.id.middleGoalDown) as Button
        midGoalScore = view.findViewById<View>(R.id.autoMiddleGoals) as TextView
        lowGoalUp = view.findViewById<View>(R.id.lowGoalUp) as Button
        lowGoalDown = view.findViewById<View>(R.id.lowGoalDown) as Button
        lowGoalScore = view.findViewById<View>(R.id.autoLowGoals) as TextView
        wobbleUp = view.findViewById<View>(R.id.wobbleUp) as Button
        wobbleDown = view.findViewById<View>(R.id.wobbleDown) as Button
        wobbleScore = view.findViewById<View>(R.id.autoWobbles) as TextView
        powerShotUp = view.findViewById<View>(R.id.powerShotUp) as Button
        powerShotDown = view.findViewById<View>(R.id.powerShotDown) as Button
        powerShotScore = view.findViewById<View>(R.id.autoPowerShots) as TextView
        highGoalUp!!.setOnClickListener {
            highGoalScore!!.text = Integer.toString(++highGoals)
            autoScore.hiGoals++
        }
        highGoalDown!!.setOnClickListener {
            if(autoScore.hiGoals > 0) {
                highGoalScore!!.text = Integer.toString(--highGoals)
                autoScore.hiGoals--
            }
        }

        midGoalUp!!.setOnClickListener {
            midGoalScore!!.text = Integer.toString(++midGoals)
            autoScore.midGoals ++
        }
        midGoalDown!!.setOnClickListener {
            if(autoScore.midGoals > 0) {
                midGoalScore!!.text = Integer.toString(--midGoals)
                autoScore.midGoals --
            }
        }

        lowGoalUp!!.setOnClickListener {
            lowGoalScore!!.text = Integer.toString(++lowGoals)
            autoScore.lowGoals ++
        }
        lowGoalDown!!.setOnClickListener {
            if(autoScore.lowGoals > 0) {
                lowGoalScore!!.text = Integer.toString(--lowGoals)
                autoScore.lowGoals --
            }
        }

        wobbleUp!!.setOnClickListener {
            if(autoScore.wobbleGoals < 2) {
                wobbleScore!!.text = Integer.toString(++wobbles)
                autoScore.wobbleGoals ++
            }
        }
        wobbleDown!!.setOnClickListener {
            if(autoScore.wobbleGoals > 0) {
                wobbleScore!!.text = Integer.toString(--wobbles)
                autoScore.wobbleGoals --
            }
        }

        powerShotUp!!.setOnClickListener {
            if(autoScore.pwrShots < 3) {
                powerShotScore!!.text = Integer.toString(++powerShots)
                autoScore.pwrShots ++
            }
        }
        powerShotDown!!.setOnClickListener {
            if(autoScore.pwrShots > 0) {
                powerShotScore!!.text = Integer.toString(--autoScore.pwrShots)
                autoScore.pwrShots --
            }
        }
        return view
    }

    companion object {
        private const val TAG = "autoScoring"
    }
}
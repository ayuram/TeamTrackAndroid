package com.cuttlefish.teamtrackandroid.MatchStats

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cuttlefish.teamtrackandroid.AutoScore
import com.cuttlefish.teamtrackandroid.R

class autoScoring : Fragment() {
    var autoScore = AutoScore()
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
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private var navigated: Switch? = null
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
        setFields()
        highGoalUp!!.setOnClickListener {
            autoScore.hiGoals++
            setFields()
        }
        highGoalDown!!.setOnClickListener {
            if(autoScore.hiGoals > 0) {
                autoScore.hiGoals--
                setFields()
            }
        }

        midGoalUp!!.setOnClickListener {
            autoScore.midGoals ++
            setFields()
        }
        midGoalDown!!.setOnClickListener {
            if(autoScore.midGoals > 0) {
                autoScore.midGoals --
                setFields()
            }
        }

        lowGoalUp!!.setOnClickListener {
            autoScore.lowGoals ++
            setFields()
        }
        lowGoalDown!!.setOnClickListener {
            if(autoScore.lowGoals > 0) {
                autoScore.lowGoals --
                setFields()
            }
        }

        wobbleUp!!.setOnClickListener {
            if(autoScore.wobbleGoals < 2) {
                autoScore.wobbleGoals ++
                setFields()
            }
        }
        wobbleDown!!.setOnClickListener {
            if(autoScore.wobbleGoals > 0) {
                autoScore.wobbleGoals --
                setFields()
            }
        }

        powerShotUp!!.setOnClickListener {
            if(autoScore.pwrShots < 3) {
                autoScore.pwrShots ++
                setFields()
            }
        }
        powerShotDown!!.setOnClickListener {
            if(autoScore.pwrShots > 0) {
                autoScore.pwrShots --
                setFields()
            }
        }
        return view
    }
    fun setFields(){
        highGoalScore?.text = Integer.toString(autoScore.hiGoals)
        midGoalScore?.text = Integer.toString(autoScore.midGoals)
        lowGoalScore?.text = Integer.toString(autoScore.lowGoals)
        wobbleScore?.text = Integer.toString(autoScore.wobbleGoals)
        powerShotScore?.text = Integer.toString(autoScore.pwrShots)
        navigated?.isChecked = autoScore.navigated
    }
    companion object {
        private const val TAG = "autoScoring"
    }
}
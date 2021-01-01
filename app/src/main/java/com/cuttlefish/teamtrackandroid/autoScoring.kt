package com.cuttlefish.teamtrackandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment

class autoScoring : Fragment() {
    private var highGoals = 0
    private var midGoals = 0
    private var lowGoals = 0
    private var wobbles = 0
    private var powerShots = 0
    private var highGoalUp: ImageButton? = null
    private var highGoalDown: ImageButton? = null
    private var highGoalScore: TextView? = null
    private var midGoalUp: ImageButton? = null
    private var midGoalDown: ImageButton? = null
    private var midGoalScore: TextView? = null
    private var lowGoalUp: ImageButton? = null
    private var lowGoalDown: ImageButton? = null
    private var lowGoalScore: TextView? = null
    private var wobbleUp: ImageButton? = null
    private var wobbleDown: ImageButton? = null
    private var wobbleScore: TextView? = null
    private var powerShotUp: ImageButton? = null
    private var powerShotDown: ImageButton? = null
    private var powerShotScore: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.auto_scoring, container, false)
        highGoalUp = view.findViewById<View>(R.id.highGoalUp) as ImageButton
        highGoalDown = view.findViewById<View>(R.id.highGoalDown) as ImageButton
        highGoalScore = view.findViewById<View>(R.id.autoHighGoals) as TextView
        midGoalUp = view.findViewById<View>(R.id.middleGoalUp) as ImageButton
        midGoalDown = view.findViewById<View>(R.id.middleGoalDown) as ImageButton
        midGoalScore = view.findViewById<View>(R.id.autoMiddleGoals) as TextView
        lowGoalUp = view.findViewById<View>(R.id.lowGoalUp) as ImageButton
        lowGoalDown = view.findViewById<View>(R.id.lowGoalDown) as ImageButton
        lowGoalScore = view.findViewById<View>(R.id.autoLowGoals) as TextView
        wobbleUp = view.findViewById<View>(R.id.wobbleUp) as ImageButton
        wobbleDown = view.findViewById<View>(R.id.wobbleDown) as ImageButton
        wobbleScore = view.findViewById<View>(R.id.autoWobbles) as TextView
        powerShotUp = view.findViewById<View>(R.id.powerShotUp) as ImageButton
        powerShotDown = view.findViewById<View>(R.id.powerShotDown) as ImageButton
        powerShotScore = view.findViewById<View>(R.id.autoPowerShots) as TextView
        highGoalUp!!.setOnClickListener { highGoalScore!!.text = Integer.toString(++highGoals) }
        highGoalDown!!.setOnClickListener { highGoalScore!!.text = Integer.toString(if(highGoals-1 >= 0) --highGoals else highGoals) }
        midGoalUp!!.setOnClickListener { midGoalScore!!.text = Integer.toString(++midGoals) }
        midGoalDown!!.setOnClickListener { midGoalScore!!.text = Integer.toString(if(midGoals-1 >= 0) --midGoals else midGoals) }
        lowGoalUp!!.setOnClickListener { lowGoalScore!!.text = Integer.toString(++lowGoals) }
        lowGoalDown!!.setOnClickListener { lowGoalScore!!.text = Integer.toString(if(lowGoals-1 >= 0) --lowGoals else lowGoals) }
        wobbleUp!!.setOnClickListener { wobbleScore!!.text = Integer.toString(++wobbles) }
        wobbleDown!!.setOnClickListener { wobbleScore!!.text = Integer.toString(if(wobbles-1 >= 0) --wobbles else wobbles) }
        powerShotUp!!.setOnClickListener { powerShotScore!!.text = Integer.toString(++powerShots) }
        powerShotDown!!.setOnClickListener { powerShotScore!!.text = Integer.toString(if(powerShots-1 >= 0) --powerShots else powerShots) }
        return view
    }

    companion object {
        private const val TAG = "autoScoring"
    }
}
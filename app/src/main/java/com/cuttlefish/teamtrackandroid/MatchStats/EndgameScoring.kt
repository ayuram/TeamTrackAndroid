package com.cuttlefish.teamtrackandroid.MatchStats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cuttlefish.teamtrackandroid.EndScore
import com.cuttlefish.teamtrackandroid.R

class endgameScoring : Fragment() {
    var endgameScore = EndScore()
    private var powerShotUp: Button? = null
    private var powerShotDown: Button? = null
    private var endgamePowerShotScore: TextView? = null
    private var wobblesDropUp: Button? = null
    private var wobblesDropDown: Button? = null
    private var wobblesDropScore: TextView? = null
    private var wobblesStartUp: Button? = null
    private var wobblesStartDown: Button? = null
    private var wobblesStartScore: TextView? = null
    private var wobbleRingsUp: Button? = null
    private var wobbleRingsDown: Button? = null
    private var wobbleRingsScore: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.endgame_scoring, container, false)
        powerShotUp = view.findViewById<View>(R.id.endgamePowerShotsUp) as Button
        powerShotDown = view.findViewById<View>(R.id.endgamePowerShotsDown) as Button
        endgamePowerShotScore = view.findViewById<View>(R.id.endgamePowerShots) as TextView
        wobblesDropUp = view.findViewById<View>(R.id.wobblesDropUp) as Button
        wobblesDropDown = view.findViewById<View>(R.id.wobblesDropDown) as Button
        wobblesDropScore = view.findViewById<View>(R.id.wobblesDrop) as TextView
        wobblesStartUp = view.findViewById<View>(R.id.wobblesStartUp) as Button
        wobblesStartDown = view.findViewById<View>(R.id.wobblesStartDown) as Button
        wobblesStartScore = view.findViewById<View>(R.id.wobblesStart) as TextView
        wobbleRingsUp = view.findViewById<View>(R.id.wobbleRingsUp) as Button
        wobbleRingsDown = view.findViewById<View>(R.id.wobbleRingsDown) as Button
        wobbleRingsScore = view.findViewById<View>(R.id.wobbleRings) as TextView
        setFields()
        powerShotUp!!.setOnClickListener {
            if(endgameScore.pwrShots < 3){
                endgameScore.pwrShots ++
            }
            setFields()
        }
        powerShotDown!!.setOnClickListener {
            if(endgameScore.pwrShots > 0){
                endgameScore.pwrShots --
            }
            setFields()
        }
        wobblesDropUp!!.setOnClickListener {
            if(endgameScore.wobbleGoalsInDrop < 2){
                endgameScore.wobbleGoalsInDrop ++
            }
            setFields()
        }
        wobblesDropDown!!.setOnClickListener {
            if(endgameScore.wobbleGoalsInDrop > 0) endgameScore.wobbleGoalsInDrop --
            setFields()
        }
        wobblesStartUp!!.setOnClickListener {
            if(endgameScore.wobbleGoalsInStart < 2){
                endgameScore.wobbleGoalsInStart ++
            }
            setFields()
        }
        wobblesStartDown!!.setOnClickListener {
            if(endgameScore.wobbleGoalsInStart > 0) endgameScore.wobbleGoalsInStart --
            setFields()
        }
        wobbleRingsUp!!.setOnClickListener {
            endgameScore.ringsOnWobble++
            setFields()
        }
        wobbleRingsDown!!.setOnClickListener {
            if(endgameScore.ringsOnWobble > 0) endgameScore.ringsOnWobble--
            setFields()
        }
        return view
    }
    fun setFields(){
        wobbleRingsScore?.text = Integer.toString(endgameScore.ringsOnWobble)
        wobblesStartScore?.text = Integer.toString(endgameScore.wobbleGoalsInStart)
        wobblesDropScore?.text = Integer.toString(endgameScore.wobbleGoalsInDrop)
        endgamePowerShotScore?.text = Integer.toString(endgameScore.pwrShots)
    }
    companion object {
        private const val TAG = "autoScoring"
    }
}
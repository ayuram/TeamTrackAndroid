package com.cuttlefish.teamtrackandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment

class endgameScoring : Fragment() {
    private var endgamePowerShots = 0
    private var wobblesDrop = 0
    private var wobblesStart = 0
    private var wobbleRings = 0
    private var powerShotUp: ImageButton? = null
    private var powerShotDown: ImageButton? = null
    private var endgamePowerShotScore: TextView? = null
    private var wobblesDropUp: ImageButton? = null
    private var wobblesDropDown: ImageButton? = null
    private var wobblesDropScore: TextView? = null
    private var wobblesStartUp: ImageButton? = null
    private var wobblesStartDown: ImageButton? = null
    private var wobblesStartScore: TextView? = null
    private var wobbleRingsUp: ImageButton? = null
    private var wobbleRingsDown: ImageButton? = null
    private var wobbleRingsScore: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.endgame_scoring, container, false)
        powerShotUp = view.findViewById<View>(R.id.endgamePowerShotsUp) as ImageButton
        powerShotDown = view.findViewById<View>(R.id.endgamePowerShotsDown) as ImageButton
        endgamePowerShotScore = view.findViewById<View>(R.id.endgamePowerShots) as TextView
        wobblesDropUp = view.findViewById<View>(R.id.wobblesDropUp) as ImageButton
        wobblesDropDown = view.findViewById<View>(R.id.wobblesDrop) as ImageButton
        wobblesDropScore = view.findViewById<View>(R.id.wobblesDrop) as TextView
        wobblesStartUp = view.findViewById<View>(R.id.wobblesStartUp) as ImageButton
        wobblesStartDown = view.findViewById<View>(R.id.wobblesStartDown) as ImageButton
        wobblesStartScore = view.findViewById<View>(R.id.wobblesStart) as TextView
        wobbleRingsUp = view.findViewById<View>(R.id.wobbleRingsUp) as ImageButton
        wobbleRingsDown = view.findViewById<View>(R.id.wobbleRingsDown) as ImageButton
        wobbleRingsScore = view.findViewById<View>(R.id.wobbleRings) as TextView
        powerShotUp!!.setOnClickListener {
            endgamePowerShotScore!!.text = Integer.toString(++endgamePowerShots)
        }
        powerShotDown!!.setOnClickListener {
            endgamePowerShotScore!!.text = Integer.toString(--endgamePowerShots)
        }
        wobblesDropUp!!.setOnClickListener {
            wobblesDropScore!!.text = Integer.toString(++wobblesDrop)
        }
        wobblesDropDown!!.setOnClickListener {
            wobblesDropScore!!.text = Integer.toString(--wobblesDrop)
        }
        wobblesStartUp!!.setOnClickListener {
            wobblesStartScore!!.text = Integer.toString(++wobblesStart)
        }
        wobblesStartDown!!.setOnClickListener {
            wobblesStartScore!!.text = Integer.toString(--wobblesStart)
        }
        wobbleRingsUp!!.setOnClickListener {
            wobbleRingsScore!!.text = Integer.toString(++wobbleRings)
        }
        wobbleRingsDown!!.setOnClickListener {
            wobbleRingsScore!!.text = Integer.toString(--wobbleRings)
        }
        return view
    }

    companion object {
        private const val TAG = "autoScoring"
    }
}
package com.cuttlefish.teamtrackandroid

import android.util.Pair
import java.util.*

class Match(r0: Team?, r1: Team?, b0: Team?, b1: Team?, var type: EventType) {
    var red: Pair<Team?, Team?> = Pair<Team?, Team?>(r0, r1)
    var blue: Pair<Team?, Team?> = Pair<Team?, Team?>(b0, b1)
    val id = UUID.randomUUID()

    init {
        r0?.scores?.add(Score(id))
        r1?.scores?.add(Score(id))
        b0?.scores?.add(Score(id))
        b1?.scores?.add(Score(id))
    }

    fun score(): String{
        val redScore0 = red.first?.scores?.find { it.id == id }
        val redScore1 = red.second?.scores?.find { it.id == id }
        val blueScore0 = blue.first?.scores?.find { it.id == id }
        val blueScore1 = blue.second?.scores?.find { it.id == id }
        return "" + redScore0?.total() + redScore1?.total() + " - " + blueScore0?.total() + blueScore1?.total()
    }
}

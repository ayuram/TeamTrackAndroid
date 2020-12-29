package com.cuttlefish.teamtrackandroid

import android.util.Pair
import java.util.*

class Match(r0: Team, r1: Team, b0: Team, b1: Team, type: EventType) {
    var red: Pair<Team, Team>
    var blue: Pair<Team, Team>
    var id = UUID.randomUUID()
    var type: EventType

    init {
        red = Pair<Team, Team>(r0, r1)
        blue = Pair<Team, Team>(b0, b1)
        this.type = type
        r0.scores.add(Score(id))
        r1.scores.add(Score(id))
        b0.scores.add(Score(id))
        b1.scores.add(Score(id))
    }
}

package com.cuttlefish.teamtrackandroid

import java.util.*

class Event(t: EventType) {
    var matches: ArrayList<Match>
    var teams: ArrayList<Team>
    var type: EventType
    fun switchType(newType: EventType) {
        type = newType
        for (i in matches.indices) {
            matches[i].type = newType
        }
        for (i in teams.indices) {
            teams[i].type = newType
        }
    }

    init {
        matches = ArrayList<Match>()
        teams = ArrayList<Team>()
        type = t
    }
}
package com.cuttlefish.teamtrackandroid

import java.util.*

class Event(type: EventType) {
    var matches: ArrayList<Match> = ArrayList<Match>()
    var teams: ArrayList<Team> = ArrayList<Team>()
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
        this.type = type
    }
}
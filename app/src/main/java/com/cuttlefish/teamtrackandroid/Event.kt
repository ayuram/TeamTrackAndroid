package com.cuttlefish.teamtrackandroid

import java.util.*

class Event(var type: EventType, var name: String) {
    var matches: ArrayList<Match> = ArrayList<Match>()
    var teams: ArrayList<Team> = ArrayList<Team>()
    fun switchType(newType: EventType) {
        type = newType
        for (i in matches.indices) {
            matches[i].type = newType
        }
        for (i in teams.indices) {
            teams[i].type = newType
        }
    }
}
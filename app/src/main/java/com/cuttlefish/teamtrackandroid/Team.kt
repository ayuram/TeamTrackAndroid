package com.cuttlefish.teamtrackandroid

import java.util.*

class Team(var number: Int, var name: String, type: EventType) {
    var scores = ArrayList<Score>()
    var type: EventType
    fun avgScore(): Double {
        var total = 0.0
        for (i in scores.indices) {
            total += scores[i].total()
        }
        return total / scores.size
    }

    fun bestScore(): Double {
        var highest = 0.0
        for (i in scores.indices) {
            if (scores[i].total() > highest) {
                highest = scores[i].total()
            }
        }
        return highest
    }

    fun MADScore(): Double {
        val differences = ArrayList<Double>()
        val avg = avgScore()
        for (i in scores.indices) {
            differences.add(Math.abs(scores[i].total() - avg))
        }
        var total = 0.0
        for (i in differences.indices) {
            total += differences[i]
        }
        return total / differences.size
    }

    init {
        this.type = type
    }
}

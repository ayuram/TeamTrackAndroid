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

    fun bestScore(): Int {
        return scores
                .map { it.total().toDouble() }
                .max()
                .toInt()
    }

    fun MADScore(): Double {
        return scores
                .map { it.total().toDouble() }
                .MAD()
    }

    init {
        this.type = type
    }
}
fun List<Double>.mean(): Double{
    return this.reduce { x, y -> x + y } / this.count().toDouble()
}
fun List<Double>.MAD(): Double {
    val mean = this.mean()
    return this.map { Math.abs(it - mean) }.mean()
}
fun List<Double>.max(): Double{
    var highest = 0.0
    for (i in this.indices) {
        if (this[i] > highest) {
            highest = this[i]
        }
    }
    return highest
}

package com.cuttlefish.teamtrackandroid

import java.util.*

class Score(var id: UUID) {
    var autoScore: AutoScore = AutoScore()
    var teleScore: TeleScore = TeleScore()
    var endScore: EndScore = EndScore()
    fun total(): Double {
        return autoScore.total() + endScore.total() + teleScore.total()
    }
}

class AutoScore {
    var wobbleGoals = 0
    var lowGoals = 0
    var midGoals = 0
    var hiGoals = 0
    var pwrShots = 0
    var navigated = false
    fun total(): Double {
        return (wobbleGoals * 15 + lowGoals * 3 + midGoals * 6 + hiGoals * 12 + pwrShots * 15 + if (navigated) 5 else 0).toDouble()
    }
}
class TeleScore {
    var lowGoals = 0
    var midGoals = 0
    var hiGoals = 0
    fun total(): Double {
        return (lowGoals * 2 + midGoals * 4 + hiGoals * 6).toDouble()
    }
}
class EndScore {
    var wobbleGoalsInDrop = 0
    var wobbleGoalsInStart = 0
    var pwrShots = 0
    var ringsOnWobble = 0
    fun total(): Double {
        return (wobbleGoalsInDrop * 20 + wobbleGoalsInStart * 5 + ringsOnWobble * 5 + pwrShots * 15).toDouble()
    }
}

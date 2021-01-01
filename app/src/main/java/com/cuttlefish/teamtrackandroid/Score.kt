package com.cuttlefish.teamtrackandroid

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import java.util.*

class Score(var id: UUID) {
    var autoScore: AutoScore = AutoScore()
    var teleScore: TeleScore = TeleScore()
    var endScore: EndScore = EndScore()
    fun total(): Int {
        return autoScore.total() + endScore.total() + teleScore.total()
    }
}

class AutoScore() : Parcelable{
    override fun describeContents(): Int {
        return total()
    }
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt(wobbleGoals)
        p0?.writeInt(lowGoals)
        p0?.writeInt(hiGoals)
        p0?.writeInt(midGoals)
        p0?.writeInt(pwrShots)
        p0?.writeByte((if (navigated) 1 else 0).toByte())
    }
    var wobbleGoals = 0
    var lowGoals = 0
    var midGoals = 0
    var hiGoals = 0
    var pwrShots = 0
    var navigated = false

    constructor(parcel: Parcel) : this() {
        wobbleGoals = parcel.readInt()
        lowGoals = parcel.readInt()
        midGoals = parcel.readInt()
        hiGoals = parcel.readInt()
        pwrShots = parcel.readInt()
        navigated = parcel.readByte() != 0.toByte()
    }

    fun total(): Int {
        return (wobbleGoals * 15 + lowGoals * 3 + midGoals * 6 + hiGoals * 12 + pwrShots * 15 + if (navigated) 5 else 0)
    }

    companion object CREATOR : Parcelable.Creator<AutoScore> {
        override fun createFromParcel(parcel: Parcel): AutoScore {
            return AutoScore(parcel)
        }

        override fun newArray(size: Int): Array<AutoScore?> {
            return arrayOfNulls(size)
        }
    }
}
class TeleScore {
    var lowGoals = 0
    var midGoals = 0
    var hiGoals = 0
    fun total(): Int {
        return (lowGoals * 2 + midGoals * 4 + hiGoals * 6)
    }
}
class EndScore {
    var wobbleGoalsInDrop = 0
    var wobbleGoalsInStart = 0
    var pwrShots = 0
    var ringsOnWobble = 0
    fun total(): Int {
        return (wobbleGoalsInDrop * 20 + wobbleGoalsInStart * 5 + ringsOnWobble * 5 + pwrShots * 15)
    }
}

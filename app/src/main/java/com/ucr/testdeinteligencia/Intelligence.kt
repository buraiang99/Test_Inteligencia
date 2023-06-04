package com.ucr.testdeinteligencia

import java.io.Serializable

class Intelligence : Serializable {

    var nameInt: String = ""
        get() = field
        set(value) {
            field = value
        }
    var valueInt: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var questionInt: ArrayList<Question> = ArrayList()
        get() = field
        set(value) {
            field = value
        }

    constructor(nameIntelligence: String, valueIntelligence:Int, questionIntelligence: ArrayList<Question>) {
        nameInt = nameIntelligence
        valueInt = valueIntelligence
        questionInt = questionIntelligence
    }

    fun totalScore(): Int {

        var score = 0
        for (total in questionInt) {
            score += total.scoreQ
        }
        return score
    }
    override fun toString(): String {
        return super.toString()
    }
}
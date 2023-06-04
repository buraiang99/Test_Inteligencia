package com.ucr.testdeinteligencia

import java.io.Serializable

class Intelligence : Serializable {
    var totalScore=0
    var mcd=0
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

    fun totalScore(){

        var score = 0
        for (total in questionInt) {
            score += total.scoreQ
        }
        //println("Prueba"+questionInt[2].scoreQ)
        this.totalScore=score
    }

    fun calcularMCD(){
        var mcd = 1
        var menor = questionInt[0].scoreQ
        if (questionInt[1].scoreQ < menor) {
            menor = questionInt[1].scoreQ
        }
        if (questionInt[2].scoreQ < menor) {
            menor = questionInt[2].scoreQ
        }
        for (i in 1..menor) {
            if (questionInt[0].scoreQ % i == 0 && questionInt[1].scoreQ % i == 0 && questionInt[2].scoreQ % i == 0) {
                mcd = i
            }
        }
        this.mcd=mcd
    }
    override fun toString(): String {
        return super.toString()
    }
}
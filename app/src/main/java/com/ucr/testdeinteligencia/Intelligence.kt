package com.ucr.testdeinteligencia

class Intelligence(name: String, question1: String, question2: String, question3: String) {

    private val resultQ1 = 0
    private val resultQ2 = 0
    private val resultQ3 = 0

    fun totalPoint(): Int {
        return resultQ1 + resultQ2 + resultQ3
    }

}
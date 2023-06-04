package com.ucr.testdeinteligencia

import java.io.Serializable

class Question : Serializable {

    var descriptionQ: String = ""
        get() = field
        set(value) {
            field = value
        }
    var scoreQ: Int = 0
        get() = field
        set(value) {
            field = value
        }

    constructor(DescriptionQuestion: String) {
        descriptionQ = DescriptionQuestion
        scoreQ = 0
    }
}
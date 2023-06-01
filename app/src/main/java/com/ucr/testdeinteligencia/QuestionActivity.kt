package com.ucr.testdeinteligencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ucr.testdeinteligencia.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    var index: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val question = Question("Cuando Escucho a las personas (estudiantes) puedo identificar los fonemas (palabras, expresiones) sin dificultad")
        val question2 = Question("En las conversaciones, puedo modelar los sonidos constituvos adecuados para expresar mis ideas")
        val question3 = Question("Relaciono sin dificultad los fonemas al momento de modelar lla pronunciacion ")
        val question4 = Question("Fin")
        val arrayList = ArrayList<Question>()
        arrayList.add(question)
        arrayList.add(question2)
        arrayList.add(question3)
        arrayList.add(question4)
        val intelligence = Intelligence("Inteligencia lingüístico-verbal", 9, arrayList)

        nextQuestion(binding, intelligence)

    }
    fun nextQuestion(binding: ActivityQuestionBinding, intelligence: Intelligence) {
        binding.textViewQuestion.text = intelligence.questionInt[index].descriptionQ
        binding.radioGroup.clearCheck()
        binding.buttonConfirm.setOnClickListener {
            if (binding.radioButtonAlways.isChecked) {
                intelligence.questionInt[index].scoreQ = 5
                nextQuestion(binding, intelligence)
            } else {
                if (binding.radioButtonSometimes.isChecked) {
                    intelligence.questionInt[index].scoreQ = 3
                    nextQuestion(binding, intelligence)
                } else {
                    if (binding.radioButtonNever.isChecked) {
                        intelligence.questionInt[index].scoreQ = 1
                        nextQuestion(binding, intelligence)
                    }
                }
            }
        }
        if (index == 3) {
            intelligence.totalScore()
            val message = intelligence.totalScore().toString()
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
        index++
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Question", "onDestroy")
    }
}
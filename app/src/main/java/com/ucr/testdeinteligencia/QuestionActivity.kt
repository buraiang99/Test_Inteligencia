package com.ucr.testdeinteligencia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ucr.testdeinteligencia.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    var indexIntelligence: Int = 0
    var indexQuestion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nextQuestion(binding, saveQuestions())

    }
    fun nextQuestion(binding: ActivityQuestionBinding, intelligence: ArrayList<Intelligence>) {

        binding.textViewQuestion.text = intelligence[indexIntelligence].questionInt[indexQuestion].descriptionQ
        binding.radioGroup.clearCheck()
        binding.buttonConfirm.setOnClickListener {
            if (indexIntelligence <= 3) {
                if (binding.radioButtonAlways.isChecked) {
                    intelligence[indexIntelligence].questionInt[indexQuestion].scoreQ = 5
                    nextQuestion(binding, intelligence)
                } else {
                    if (binding.radioButtonSometimes.isChecked) {
                        intelligence[indexIntelligence].questionInt[indexQuestion].scoreQ = 3
                        nextQuestion(binding, intelligence)
                    } else {
                        if (binding.radioButtonNever.isChecked) {
                            intelligence[indexIntelligence].questionInt[indexQuestion].scoreQ = 1
                            nextQuestion(binding, intelligence)
                        }
                    }
                }
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("arrayListIntelligence", intelligence)
                startActivity(intent)
                indexQuestion = 0
                indexIntelligence = 0
            }
        }
        if (indexQuestion == 2) {
            indexIntelligence++
            indexQuestion = 0
        } else {
            indexQuestion++
        }
    }

    fun saveQuestions(): ArrayList<Intelligence> {
        val arrayListIntelligence = ArrayList<Intelligence>()

        val questionLV = Question("Cuando Escucho a las personas (estudiantes) puedo identificar los fonemas (palabras, expresiones) sin dificultad")
        val questionLV2 = Question("En las conversaciones, puedo modelar los sonidos constituvos adecuados para expresar mis ideas")
        val questionLV3 = Question("Relaciono sin dificultad los fonemas al momento de modelar lla pronunciacion")
        val arrayListLV = ArrayList<Question>()
        arrayListLV.add(questionLV)
        arrayListLV.add(questionLV2)
        arrayListLV.add(questionLV3)
        val intelligenceLinguisticVerbal = Intelligence("Lingüístico-verbal", 9, arrayListLV)
        arrayListIntelligence.add(intelligenceLinguisticVerbal)

        val questionIP = Question(" Puedo identificar mis emociones.")
        val questionIP2 = Question("He aprendido mucho acerca de mí alobservar mis propias emociones.")
        val questionIP3 = Question("La mayoría de las veces estoy conscientede mis emociones")
        val arrayListIP = ArrayList<Question>()
        arrayListIP.add(questionIP)
        arrayListIP.add(questionIP2)
        arrayListIP.add(questionIP3)
        val intelligenceIntrapersonal = Intelligence("Intrapersonal", 10, arrayListIP)
        arrayListIntelligence.add(intelligenceIntrapersonal)

        val questionES = Question("¿Eres consciente de tu propia existencia?")
        val questionES2 = Question("¿Atribuyes algún propósito a tu existencia?")
        val questionES3 = Question("¿Experimentas emociones o pensamientos relacionados con la finitud de tu existencia?")
        val arrayListES = ArrayList<Question>()
        arrayListES.add(questionES)
        arrayListES.add(questionES2)
        arrayListES.add(questionES3)
        val intelligenceExistential = Intelligence("Existencial", 11, arrayListES)
        arrayListIntelligence.add(intelligenceExistential)

        val questionCOL = Question("¿Eres capaz de trabajar en equipo y colaborar con otros seres o entidades?")
        val questionCOL2 = Question("¿Puedes compartir y comunicar tus conocimientos y habilidades con otros de manera efectiva?")
        val questionCOL3 = Question("¿Estás dispuesto/a a ayudar a otros y contribuir al logro de metas comunes?")
        val arrayListCOL = ArrayList<Question>()
        arrayListCOL.add(questionCOL)
        arrayListCOL.add(questionCOL2)
        arrayListCOL.add(questionCOL3)
        val intelligenceCollaborative = Intelligence("Colaborativa", 12, arrayListCOL)
        arrayListIntelligence.add(intelligenceCollaborative)

        return arrayListIntelligence
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Question", "onDestroy")
    }
}
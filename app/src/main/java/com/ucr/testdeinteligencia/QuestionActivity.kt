package com.ucr.testdeinteligencia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ucr.testdeinteligencia.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    var indexIntelligence: Int = 0
    var indexQuestion: Int = 0
    var name=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //nextQuestion(binding, saveQuestions())
        val intelligence = saveQuestions()
        name= intent.getStringExtra("name").toString()
        binding.radioGroup.clearCheck()
        binding.textViewQuestion.text = intelligence[indexIntelligence].questionInt[indexQuestion].descriptionQ

        binding.buttonConfirm.setOnClickListener {
            if (indexIntelligence < intelligence.size) {
                if (binding.radioButtonAlways.isChecked) {
                    intelligence[indexIntelligence].questionInt[indexQuestion].scoreQ = 5
                    println("Prueba" + intelligence[indexIntelligence].nameInt + ", " + intelligence[indexIntelligence].questionInt[indexQuestion].descriptionQ )
                    nextQuestion(binding, intelligence)
                } else {
                    if (binding.radioButtonSometimes.isChecked) {
                        intelligence[indexIntelligence].questionInt[indexQuestion].scoreQ = 3
                        println("Prueba" + intelligence[indexIntelligence].nameInt + ", " + intelligence[indexIntelligence].questionInt[indexQuestion].descriptionQ )
                        nextQuestion(binding, intelligence)
                    } else {
                        if (binding.radioButtonNever.isChecked) {
                            intelligence[indexIntelligence].questionInt[indexQuestion].scoreQ = 1
                            println("Prueba" + intelligence[indexIntelligence].nameInt + ", " + intelligence[indexIntelligence].questionInt[indexQuestion].descriptionQ )
                            nextQuestion(binding, intelligence)
                        }
                    }
                }
            }
        }

    }
    fun nextQuestion(binding: ActivityQuestionBinding, intelligence: ArrayList<Intelligence>) {

        if (indexQuestion == 2) {
            intelligence[indexIntelligence].totalScore()
            intelligence[indexIntelligence].calcularMCD()
            indexIntelligence++
            indexQuestion = 0
        } else {
            indexQuestion++
        }
        if (indexIntelligence < intelligence.size) {
            binding.radioGroup.clearCheck()
            binding.textViewQuestion.text = intelligence[indexIntelligence].questionInt[indexQuestion].descriptionQ
        } else {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("arrayListIntelligence", intelligence)
            intent.putExtra("name",this.name)
            startActivity(intent)
            //indexQuestion = 0
            //indexIntelligence = 0
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

        val questionMus = Question("¿Disfrutas escuchar música de diferentes géneros y estilos?")
        val questionMus2 = Question("¿Te sientes atraído por los aspectos técnicos de la música, como la teoría musical y la composición?")
        val questionMus3 = Question("¿Tienes facilidad para mantener el ritmo y seguir el compás de una canción mientras la escuchas o tocas un instrumento?")
        val arrayListMus = ArrayList<Question>()
        arrayListMus.add(questionMus)
        arrayListMus.add(questionMus2)
        arrayListMus.add(questionMus3)
        val intelligenceMusical = Intelligence("Musical", 1, arrayListMus)
        arrayListIntelligence.add(intelligenceMusical)

        val questionCor = Question("¿Te resulta sencillo expresarse a través del movimiento corporal, como gestos, posturas o expresiones faciales?")
        val questionCor2 = Question("¿Tienes facilidad para aprender movimientos y gestos nuevos con tu cuerpo?")
        val questionCor3 = Question("¿Eres hábil en actividades físicas que requieren coordinación, como deportes, danza o artes marciales?")
        val arrayListCor = ArrayList<Question>()
        arrayListCor.add(questionCor)
        arrayListCor.add(questionCor2)
        arrayListCor.add(questionCor3)
        val intelligenceCorporal = Intelligence("Corporal-cinestesica", 2, arrayListCor)
        arrayListIntelligence.add(intelligenceCorporal)

        val questionNat = Question("¿Disfrutas pasando tiempo al aire libre y observando la flora y fauna que te rodea?")
        val questionNat2 = Question("¿Tienes un interés innato por aprender sobre los ecosistemas, la conservación de la naturaleza y los procesos naturales?")
        val questionNat3 = Question("¿Tienes facilidad para identificar diferentes especies de plantas, animales o elementos naturales en tu entorno?")
        val arrayListNat = ArrayList<Question>()
        arrayListNat.add(questionNat)
        arrayListNat.add(questionNat2)
        arrayListNat.add(questionNat3)
        val intelligenceNaturalista = Intelligence("Naturalista", 3, arrayListNat)
        arrayListIntelligence.add(intelligenceNaturalista)

        val questionEmo = Question("¿Tienes la capacidad de reconocer las emociones de otras personas a través de su lenguaje verbal y no verbal?")
        val questionEmo2 = Question("¿Eres capaz de motivarte y mantener un estado de ánimo positivo, incluso en momentos desafiantes?")
        val questionEmo3 = Question("¿Tienes empatía hacia los demás y eres capaz de entender y compartir sus emociones?")
        val arrayListEmo = ArrayList<Question>()
        arrayListEmo.add(questionEmo)
        arrayListEmo.add(questionEmo2)
        arrayListEmo.add(questionEmo3)
        val intelligenceEmocional = Intelligence("Emocional", 4, arrayListEmo)
        arrayListIntelligence.add(intelligenceEmocional)

        val questionEsp = Question("¿Eres bueno/a en la resolución de problemas que involucran la ubicación de objetos en el espacio, como en juegos de ajedrez o encaje de piezas?")
        val questionEsp2 = Question("¿Eres capaz de recordar con precisión lugares que has visitado antes, incluso después de mucho tiempo?")
        val questionEsp3 = Question("¿Puedes visualizar fácilmente objetos y su disposición en el espacio en tu mente?")
        val arrayListEsp = ArrayList<Question>()
        arrayListEsp.add(questionEsp)
        arrayListEsp.add(questionEsp2)
        arrayListEsp.add(questionEsp3)
        val intelligenceEspacial = Intelligence("Espacial", 5, arrayListEsp)
        arrayListIntelligence.add(intelligenceEspacial)

        val questionMat = Question("¿Eres capaz de encontrar patrones y relaciones entre diferentes conjuntos de datos o conceptos?")
        val questionMat2 = Question("¿Te resulta fácil razonar y deducir conclusiones a partir de información dada?")
        val questionMat3 = Question("¿Tienes habilidades para analizar y resolver problemas complejos de manera sistemática?")
        val arrayListMat = ArrayList<Question>()
        arrayListMat.add(questionMat)
        arrayListMat.add(questionMat2)
        arrayListMat.add(questionMat3)
        val intelligenceMatematica = Intelligence("Logica-Matematica", 6, arrayListMat)
        arrayListIntelligence.add(intelligenceMatematica)

        val questionPer = Question("¿Eres capaz de mediar en conflictos y ayudar a resolver problemas entre otras personas?")
        val questionPer2 = Question("¿Tienes habilidades para liderar y coordinar grupos de trabajo de manera efectiva?")
        val questionPer3 = Question("¿Disfrutas de participar en actividades sociales y colaborativas?")
        val arrayListPer = ArrayList<Question>()
        arrayListPer.add(questionPer)
        arrayListPer.add(questionPer2)
        arrayListPer.add(questionPer3)
        val intelligencePersonal = Intelligence("Interpersonal", 7, arrayListPer)
        arrayListIntelligence.add(intelligencePersonal)

        val questionCre = Question("¿Tienes facilidad para encontrar soluciones y respuestas originales a los problemas?")
        val questionCre2 = Question("¿Eres capaz de pensar de manera no convencional y ver las cosas desde perspectivas diferentes?")
        val questionCre3 = Question("¿Disfrutas de la generación de ideas nuevas y la exploración de posibilidades creativas?")
        val arrayListCre = ArrayList<Question>()
        arrayListCre.add(questionCre)
        arrayListCre.add(questionCre2)
        arrayListCre.add(questionCre3)
        val intelligenceCreativa = Intelligence("Creativa", 8, arrayListCre)
        arrayListIntelligence.add(intelligenceCreativa)

        return arrayListIntelligence
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Question", "onDestroy")
    }
}
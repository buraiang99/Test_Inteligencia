package com.ucr.testdeinteligencia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Matches : AppCompatActivity() {
    private lateinit var nameIntView: TextView
    private lateinit var dbHelper: SqlLite
    private lateinit var matchView: TextView
    private lateinit var buttonExit: Button
    val matchs=mutableListOf<Map<String, Any>>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches)

        nameIntView=findViewById(R.id.nameIntView)
        matchView=findViewById(R.id.matchView)
        buttonExit=findViewById(R.id.buttonExit)
        dbHelper = SqlLite(this)
        println("antes de val user")

        val dataList = dbHelper.getAllData()
        val dataListIntelligence=dbHelper.getAllData2()
        val lastData=dataList.last()
        var userInt2=dataListIntelligence[dataListIntelligence.size-2]["inteligencia"]
        var userInt3=dataListIntelligence[dataListIntelligence.size-1]["inteligencia"]
        nameIntView.text=lastData["name"].toString()
        nameIntView.append(" ")
        nameIntView.append(lastData["inteligencia"].toString())
        matchView.text="Match de personas con inteligencias y puntuaciones similares: \n"

        for (i in 0..dataListIntelligence.size-1 step 3) {
            if(lastData["inteligencia"]==dataListIntelligence[i]["inteligencia"]
                && lastData["id"].toString().toInt()!=dataListIntelligence[i]["id_usuario"].toString().toInt()){
                if(comprobarLista(dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["id"].toString().toInt())){
                    val aux="Nombre: "+dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["name"]+
                            ", Inteligencia: "+dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["inteligencia"]+"\n"
                    matchs.add(dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1])
                    matchView.append(aux)
                }
            }
        }
        for (i in 0..dataListIntelligence.size-1) {
            if(lastData["inteligencia"]==dataListIntelligence[i]["inteligencia"]
                && lastData["id"].toString().toInt()!=dataListIntelligence[i]["id_usuario"].toString().toInt()){
                if(comprobarLista(dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["id"].toString().toInt())){
                    val aux="Nombre: "+dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["name"]+
                            ", Inteligencia: "+dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["inteligencia"]+"\n"
                    matchs.add(dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1])
                    matchView.append(aux)
                }
            }
            if(userInt2==dataListIntelligence[i]["inteligencia"]
                && lastData["id"].toString().toInt()!=dataListIntelligence[i]["id_usuario"].toString().toInt()){
                if(comprobarLista(dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["id"].toString().toInt())){
                    val aux="Nombre: "+dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["name"]+
                            ", Inteligencia: "+dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["inteligencia"]+"\n"
                    matchs.add(dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1])
                    matchView.append(aux)
                }
            }
            if(userInt3==dataListIntelligence[i]["inteligencia"]
                && lastData["id"].toString().toInt()!=dataListIntelligence[i]["id_usuario"].toString().toInt()){
                if(comprobarLista(dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["id"].toString().toInt())){
                    val aux="Nombre: "+dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["name"]+
                            ", Inteligencia: "+dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1]["inteligencia"]+"\n"
                    matchs.add(dataList[dataListIntelligence[i]["id_usuario"].toString().toInt()-1])
                    matchView.append(aux)
                }
            }
        }

        buttonExit.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun comprobarLista(id: Int): Boolean{
        if(matchs.isEmpty()){
            return true
        }
        for (i in 0..matchs.size-1) {
            println("revisando matchs: "+matchs[i]["id"])
            if(matchs[i]["id"].toString().toInt()==id){
                return false
                break
            }
        }
        return true
    }
}
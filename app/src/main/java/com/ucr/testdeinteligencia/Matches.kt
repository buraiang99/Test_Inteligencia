package com.ucr.testdeinteligencia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Matches : AppCompatActivity() {
    private lateinit var nameIntView: TextView
    private lateinit var dbHelper: SqlLite
    private lateinit var matchView: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches)

        nameIntView=findViewById(R.id.nameIntView)
        matchView=findViewById(R.id.matchView)
        dbHelper = SqlLite(this)
        println("antes de val user")

        val dataList = dbHelper.getAllData()
        val lastData=dataList.last()
        matchView.text="Personas con su misma inteligencia: \n"
        nameIntView.text=lastData["name"].toString()
        nameIntView.append(" ")
        nameIntView.append(lastData["inteligencia"].toString())

        dataList.forEach { data ->
            val inteligencia = data["inteligencia"] as String
            val name = data["name"] as String
            if(lastData["inteligencia"]==inteligencia){
                val aux="Nombre: "+name+", Inteligencia: "+inteligencia+"\n"
                matchView.append(aux)
            }
        }
    }
}
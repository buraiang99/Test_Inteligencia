package com.ucr.testdeinteligencia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class preguntasTemp : AppCompatActivity() {
    private lateinit var nameTempView: TextView
    private lateinit var dbHelper: SqlLite
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas_temp)

        dbHelper = SqlLite(this)
        nameTempView=findViewById(R.id.nameTempView)
        val dataList = dbHelper.getAllData()
        for (name in dataList) {
            Log.d("TAG", "Nombre: $name")
        }
        nameTempView.text=dataList[5]
    }
}
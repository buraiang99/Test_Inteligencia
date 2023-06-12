package com.ucr.testdeinteligencia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var startBtn: Button
    private lateinit var ejemploView: TextView
    private lateinit var nameText: EditText
    private lateinit var dbHelper: SqlLite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn=findViewById(R.id.startBtn)
        ejemploView=findViewById(R.id.ejemploView)
        nameText=findViewById(R.id.nameText)
        dbHelper = SqlLite(this)
        startBtn.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("name",nameText.text.toString())
            val prueba=dbHelper.getAllData2()
            for (i in 0..prueba.size-1) {
                print("probando "+prueba[i]["id_usuario"])
                print(" ")
                println(prueba[i]["inteligencia"])
            }
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
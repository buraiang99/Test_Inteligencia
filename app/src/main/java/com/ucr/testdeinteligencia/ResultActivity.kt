package com.ucr.testdeinteligencia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private lateinit var buttonExit: Button
    private lateinit var dbHelper: SqlLite
    var name=""

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        dbHelper = SqlLite(this)
        name= intent.getStringExtra("name").toString()
        var mcdMax=0
        var scoreTemp=0
        var intePos=0
        var pos=0
        val intelligence = intent.getSerializableExtra("arrayListIntelligence") as ArrayList<Intelligence>
        //Toast.makeText(this, intelligence[0].totalScore().toString(), Toast.LENGTH_LONG).show()
        textViewResult = findViewById(R.id.textViewResult)
        for (inte in intelligence) {
            if(inte.mcd>mcdMax){
                mcdMax=inte.mcd
                intePos=pos
            }
            pos++
        }
        if(mcdMax==1){
            pos=0
            for (inte in intelligence) {
                if(inte.totalScore>scoreTemp){
                    scoreTemp=inte.totalScore
                    intePos=pos
                }
                pos++
            }
        }
        dbHelper.insertData(this.name.toString(),intelligence[intePos].nameInt,intelligence[intePos].totalScore)
        textViewResult.text = "Tu inteligencia es: ${intelligence[intePos].nameInt}"

        buttonExit = findViewById(R.id.buttonExit)

        buttonExit.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
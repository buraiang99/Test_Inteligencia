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

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intelligence = intent.getSerializableExtra("arrayListIntelligence") as ArrayList<Intelligence>
        //Toast.makeText(this, intelligence[0].nameInt, Toast.LENGTH_LONG).show()
        textViewResult = findViewById(R.id.textViewResult)
        textViewResult.text = "Tu inteligencia es: ${intelligence[0].nameInt}"

        buttonExit = findViewById(R.id.buttonExit)

        buttonExit.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
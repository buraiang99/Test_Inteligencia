package com.ucr.testdeinteligencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ucr.testdeinteligencia.databinding.ActivityQuestionBinding
import kotlin.math.log

class Question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonConfirm.setOnClickListener {
            val message = "Click"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Question", "onDestroy")
    }
}
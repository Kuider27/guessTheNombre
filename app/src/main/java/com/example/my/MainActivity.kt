package com.example.my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var secretNumber: Int = 0
    private var numberOfTries: Int = 0

    private lateinit var textView: TextView
    private lateinit var guessEditText: EditText
    private lateinit var guessButton: Button

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        guessButton = findViewById(R.id.guessButton)
        guessEditText = findViewById(R.id.guessEditText)

        //Gébérer un nombre aléatoire entre 0 et 100
        secretNumber = Random.nextInt(101)
    }
    fun checkGuess(view: View){
        val userGuess = guessEditText.text.toString()

        if(userGuess.isNotEmpty()) {
            try {
                val guess = userGuess.toInt()
                numberOfTries++

                val message = if (guess < secretNumber) {
                    "C'est plus !"
                } else if (guess > secretNumber) {
                    "C'est moins !"
                } else {
                    "Bravo! vous avez deviné le nombre en $numberOfTries essais"
                }
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }catch (e:NumberFormatException) {
                Toast.makeText(this,"Saisissez un nombre valide",Toast.LENGTH_SHORT).show()
            }
        }else {
            Toast.makeText(this,"Saisissez un nombre valide",Toast.LENGTH_SHORT).show()
        }
    }
}
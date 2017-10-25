package com.bairei.demoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var numberToGuess: Int = getRandom(1,25)

    private fun getRandom(from: Int, to: Int): Int {
        val random = Random()
        val number = random.nextInt(to) + from
        Log.i("Test", "Random number: $number")
        return number
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun guessNumberButtonPressed (view: View){

        val editText : EditText = findViewById(R.id.numberInputField)

        val inputNumber : Int? = editText.text.toString().toIntOrNull()

        when {

            inputNumber == null -> makeToast("unexpected null value! please guess a number again!")

            (inputNumber > 25) || (inputNumber < 1) -> makeToast("Please provide a correct number!")

            inputNumber == numberToGuess -> {
                makeToast("Congratulations! You guessed the number! Now try to guess a new one!")
                numberToGuess = getRandom(1, 25)
            }

            inputNumber > numberToGuess -> makeToast("Lower!")

            inputNumber < numberToGuess -> makeToast("Higher!")

        }
    }

    fun makeToast(string: String) {
        Toast.makeText(applicationContext, string, Toast.LENGTH_SHORT).show()
    }
}

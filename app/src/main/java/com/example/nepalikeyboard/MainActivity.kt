package com.example.nepalikeyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var displayView:TextView
    private lateinit var inputView:EditText
    private lateinit var enterButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayView=findViewById(R.id.displayView)
        inputView=findViewById(R.id.inputView)
        enterButton=findViewById(R.id.enterButton)

        enterButton.setOnClickListener(){
            var transfer=inputView.text.toString()
            transfer.toCharArray()
            converter(transfer, charMapping)
        }
    }
    fun converter(transfer: String, charMap:charMapping):String{
            val convertedLetter= StringBuilder()
            for (char in transfer){
                val nepaliChar = charMap.englishCharacterMap[char.toString().toLowerCase()] ?: char
                convertedLetter.append(nepaliChar)
            }

        displayView.text = convertedLetter.toString()
        return convertedLetter.toString()

    }
}
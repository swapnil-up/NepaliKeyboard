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

        enterButton.setOnClickListener() {
            val inputText = inputView.text.toString()
            val transliteratedText = transliterate(inputText)
            displayView.text = transliteratedText
        }
    }
    // Transliteration function
    private fun transliterate(inputText: String): String {
        val words = inputText.split(" ")
        val transliteratedWords = mutableListOf<String>()

        for (word in words) {
            val transliteratedWord = StringBuilder()
            var currentIndex = 0
            var currentSyllable = ""

            while (currentIndex < word.length) {
                currentSyllable += word[currentIndex]

                if (currentSyllable.length >= 3) {
                    if (charMapping.englishCharacterMap.containsKey(currentSyllable)) {
                        transliteratedWord.append(charMapping.englishCharacterMap[currentSyllable])
                        currentSyllable = ""
                    } else {
                        transliteratedWord.append(charMapping.englishCharacterMap[currentSyllable.substring(0, 2)]
                            ?: currentSyllable[0])
                        currentSyllable = currentSyllable.substring(2)
                    }
                } else if (currentSyllable.length >= 2) {
                    if (charMapping.englishCharacterMap.containsKey(currentSyllable)) {
                        transliteratedWord.append(charMapping.englishCharacterMap[currentSyllable])
                        currentSyllable = ""
                    }
                }

                currentIndex++
            }

            if (currentSyllable.isNotEmpty()) {
                transliteratedWord.append(charMapping.englishCharacterMap[currentSyllable]
                    ?: currentSyllable)
            }

            transliteratedWords.add(transliteratedWord.toString())
        }

        return transliteratedWords.joinToString(" ")
    }

}

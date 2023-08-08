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

            while (currentIndex < word.length) {
                var foundMatch = false
                var syllableLength = 4  // Maximum syllable length to check

                while (syllableLength >= 1) {
                    val subsequence = word.substring(currentIndex, currentIndex + syllableLength)
                    if (charMapping.englishCharacterMap.containsKey(subsequence)) {
                        transliteratedWord.append(charMapping.englishCharacterMap[subsequence])
                        currentIndex += syllableLength
                        foundMatch = true
                        break
                    }
                    syllableLength--
                }

                if (!foundMatch) {
                    transliteratedWord.append(charMapping.englishCharacterMap[word[currentIndex].toString()]
                        ?: word[currentIndex])
                    currentIndex++
                }
            }

            transliteratedWords.add(transliteratedWord.toString())
        }

        return transliteratedWords.joinToString(" ")
    }
}

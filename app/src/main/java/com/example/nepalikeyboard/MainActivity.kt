package com.example.nepalikeyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var displayView:TextView
    private lateinit var inputView:TextView
    private lateinit var enterButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayView=findViewById(R.id.displayView)
        inputView=findViewById(R.id.inputView)
        enterButton=findViewById(R.id.enterButton)

        enterButton.setOnClickListener(){
            var transfer=(R.id.inputView)
        }
    }
}
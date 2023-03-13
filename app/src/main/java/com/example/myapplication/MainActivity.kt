package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {
    lateinit var zeroButton : Button
    lateinit var oneButton : Button
    lateinit var twoButton : Button
    lateinit var threeButton : Button
    lateinit var fourButton : Button
    lateinit var fiveButton : Button
    lateinit var sixButton : Button
    lateinit var sevenButton : Button
    lateinit var eightButton : Button
    lateinit var nineButton : Button
    lateinit var A_Button: Button
    lateinit var B_Button : Button
    lateinit var C_Button: Button
    lateinit var D_Button: Button
    lateinit var E_Button : Button
    lateinit var F_Button : Button
    lateinit var dotButton : Button
    lateinit var hexButton : Button
    lateinit var decButton: Button
    lateinit var octButton: Button
    lateinit var binButton : Button
    lateinit var equalButton : Button
    lateinit var removeButton : Button
    lateinit var clearButton : Button
    lateinit var numberWrittenTextView : TextView
    lateinit var resultNumberTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun clearTextView(textField : TextView){
        textField.text = ""
    }
    private fun disabled(vararg buttonOfNumbers : Button){
        buttonOfNumbers.map {it.isEnabled = false}
    }
    private fun enabled(vararg buttonOfNumbers: Button){
        buttonOfNumbers.map {it.isEnabled = true}
    }

    private clickedToButtonOfNumberSystem(){
        // do something
    }
    private fun initAllElemnt(){
           zeroButton = findViewById(R.id.ZeroButton)
           oneButton  = findViewById(R.id.OneButton)
           twoButton  = findViewById(R.id.TwoButton)
           threeButton = findViewById(R.id.ThreeButton)
           fourButton  = findViewById(R.id.FourButton)
           fiveButton = findViewById(R.id.FiveButton)
           sixButton  = findViewById(R.id.SixButton)
           sevenButton = findViewById(R.id.SevenButton)
           eightButton  = findViewById(R.id.EightButton)
           nineButton = findViewById(R.id.NineButton)
           A_Button   = findViewById(R.id.AButton)
           B_Button  = findViewById(R.id.BButton)
           C_Button  = findViewById(R.id.CButton)
           D_Button   = findViewById(R.id.DButton)
           E_Button   = findViewById(R.id.EButton)
           F_Button    = findViewById(R.id.FiveButton)
           dotButton  = findViewById(R.id.DotButton)
           hexButton  = findViewById(R.id.appCompatButton2)
           decButton = findViewById(R.id.appCompatButton)
           octButton  = findViewById(R.id.appCompatButton4)
           binButton  = findViewById(R.id.appCompatButton3)
           equalButton = findViewById(R.id.EqualButton)
           removeButton = findViewById(R.id.appCompatButton5)
           clearButton   = findViewById(R.id.DELButton)
           numberWrittenTextView = findViewById(R.id.numberResult)
           resultNumberTextView  = findViewById(R.id.IDtextDefaultOfNumberInputInTop)
    }


}
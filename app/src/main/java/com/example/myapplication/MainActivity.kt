package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.math.BigInteger
import java.util.*


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
    lateinit var listOfHexButton : List<Button>
    lateinit var listOfDecimalButton : List<Button>
    lateinit var listOfOctalButton : List<Button>
    lateinit var lisrOfBinaryButton : List<Button>
    var isHexButtonClicked : Boolean = true
    var isOctButtonClicked : Boolean = false
    var isDecimalButtonClicked : Boolean = false
    var isBinButtonClicked : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialAllElemntOfCalculator()

        clearButton.setOnClickListener {
            clearTextView(numberWrittenTextView)
            clearTextView(resultNumberTextView)
            isBinButtonClicked = false
            isHexButtonClicked = false
            isDecimalButtonClicked = false
            isOctButtonClicked = false
        }
        removeButton.setOnClickListener {
            if(numberWrittenTextView.text.toString().length >=1)
                numberWrittenTextView.text = numberWrittenTextView.text.toString().dropLast(1)
        }

    }

    private fun clearTextView(textField : TextView){ textField.text = "" }
    private fun disabled(buttonOfNumbers : List<Button>){ buttonOfNumbers.map {it.isEnabled = false} }
    private fun enabled(buttonOfNumbers: List<Button>){ buttonOfNumbers.map {it.isEnabled = true} }

    // this method call (invoke) in XML -> [activity_main.xml] file on all number button
     fun onClickNumber(buttonClicked : View){
        if(numberWrittenTextView.text.toString() == "0")  this.clearTextView(numberWrittenTextView)
        val newDigigt = (buttonClicked as Button).text
        val oldDigit = numberWrittenTextView.text.toString()
        val addDigitToEnd = oldDigit + newDigigt
        val newNumber = addDigitToEnd
        numberWrittenTextView.text = newNumber

    }
     fun clickedToButtonOfNumberSystem(buttonOfNumberSystem : View){
        when((buttonOfNumberSystem as Button).text.toString()){
            "HEX" -> {enabled(listOfHexButton)
                isHexButtonClicked = true
                if(isHexButtonClicked && isDecimalButtonClicked){
                    resultNumberTextView.text =  convertDecimalToHex(numberWrittenTextView.text.toString())
                    isHexButtonClicked = false
                    isDecimalButtonClicked = false
                }
                if(isHexButtonClicked && isBinButtonClicked){
                    resultNumberTextView.text = convertBinaryToHex(numberWrittenTextView.text.toString())
                    isHexButtonClicked = false
                    isBinButtonClicked = false
                }
                if(isHexButtonClicked && isOctButtonClicked){
                    resultNumberTextView.text = convertOctalToHex(numberWrittenTextView.text.toString())
                    isHexButtonClicked = false
                    isOctButtonClicked = false
                }

            }
            "DEC" -> {
                disabled(listOfHexButton)
                enabled(listOfDecimalButton)
                isDecimalButtonClicked = true
                if(isDecimalButtonClicked && isHexButtonClicked){
                    resultNumberTextView.text = convertHexToDecimal(numberWrittenTextView.text.toString())
                    isHexButtonClicked = false
                    isDecimalButtonClicked = false
                }
                if(isDecimalButtonClicked && isBinButtonClicked) {
                    resultNumberTextView.text = convertBinaryToDecimal(numberWrittenTextView.text.toString())
                    isDecimalButtonClicked = false
                    isBinButtonClicked = false
                }
                if(isDecimalButtonClicked && isOctButtonClicked){
                    resultNumberTextView.text = convertOctalToDecimal(numberWrittenTextView.text.toString())
                    isDecimalButtonClicked = false
                    isOctButtonClicked = false
                }

            }
            "OCT" -> {
                disabled(listOfHexButton)
                enabled(listOfOctalButton)
                isOctButtonClicked = true
                if(isOctButtonClicked && isDecimalButtonClicked){
                    resultNumberTextView.text = convertDecimalToOctal(numberWrittenTextView.text.toString())
                    isOctButtonClicked = false
                    isDecimalButtonClicked = false
                }
                if(isOctButtonClicked && isHexButtonClicked){
                    resultNumberTextView.text = convertHexToOctal(numberWrittenTextView.text.toString())
                    isOctButtonClicked = false
                    isHexButtonClicked = false
                }
                if(isOctButtonClicked && isBinButtonClicked){
                    resultNumberTextView.text = convertBinaryToOctal(numberWrittenTextView.text.toString())
                    isOctButtonClicked = false
                    isHexButtonClicked = false
                }
            }
            "BIN" -> {
                isBinButtonClicked = true
                disabled(listOfHexButton)
                enabled(lisrOfBinaryButton)
                if(isBinButtonClicked && isDecimalButtonClicked){
                    resultNumberTextView.text = convertDecimalToBinary(numberWrittenTextView.text.toString())
                    isBinButtonClicked = false
                    isDecimalButtonClicked = false
                }
                if(isBinButtonClicked && isHexButtonClicked){
                    resultNumberTextView.text = convertHexToBinary(numberWrittenTextView.text.toString())
                    isBinButtonClicked = false
                    isHexButtonClicked = false
                }
                if(isBinButtonClicked && isOctButtonClicked){
                    resultNumberTextView.text = convertOctalToBinary(numberWrittenTextView.text.toString())
                    isBinButtonClicked = false
                    isOctButtonClicked = false
                }
            }
        }
    }

    // start the conversion functionality
    private fun convertDecimalToBinary(input: String):String {
        val decimalNumber = BigInteger(input)
        return decimalNumber.toString(2)
    }

    private fun convertDecimalToOctal(input: String):String{
        val decimalNum = input.toBigInteger()
        return decimalNum.toString(8)
    }

    private fun convertDecimalToHex(input: String): String {
        val bigInt = BigInteger(input)
        return bigInt.toString(16).uppercase(Locale.getDefault())
    }

    private fun convertBinaryToDecimal(input :String):String {
        val result = BigInteger(input)
        return result.toString(2)

    }

    private fun convertHexToBinary(input: String):String{
        val bigInteger = input.toBigInteger(16)
        return bigInteger.toString(2)

    }

    private fun convertBinaryToHex(input: String): String {
        val decimal = input.toInt(2)
        return Integer.toHexString(decimal)
    }

    private fun convertHexToDecimal(input: String) :String{
        return BigInteger(input, 16).toString()

    }

    private fun convertHexToOctal(input: String) : String{
        val decimal = BigInteger(input, 16)
        return decimal.toString(8)
    }

    private fun convertBinaryToOctal(input: String): String {
        val decimal = input.toInt(2)
        return decimal.toString(8)
    }

    private fun convertOctalToBinary(input: String):String{
        val decimal = input.toLong(8)
        return decimal.toString(2)
    }

    private fun convertOctalToDecimal(input: String) : String{
        return BigInteger(input,8).toString()

    }

    private fun convertOctalToHex(input: String):String{
        val decimal = BigInteger(input, 8)
        return decimal.toString(16)
    }


    private fun initialAllElemntOfCalculator(){
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
           F_Button    = findViewById(R.id.FButton)
           dotButton  = findViewById(R.id.DotButton)
           hexButton  = findViewById(R.id.appCompatButton2)
           decButton = findViewById(R.id.appCompatButton)
           octButton  = findViewById(R.id.appCompatButton4)
           binButton  = findViewById(R.id.appCompatButton3)
           equalButton = findViewById(R.id.EqualButton)
           removeButton = findViewById(R.id.appCompatButton5)
           clearButton   = findViewById(R.id.DELButton)
           numberWrittenTextView = findViewById(R.id.IDtextDefaultOfNumberInputInTop)
           resultNumberTextView  = findViewById(R.id.numberResult)

        listOfHexButton = listOf(
            zeroButton,
            oneButton,
            twoButton,
            threeButton,
            fourButton,
            fiveButton,
            sixButton,
            sevenButton,
            eightButton,
            nineButton,
            A_Button,
            B_Button,
            C_Button,
            D_Button,
            E_Button,
            F_Button
        )
        listOfDecimalButton  = listOf(
            zeroButton,
            oneButton,
            twoButton,
            threeButton,
            fourButton,
            fiveButton,
            sixButton,
            sevenButton,
            eightButton,
            nineButton
        )
        listOfOctalButton = listOf(
            zeroButton,
            oneButton,
            twoButton,
            threeButton,
            fourButton,
            fiveButton,
            sixButton,
            sevenButton
        )
        lisrOfBinaryButton= listOf(zeroButton,oneButton)
    }
}
package com.asl.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asl.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listOfDots: DotController = DotController()

    private val expression: Expression = Expression()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clearAllText()

        //region Listeners
        binding.btnBackspace.setOnClickListener {
            if (binding.textMain.text.endsWith(("."))) {
                listOfDots.SetLastDot(true)
            }

            if (isLastCharOperator(binding.textMain.text as String)) {
                listOfDots.GotoLast()
            }
            clearLast(binding.textMain.text as String)
            Calculate()
        }
        binding.btnBackspace.setOnLongClickListener {
            clearAllText();
            false
        }
        binding.btnOne.setOnClickListener {
            binding.textMain.text = addInput("1")
            Calculate()
        }
        binding.btnTwo.setOnClickListener {
            binding.textMain.text = addInput("2")
            Calculate()
        }
        binding.btnThree.setOnClickListener {
            binding.textMain.text = addInput("3")
            Calculate()
        }
        binding.btnFour.setOnClickListener {
            binding.textMain.text = addInput("4")
            Calculate()
        }
        binding.btnFive.setOnClickListener {
            binding.textMain.text = addInput("5")
            Calculate()
        }
        binding.btnSix.setOnClickListener {
            binding.textMain.text = addInput("6")
            Calculate()
        }
        binding.btnSeven.setOnClickListener {
            binding.textMain.text = addInput("7")
            Calculate()
        }
        binding.btnEight.setOnClickListener {
            binding.textMain.text = addInput("8")
            Calculate()
        }
        binding.btnNine.setOnClickListener {
            binding.textMain.text = addInput("9")
            Calculate()
        }
        binding.btnZero.setOnClickListener {
            binding.textMain.text = addInput("0")
            Calculate()
        }
        binding.btnOpenbr.setOnClickListener {
            if(isLastCharOperator(binding.textMain.text as String) || isLastCharPars(binding.textMain.text as String) || binding.textMain.text == "") binding.textMain.text = addInput("(")
            else if(!isLastCharOperator(binding.textMain.text as String) && !isLastCharPars(binding.textMain.text as String) && binding.textMain.text != "") binding.textMain.text = addInput("×(")
            listOfDots.GotoNext()
            Calculate()
        }
        binding.btnClosebr.setOnClickListener {
            binding.textMain.text = addInput(")")
            listOfDots.GotoNext()
            Calculate()
        }
        binding.btnMore.setOnClickListener {
            Calculate()
        }
        binding.btnEqual.setOnClickListener {
            equalButton()
        }
        binding.btnPlus.setOnClickListener {
            if (isLastCharOperator(binding.textMain.text as String)) clearLast(binding.textMain.text as String)
            binding.textMain.text = addInput("+")
            listOfDots.GotoNext()
            Calculate()
        }
        binding.btnMinus.setOnClickListener {
            if (isLastCharOperator(binding.textMain.text as String)) clearLast(binding.textMain.text as String)
            binding.textMain.text = addInput("-")
            listOfDots.GotoNext()
            Calculate()

        }
        binding.btnMultiply.setOnClickListener {
            if (isLastCharOperator(binding.textMain.text as String)) clearLast(binding.textMain.text as String)
            binding.textMain.text = addInput("×")
            listOfDots.GotoNext()
            Calculate()
        }
        binding.btnDivide.setOnClickListener {
            if (isLastCharOperator(binding.textMain.text as String)) clearLast(binding.textMain.text as String)
            binding.textMain.text = addInput("÷")
            listOfDots.GotoNext()
            Calculate()
        }
        binding.btnDot.setOnClickListener {
            if (listOfDots.CheckForLast()) {
                if(isLastCharOperator(binding.textMain.text as String) || isLastCharPars(binding.textMain.text as String)) binding.textMain.text = addInput("0.")
                else binding.textMain.text = addInput(".")
                listOfDots.SetLastDot(false)
                Calculate()
            }
        }
        //endregion
    }


    //region TextMethods
    private fun isLastCharOperator(text: String): Boolean{
    return text.endsWith("+") || text.endsWith("-") || text.endsWith("×") || text.endsWith("÷")
    }
    private fun isLastCharPars(text: String): Boolean{
        return text.endsWith("(") || text.endsWith(")")
    }
    private fun addInput(buttonText: String) : String{


//        if(buttonText.endsWith('.') && isLastCharOperator(buttonText)) return "${binding.textMain.text}0$buttonText"
//        //if text ends with ) and have no operator then basic operator will be applied
//        else if (binding.textMain.text.endsWith(')' ) && !isLastCharOperator(buttonText)) return "${binding.textMain.text}×$buttonText"
        return "${binding.textMain.text}$buttonText"
    }
    private fun Calculate(){
        try {
            val str: String = expression.calculate(binding.textMain.text.toString().replace('×','*').replace('÷','/'))
            binding.textResult.text = str
            if (binding.textMain.text == "9+10") {
                binding.textResult.text = "21"
            }
        }
        catch (exception : Throwable){
            binding.textResult.text = ""
        }

    }
    private fun clearLast(text : String){
        binding.textMain.text = text.dropLast(1)
    }
    private fun clearAllText(){
        binding.textMain.text = ""
        binding.textResult.text = ""
        listOfDots.Clear()
    }
    private fun equalButton(){
        binding.textLast.text = binding.textThird.text
        binding.textThird.text = binding.textSec.text
        binding.textSec.text = binding.textMain.text
        binding.textMain.text = binding.textResult.text
        binding.textResult.text = ""
    }
    //endregion
}


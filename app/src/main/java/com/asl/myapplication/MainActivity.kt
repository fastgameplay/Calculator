package com.asl.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asl.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listOfDots: DotController = DotController()
    private val postFx: PostFx = PostFx


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ClearAllText()

        //region Listeners
        binding.btnBackspace.setOnClickListener {
            if (binding.textMain.text.endsWith(("."))) {
                listOfDots.SetLastDot(true)
            }

            if (IsLastCharOperator(binding.textMain.text as String)) {
                listOfDots.GotoLast()
            }

            ClearLast(binding.textMain.text as String)
        }
        binding.btnOne.setOnClickListener {
            binding.textMain.text = AddInput("1")
        }
        binding.btnTwo.setOnClickListener {
            binding.textMain.text = AddInput("2")
        }
        binding.btnThree.setOnClickListener {
            binding.textMain.text = AddInput("3")
        }
        binding.btnFour.setOnClickListener {
            binding.textMain.text = AddInput("4")
        }
        binding.btnFive.setOnClickListener {
            binding.textMain.text = AddInput("5")
        }
        binding.btnSix.setOnClickListener {
            binding.textMain.text = AddInput("6")
        }
        binding.btnSeven.setOnClickListener {
            binding.textMain.text = AddInput("7")
        }
        binding.btnEight.setOnClickListener {
            binding.textMain.text = AddInput("8")
        }
        binding.btnNine.setOnClickListener {
            binding.textMain.text = AddInput("9")
        }
        binding.btnZero.setOnClickListener {
            binding.textMain.text = AddInput("0")
        }
        binding.btnOpenbr.setOnClickListener {
            binding.textMain.text = AddInput("(")
        }
        binding.btnClosebr.setOnClickListener {
            binding.textMain.text = AddInput(")")
        }
        binding.btnMore.setOnClickListener {
            ToPostFx()
        }
        binding.btnPlus.setOnClickListener {
            if (IsLastCharOperator(binding.textMain.text as String)) ClearLast(binding.textMain.text as String)
            binding.textMain.text = AddInput("+")
            listOfDots.GotoNext()
        }
        binding.btnMinus.setOnClickListener {
            if (IsLastCharOperator(binding.textMain.text as String)) ClearLast(binding.textMain.text as String)
            binding.textMain.text = AddInput("-")
            listOfDots.GotoNext()

        }
        binding.btnMultiply.setOnClickListener {
            if (IsLastCharOperator(binding.textMain.text as String)) ClearLast(binding.textMain.text as String)
            binding.textMain.text = AddInput("×")
            listOfDots.GotoNext()

        }
        binding.btnDivide.setOnClickListener {
            if (IsLastCharOperator(binding.textMain.text as String)) ClearLast(binding.textMain.text as String)
            binding.textMain.text = AddInput("÷")
            listOfDots.GotoNext()
        }
        binding.btnDot.setOnClickListener {
            if (listOfDots.CheckForLast()) {
                binding.textMain.text = AddInput(".")
                listOfDots.SetLastDot(false)
            }
        }
        //endregion
    }


    //region TextMethods
    private fun IsLastCharOperator(text: String): Boolean{
    return text.endsWith("+") || text.endsWith("-") || text.endsWith("×") || text.endsWith("÷")
    }
    private fun AddInput(buttonText: String) : String{

        return "${binding.textMain.text}$buttonText"
    }

    private fun ToPostFx(){
        var str = postFx.ToPostFx(binding.textMain.text.toString())
        binding.textResult.text = str.toString()
    }
    private fun ClearLast(text : String){
        binding.textMain.text = text.dropLast(1)
    }
    private fun ClearAllText(){
        binding.textMain.text = ""
        binding.textResult.text = ""
        listOfDots.Clear()
    }
    //endregion
}
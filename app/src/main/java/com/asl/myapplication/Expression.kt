package com.asl.myapplication

class Expression {
    private val tkn: Token = Token()

    private val postFx: PostFx = PostFx

    fun calculate(_input: String): String{

        val pFXExpression: List<String> = postFx.ToPostFx(tkn.ToTokens(_input))
        val stack = Stack()
        for (i in pFXExpression){
            if(isOperator(i)){
                val firstNum = stack.pop().toDouble()
                val secondNum = stack.pop().toDouble()
                stack.push(operation(i,firstNum,secondNum).toString())
            }
            else stack.push(i)

        }
        if(stack.isEmpty() || stack.size() > 1) return "Error"
        else return stack.pop()
    }


    private fun isOperator(item: String): Boolean{
        return item == "+" || item == "-" || item == "/" || item == "*"
    }
    private fun operation(operator: String, firstNum:Double, secondNum:Double):Double{
        when(operator){
            "+" -> return secondNum + firstNum
            "-" -> return secondNum - firstNum
            "*" -> return secondNum * firstNum
            "/" -> return secondNum / firstNum
            else -> return 0.0
        }
    }
}
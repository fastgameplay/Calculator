package com.asl.myapplication
//pfff thath was easy only 18h passed
internal object PostFx {

    val OPS: MutableMap<String, Operator> = HashMap()
    //Takes splitted infix notation and transforms it into Reverse Postfix Nonation
    fun ToPostFx(_Input : List<String>): List<String> {

        val tokens: List<String> = _Input
        val output: MutableList<String> = mutableListOf()
        val stack = Stack()


        for (token in tokens) {
            if (OPS.containsKey(token)) {
                while (!stack.isEmpty() && OPS.containsKey(stack.peek())) {
                    val currentOp = OPS[token] // Current operator
                    val lastOp = OPS[stack.peek()] // Top operator from the stack
                    if (currentOp!!.associativity === Associativity.LEFT && currentOp!!.comparePrecedence(lastOp!!) <= 0 ||
                        currentOp!!.associativity === Associativity.RIGHT && currentOp!!.comparePrecedence(lastOp!!) < 0
                    ) {
                        // Pop (y) and add to output buffer
                        output.add(stack.pop())
                        continue
                    }
                    break
                }
                // Push the new operator on the stack
                stack.push(token)
            } else if ("(" == token) {
                //If token is left parnthesis, then push it on the stack
                stack.push(token)
            } else if (")" == token) {
                // If the token is right parenthesis
                while (!stack.isEmpty() && stack.peek() != "(") {
                    // Pop from the stack to the output buffer

                    output.add(stack.pop())
                }
                //Pop the left parenthesis from the stack
                stack.pop()
            } else {
                //Add token to output buffer
                output.add(token)
            }
        }
        while (!stack.isEmpty()) {
            output.add(stack.pop())
        }
        return output
    }


    init {

        for (operator in Operator.values()) {
            OPS[operator.symbol] = operator
        }
    }
}
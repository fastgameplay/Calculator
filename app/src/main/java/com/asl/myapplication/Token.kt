package com.asl.myapplication

class Token {

    fun PreTokens(inputString: String): List<String> {
        val tokens: MutableList<String> = ArrayList()

        tokens.add(Character.toString(inputString[0]))

        // iterate over the list
        for (i in 1 until inputString.length) {
            val currentCh = inputString[i]
            val lastCh = inputString[i - 1]


            if ((Character.isDigit(currentCh) || currentCh == '.') && (Character.isDigit(lastCh) || lastCh == '.')) {
                val lastIndex = tokens.size - 1
                tokens[lastIndex] = tokens[lastIndex] + currentCh
            } else {
                tokens.add(Character.toString(currentCh))
            }
        }
        return tokens
    }
}
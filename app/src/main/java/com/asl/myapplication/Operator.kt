package com.asl.myapplication
//Help
enum class Operator(val symbol: String, associativity: Associativity, precedence: Int) :

    Comparable<Operator>{
    ADDITION("+", Associativity.LEFT, 0),
    SUBTRACTION("-", Associativity.RIGHT, 0),
    DIVISION("/", Associativity.LEFT, 5),
    MULTIPLICATION("*", Associativity.LEFT, 5),
    POWER("^", Associativity.RIGHT, 10);

    val associativity: Associativity
    val precedence: Int

    fun comparePrecedence(operator: Operator): Int {
        return precedence - operator.precedence
    }

    init {
        this.associativity = associativity
        this.precedence = precedence
    }
}
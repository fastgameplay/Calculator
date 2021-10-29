package com.asl.myapplication
//Help
enum class Operator(val symbol: String, associativity: Associativity, precedence: Int) :

    Comparable<Operator>{
    ADDITION("+", Associativity.LEFT, 0),
    SUBTRACTION("-", Associativity.RIGHT, 0),
    DIVISION("/", Associativity.LEFT, 1),
    MULTIPLICATION("*", Associativity.LEFT, 1),
    POWER("^", Associativity.RIGHT, 2);

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
package com.asl.myapplication

//turns MutableList into Stack
class Stack{
    val elements: MutableList<String> = mutableListOf()

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    fun push(item: String) = elements.add(item)

    fun pop() : String {
        val item = elements.lastOrNull()
        if (!isEmpty()){
            elements.removeAt(elements.size -1)
        }
        return item.toString()
    }
    fun peek() : Any? = elements.lastOrNull()

    override fun toString(): String = elements.toString()
}
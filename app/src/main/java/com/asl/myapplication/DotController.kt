package com.asl.myapplication

class DotController {
    //2 cups of tea and its working
    //if last member of list is true -> placing dot is possible
    private val IsPossible: ArrayList<Boolean> = arrayListOf(true)

    fun CheckId(value : Int) : Boolean{
        return IsPossible[value]
    }
    fun CheckForLast() : Boolean{
        return IsPossible.last()
    }
    fun GotoNext(){
        IsPossible.add(true)
    }
    fun GotoLast(){
        if(IsPossible.count() > 1)
            IsPossible.removeLast()
    }
    fun SetLastDot(value :Boolean){
        IsPossible[IsPossible.lastIndex] = value
    }
    fun Clear(){
        IsPossible.clear()
        IsPossible.add(true)
    }


}
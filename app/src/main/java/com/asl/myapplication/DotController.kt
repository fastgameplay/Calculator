package com.asl.myapplication

class DotController {
    //2 cups of tea and its working
    //if last member of list is true -> placing dot is possible
    private val IsPossible: MutableList<Boolean> = mutableListOf(true)

    public fun CheckId(value : Int) : Boolean{
        return IsPossible[value]
    }
    public fun CheckForLast() : Boolean{
        return IsPossible.last()
    }
    public fun GotoNext(){
        IsPossible.add(true)
    }
    public fun GotoLast(){
        if(IsPossible.count() > 1)
            IsPossible.removeLast()
    }
    public fun SetLastDot(value :Boolean){
        IsPossible[IsPossible.lastIndex] = value
    }
    public fun Clear(){
        IsPossible.clear()
        IsPossible.add(true)
    }


}
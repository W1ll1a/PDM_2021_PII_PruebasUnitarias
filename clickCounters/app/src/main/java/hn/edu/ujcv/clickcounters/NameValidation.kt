package hn.edu.ujcv.clickcounters

object NameValidation {

    fun playerName(name:String):Boolean{
        if (name.isEmpty()){
            return false
        } else
        if (name.length < 3 ){
            return false
        }else
        return true
    }
}
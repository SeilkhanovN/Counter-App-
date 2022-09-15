package com.example.counterapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var temp: Int = 0
    private var _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init{
        _number.value = 0
    }
    fun add() {
        _number.value = _number.value?.plus(1)
    }
    fun minus(){
        _number.value = _number.value?.minus(1)
    }
    fun reset(){
        _number.value = 0
    }


}

package com.example.ezetapapplicaton.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel:ViewModel() {
    var showProgressBar=MutableLiveData<Boolean>()
     var showToast=MutableLiveData<String>();

}
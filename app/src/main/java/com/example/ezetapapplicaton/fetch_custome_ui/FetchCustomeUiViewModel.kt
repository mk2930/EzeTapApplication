package com.example.ezetapapplicaton.fetch_custome_ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ezetapapplicaton.base.BaseViewModel
import com.example.ezetapapplicaton.data.model.FetchCustomeDataResponse
import kotlinx.coroutines.launch

class FetchCustomeUiViewModel : BaseViewModel(), FunctionFetchCustomeUiViewModel {

    var openDisplayActivity = MutableLiveData<Boolean>()
    var data: FetchCustomeDataResponse? = null

    val repo = FetchCutomeUiReposatory(this)

    override fun fetchCustomeUi() {

        viewModelScope.launch {
            showProgressBar.value=true
            repo.fetchCustomeui()
        }

    }

    override fun openDisplayUiActivity(data: FetchCustomeDataResponse) {
        showProgressBar.value=false
        this.data=data
        openDisplayActivity.value = true

    }


    override fun toastMessage(message: String) {

    }
}
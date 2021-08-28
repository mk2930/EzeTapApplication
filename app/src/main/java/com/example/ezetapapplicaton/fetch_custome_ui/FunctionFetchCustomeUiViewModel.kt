package com.example.ezetapapplicaton.fetch_custome_ui

import com.example.ezetapapplicaton.data.model.FetchCustomeDataResponse

interface FunctionFetchCustomeUiViewModel {

    fun fetchCustomeUi()
    fun openDisplayUiActivity(data: FetchCustomeDataResponse)
    fun toastMessage(message:String)

}
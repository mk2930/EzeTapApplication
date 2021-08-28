package com.example.ezetapapplicaton.fetch_custome_ui

import android.util.Log
import com.example.ezetapapplicaton.data.network.NetWorkErrorCall
import com.example.ezetapapplicaton.data.network.RetrofitClient
import com.example.ezetapapplicaton.utils.CommonUtils
import retrofit2.await

class FetchCutomeUiReposatory(val listner: FunctionFetchCustomeUiViewModel) : NetWorkErrorCall,
    FunctonsFetchCustomeUiReposatory {
    override fun error(errorMessages: String) {
        listner.toastMessage(errorMessages)
        Log.e("error", "errorMessages")
    }


    override suspend fun fetchCustomeui() {
        try {
            val response = RetrofitClient.getApiInterface(this).fetchCutomeUi().await()
            listner.openDisplayUiActivity(response)

        } catch (e: Exception) {
            error(CommonUtils.SOMETHING_WENT_WRONG)
        }


    }
}
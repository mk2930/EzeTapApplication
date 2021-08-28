package com.example.ezetapapplicaton.data.network

import com.example.ezetapapplicaton.data.model.FetchCustomeDataResponse
import com.example.ezetapapplicaton.fetch_custome_ui.FetchCustomeUiViewModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("android_assignment.json")
    fun fetchCutomeUi(): Call<FetchCustomeDataResponse>
}
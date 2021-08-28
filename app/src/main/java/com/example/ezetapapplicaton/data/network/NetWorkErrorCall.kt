package com.example.ezetapapplicaton.data.network

import okhttp3.Response

interface NetWorkErrorCall {
   fun error(errorMessages:String)

}
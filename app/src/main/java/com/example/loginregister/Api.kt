package com.example.loginregister

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface Api {
    @GET ("everything")
    @Headers ("Authorization: token 0a5ccf7430244411907b9623c63b9f69")
    fun getSearchNews (@Query("q") topic : String): Call<NewsResponse>
}
package com.example.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET

//it represents the REST API we are using .

interface JsonPlaceholderAPI {

    // "posts is a relative URL ....we will pass the base URL at some other place"
    @GET("posts")
    fun getData () : Call<List<Data>> //retrofit will auto implement it
}
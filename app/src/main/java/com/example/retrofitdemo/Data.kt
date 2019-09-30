package com.example.retrofitdemo

import com.google.gson.annotations.SerializedName

public class Data {
    var userId :Int = 0
    var id : Int = 0
    var title : String = ""
    @SerializedName("body")
    var text : String = ""
}
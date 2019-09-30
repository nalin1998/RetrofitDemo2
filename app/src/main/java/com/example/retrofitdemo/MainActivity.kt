package com.example.retrofitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceholderAPI = retrofit.create(JsonPlaceholderAPI::class.java)

        val data: Call<List<Data>> = jsonPlaceholderAPI.getData()

        data.enqueue(object : Callback<List<Data>> {

            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (!response.isSuccessful) {
                    text_result.text = "Code :" + response.code()
                    return
                }

                val datas = response.body() as List<Data>

                for (post in datas) {
                    var content: String = ""
                    content += "ID : " + post.id + "\n"
                    content += "UserID :" + post.userId + "\n"
                    content += "Title :" + post.title + "\n"
                    content += "Text :" + post.text + "\n"

                    text_result.append(content)
                }

            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                text_result.text = t.message
            }
        })
    }
}

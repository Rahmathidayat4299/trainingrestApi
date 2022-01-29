package com.example.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getPost()
        val buttoGet = findViewById<Button>(R.id.btn_get)
       buttoGet.setOnClickListener {  call.enqueue(object : retrofit2.Callback<MutableList<PostModel>> {
           override fun onResponse(
               call: Call<MutableList<PostModel>>,
               response: Response<MutableList<PostModel>>
           ) {
               if (response.isSuccessful){
                   Log.e("Succes",response.body().toString())
               }
           }

           override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
               t.printStackTrace()
               Log.e("gagal",t.message.toString())
           }

       }) }
    }
}
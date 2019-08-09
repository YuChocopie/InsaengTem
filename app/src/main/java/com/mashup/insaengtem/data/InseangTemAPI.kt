package com.mashup.insaengtem.data


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class InseangTemAPI {

    fun dataInfoRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(" https://inseangtem.herokuapp.com/")
            .build()
        return retrofit!!
    }
}
package com.mashup.insaengtem.data

import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.HTTP
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET


interface InSeangTemInterface {

//    /** Get StationResponse with TM Position **/
//    @GET("/quiz/mocktest?subject=Database&subject=operation_system")
//    fun test(): Observable<List<Quiz>>

    @GET("/posts/post/")
    fun getpost() Observable<List<>>

}
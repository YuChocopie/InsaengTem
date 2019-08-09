package com.mashup.insaengtem.data

import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface InsaengtemInterface {

//    /** Get StationResponse with TM Position **/
//    @GET("/quiz/mocktest?subject=Database&subject=operation_system")
//    fun test(): Observable<List<Quiz>>
//@POST("/register/wrong")
//fun setWrongQuiz(@Body value: Wrong): Flowable<Wrong>

    @GET("/posts/post")
    fun getpost(): Observable<List<MainItemCard>>

    @POST("/rest-auth/registration/")
    fun signUp(@Body value:User) :Flowable<String>

    @POST("/rest-auth/login/")
    fun signIn(@Body value:UserLogin):Flowable<String>
}
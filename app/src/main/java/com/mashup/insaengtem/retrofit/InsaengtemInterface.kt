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

    @POST("/rest-auth/registration/")
    fun signUp(@Body value:User) :Flowable<String>

    @POST("/rest-auth/login/")
    fun signIn(@Body value:UserLogin):Flowable<String>

    @GET("rest-auth/logout/")
    fun logOut()   // 반환해줄게 없어서 스트링으로 해봤음

    //글 생성하기
    @POST("/posts/post/")
    fun getpost(): Observable<List<MainItemCard>>

    //글 전체 조회하기
    @GET("/posts/post/")
    fun Searchpost()    // 반환해줄게 없어서 스트링으로 해봤음


    //카테고리별

    @GET("/tags/2")
    fun findCategory()

    @POST("/posts/bookmark/")
    fun makeBookmark()

}


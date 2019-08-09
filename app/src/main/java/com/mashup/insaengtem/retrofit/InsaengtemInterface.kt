package com.mashup.insaengtem.data

import io.reactivex.Observable
import retrofit2.http.GET


interface InsaengtemInterface {

//    /** Get StationResponse with TM Position **/
//    @GET("/quiz/mocktest?subject=Database&subject=operation_system")
//    fun test(): Observable<List<Quiz>>

    @GET("/posts/post")
    fun getpost(): Observable<List<MainItemCard>>
}
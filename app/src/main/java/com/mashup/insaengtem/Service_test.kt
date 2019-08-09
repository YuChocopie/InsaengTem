package com.mashup.insaengtem


import android.widget.CheckBox
import retrofit2.Call
import retrofit2.http.*
import java.net.URL

data class RegisterForm(
    var id: String?=null,
    var image: URL? = null,
    var description: String? = null,
    var category1: CheckBox? = null,
    var category2: CheckBox? = null,
    var category3: CheckBox? = null,
    var category4: CheckBox? = null,
    var category5: CheckBox? = null,
    var category6: CheckBox? = null,
    var category7: CheckBox? = null,
    var category8: CheckBox? = null,
    var category9: CheckBox? = null,
    var category10: CheckBox? = null,
    var user_id : Int? = null
)

//https://inseangtem.herokuapp.com/posts/post/

interface Service_test {

    @GET("/api/v1/registration/{id}")
    fun getReg(
        @Path("id")id: String
    ):Call<RegisterForm>

    @FormUrlEncoded
    @POST("/api/v1/registration/")
    fun postReg(
        @Field("username") username: String?,
        @Field("password1") password1: String?,
        @Field("password2") password2: String?
    ):Call<RegisterForm>

    @FormUrlEncoded
    @PUT("/api/v1/registration/{id}/")
    fun putReg(
        @Path("id")id: String?,
        @Field("username")username:String?,
        @Field("user_photo")user_photo:String?
    ):Call<RegisterForm>


    @DELETE("/api/v1/registration/{id}/")
    fun deleteReg(
        @Path("id")id: String?
    ):Call<RegisterForm>

}
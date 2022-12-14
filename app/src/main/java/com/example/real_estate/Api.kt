package com.example.real_estate

import retrofit2.Call
import retrofit2.http.*

interface Api {

    @FormUrlEncoded
    @POST ("/User/Signup")
    fun createUser(
        @Field("email") email: String,
        @Field("password") password:  String
    ): Call<User>

    @FormUrlEncoded
    @POST ("/User/Login")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password:  String
    ): Call<UserLogin>

    @FormUrlEncoded
    @POST ("/Products")
    fun uploadProduct(
        @Field("Name") Name: String,
        @Field("Sale") Sale: String,
        @Field("Price") Price:  Int,
        @Field("Area") Area:  Int,
        @Field("Photo") Photo:  String,
        @Field("Region") Region:  String,
        @Field("ZipCode") ZipCode:  Int,
        @Field("Roof") Roof:  Int,
        @Field("Bedrooms") Bedrooms:  Int,
        @Field("Description") Description: String
    ): Call<UploadResponse>

    @GET("Search/")
    fun filters(
        @Query("Sale") Sale: String,
        @Query("Region") Region: String,
        @Query("minPrice") minPrice: Int,
        @Query("maxPrice") maxPrice: Int,
        @Query("sqMin") minArea: Int,
        @Query("sqMax") maxArea: Int,
    ): Call<Test>

    @GET("Search/")
    fun searchFirstToSecond(
        @Query("Region") Region: String,
        @Query("Sale") Sale: String,
        @Query("minPrice") minPrice: Int,
        @Query("maxPrice") maxPrice: Int,
    ): Call<Test>

}
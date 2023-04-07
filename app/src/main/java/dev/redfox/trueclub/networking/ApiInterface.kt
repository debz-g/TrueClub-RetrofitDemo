package dev.redfox.trueclub.networking

import dev.redfox.trueclub.models.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/")
    suspend fun getDetails(@Query("name")name: String): Response<DataModel>
}
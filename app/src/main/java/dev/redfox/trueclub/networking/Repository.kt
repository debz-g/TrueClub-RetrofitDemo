package dev.redfox.trueclub.networking

import dev.redfox.trueclub.models.DataModel
import retrofit2.Response

class Repository (private val apiInterface: ApiInterface) {

    suspend fun getDetails(name: String): Response<DataModel> {
        return RetrofitInstance.api.getDetails(name)
    }
}
package id.ihwan.sintangpedia

import retrofit2.Response
import retrofit2.http.GET

interface RestApi {
    @GET("wisata.json")
    suspend fun getPlace(): Response<MutableList<Place>>
}
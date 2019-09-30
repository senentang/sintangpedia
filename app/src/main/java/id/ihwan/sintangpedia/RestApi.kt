package id.ihwan.sintangpedia

import retrofit2.Response
import retrofit2.http.GET

interface RestApi {
    @GET("place.json")
    suspend fun getPlace(): Response<MutableList<Place>>
}
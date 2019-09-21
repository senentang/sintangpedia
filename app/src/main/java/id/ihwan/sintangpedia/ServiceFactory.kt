package id.ihwan.sintangpedia

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceFactory {
    fun create(): RestApi {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) logging.level = HttpLoggingInterceptor.Level.BODY else logging.level = HttpLoggingInterceptor.Level.NONE

        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(logging)
        clientBuilder.connectTimeout(60L, TimeUnit.SECONDS)
        clientBuilder.readTimeout(60L, TimeUnit.SECONDS)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://sintangpedia.web.app")
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()
        return retrofit.create(RestApi::class.java)
    }
}
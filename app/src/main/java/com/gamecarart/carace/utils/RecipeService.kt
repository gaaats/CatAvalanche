package com.gamecarart.carace.utils

import com.gamecarart.carace.recycler.Person
import okhttp3.Interceptor
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    companion object {
        const val BASE_URL = "https://api.api-ninjas.com/v1/"
        const val API_KEY = ""
        const val NAME_FOOD = "pepper"
    }


    @GET("recipe")
    suspend fun getRecipes(
        @Query("query") query : String = NAME_FOOD,
    ): Response<Person>


}

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Api-Key", RecipeService.API_KEY)
            .build()
        return chain.proceed(request)
    }
}
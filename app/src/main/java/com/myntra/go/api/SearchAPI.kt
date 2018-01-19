package com.myntra.go.api

import com.myntra.go.api.models.search.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Chethan.n on 17/01/18.
 */
interface SearchAPI {
    @GET("search/data/{query}")
    fun getProducts(@Path("query") query: String): Call<SearchResult>
}
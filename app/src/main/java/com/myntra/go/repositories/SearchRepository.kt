package com.myntra.go.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.myntra.go.api.SearchAPI
import com.myntra.go.api.models.search.SearchResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Chethan.n on 18/01/18.
 */
class SearchRepository(private var searchAPI: SearchAPI) {

    fun getProducts(query: String): LiveData<SearchResult> {
        val data = MutableLiveData<SearchResult>()
        searchAPI.getProducts(query).enqueue(object: Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>?, response: Response<SearchResult>?) {
                if (response != null) {
                    data.setValue(response.body())
                }
            }
            override fun onFailure(call: Call<SearchResult>?, t: Throwable?) {

            }
        })
        return data
    }
}
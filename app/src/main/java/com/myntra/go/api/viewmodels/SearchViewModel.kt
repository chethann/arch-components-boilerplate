package com.myntra.go.api.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.myntra.go.api.models.search.SearchResult
import com.myntra.go.repositories.SearchRepository

/**
 * Created by Chethan.n on 18/01/18.
 */
class SearchViewModel(var searchRepository: SearchRepository): ViewModel() {

    lateinit var searchResult: LiveData<SearchResult>

    fun init(query: String) {
        searchResult = searchRepository.getProducts(query)
    }

    fun getResult() : LiveData<SearchResult> = searchResult


    class Factory(): ViewModelProvider.NewInstanceFactory() {
        lateinit var mSearchRepository: SearchRepository

        constructor(searchRepository: SearchRepository) : this() {
            mSearchRepository = searchRepository
        }

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SearchViewModel(mSearchRepository) as T
        }
    }
}
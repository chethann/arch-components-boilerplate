package com.myntra.go.di.modules

import com.myntra.go.api.SearchAPI
import com.myntra.go.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Chethan.n on 18/01/18.
 */

@Module
class SearchModule {

    @ActivityScope
    @Provides
    fun provideSearchAPI(retrofit: Retrofit) : SearchAPI {
        return retrofit.create(SearchAPI::class.java)
    }
}
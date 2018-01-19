package com.myntra.go.di.modules

import android.app.Application
import android.content.Context
import com.myntra.go.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Chethan.n on 17/01/18.
 */

@Module
class APIModule(private val app: Application) {

    @Provides
    @ApplicationScope
    fun provideContext(): Context = app

    @Provides
    @ApplicationScope
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @ApplicationScope
    fun provideBaseUrl(): String {
        return "https://developer.myntra.com/"
    }


}
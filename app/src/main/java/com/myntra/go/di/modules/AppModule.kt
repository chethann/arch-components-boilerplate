package com.myntra.go.di.modules

import android.app.Application
import com.myntra.go.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides



/**
 * Created by Chethan.n on 18/01/18.
 */

@Module
class AppModule(private val mApplication: Application) {

    @Provides
    @ApplicationScope
    fun providesApplication(): Application {
        return mApplication
    }
}
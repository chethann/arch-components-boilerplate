package com.myntra.go

import android.app.Application
import com.myntra.go.di.components.APIComponent
import com.myntra.go.di.components.AppComponent
import com.myntra.go.di.components.DaggerAPIComponent
import com.myntra.go.di.components.DaggerAppComponent
import com.myntra.go.di.modules.APIModule
import com.myntra.go.di.modules.AppModule

/**
 * Created by Chethan.n on 17/01/18.
 */
class MyntraApplication: Application() {

    lateinit var myntraAPI: APIComponent
    lateinit var myntraApplication: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        myntraAPI =
                DaggerAPIComponent.builder()
                        .aPIModule(APIModule(this))
                        .build()

        myntraApplication = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    public fun getAppComponent() = myntraApplication

    public fun getAPIComponent() = myntraAPI
}
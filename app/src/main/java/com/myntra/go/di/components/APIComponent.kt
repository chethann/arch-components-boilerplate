package com.myntra.go.di.components

import com.myntra.go.MyntraApplication
import com.myntra.go.di.modules.APIModule
import com.myntra.go.di.scopes.ApplicationScope
import dagger.Component
import retrofit2.Retrofit


/**
 * Created by Chethan.n on 17/01/18.
 */
@ApplicationScope
@Component(modules = arrayOf(APIModule::class))
interface APIComponent {
    fun inject(target: MyntraApplication)

    fun retrofit(): Retrofit
}
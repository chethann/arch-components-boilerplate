package com.myntra.go.di.components

import com.myntra.go.MyntraApplication
import com.myntra.go.di.modules.AppModule
import com.myntra.go.di.scopes.ApplicationScope
import dagger.Component

/**
 * Created by Chethan.n on 18/01/18.
 */
@ApplicationScope
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(target: MyntraApplication)
}
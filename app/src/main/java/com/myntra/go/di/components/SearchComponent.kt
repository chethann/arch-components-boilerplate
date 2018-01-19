package com.myntra.go.di.components

import com.myntra.go.di.modules.SearchModule
import com.myntra.go.di.scopes.ActivityScope
import com.myntra.go.views.search.SearchActivity
import dagger.Component

/**
 * Created by Chethan.n on 18/01/18.
 */
@ActivityScope
@Component(dependencies = arrayOf(APIComponent::class), modules = arrayOf(SearchModule::class))
interface SearchComponent {
    fun inject(target: SearchActivity)
}
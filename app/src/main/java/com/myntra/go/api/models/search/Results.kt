package com.myntra.go.api.models.search

import java.io.Serializable

/**
 * Created by Chethan.n on 17/01/18.
 */
class Results: Serializable {
    var products: List<Product> = emptyList<Product>()
}
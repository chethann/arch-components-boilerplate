package com.myntra.go.api.models.search

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Chethan.n on 17/01/18.
 */
class Product : Serializable {
    var stylename : String = ""

    @SerializedName("search_image")
    var searchImage: String = ""
    var styleid: Number = 0
}
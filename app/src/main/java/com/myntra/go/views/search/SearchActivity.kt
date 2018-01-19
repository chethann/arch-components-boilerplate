package com.myntra.go.views.search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.myntra.go.MyntraApplication
import com.myntra.go.R
import com.myntra.go.api.SearchAPI
import com.myntra.go.api.models.search.Product
import com.myntra.go.api.models.search.SearchResult
import com.myntra.go.api.viewmodels.SearchViewModel
import com.myntra.go.di.components.DaggerSearchComponent
import com.myntra.go.di.modules.SearchModule
import com.myntra.go.repositories.SearchRepository
import com.myntra.go.views.product.PDPActivity
import javax.inject.Inject


class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var mSearchAPI: SearchAPI
    lateinit var mSearchViewModel: SearchViewModel
    lateinit var productlistAdapter: SearchAdapter
    lateinit var itemClickListner: View.OnClickListener

    private var mProducts: List<Product> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        initDagger()
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView () {
        val recyclerView: RecyclerView = findViewById(R.id.products_rv)

        itemClickListner = View.OnClickListener(fun (view: View) {
            val position = recyclerView.getChildLayoutPosition(view)
            val intent = Intent(this, PDPActivity::class.java)

            intent.putExtra("styleid", mProducts.get(position)?.styleid)
            intent.putExtra("url", mProducts.get(position)?.searchImage)
            val image: ImageView = view.findViewById(R.id.product_image)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, image as View, "search_image")
            startActivity(intent, options.toBundle())
        })


        productlistAdapter = SearchAdapter(mProducts, itemClickListner)
        recyclerView.adapter = productlistAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2,GridLayoutManager.VERTICAL , false)
    }

    private fun initViewModel () {
        val searchRepository = SearchRepository(mSearchAPI)
        val factory = SearchViewModel.Factory(searchRepository)

        val mSearchViewModel = ViewModelProviders.of(this, factory)
                .get(SearchViewModel::class.java!!)

        mSearchViewModel.init("nike")

        mSearchViewModel.getResult().observe(this, object : Observer<SearchResult> {
            override fun onChanged(t: SearchResult?) {
                if (t != null) {
                    mProducts = t.data.results.products
                    productlistAdapter.setProducts(mProducts)
                    productlistAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun initDagger() {
        DaggerSearchComponent.builder()
                .aPIComponent((getApplication() as MyntraApplication).getAPIComponent())
                .searchModule(SearchModule())
                .build().inject(this)
    }
}

package com.myntra.go.views.product

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.myntra.go.R
import kotlinx.android.synthetic.main.activity_pdp.*

class PDPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdp)
        setSupportActionBar(toolbar)

        val image: ImageView = findViewById(R.id.pdp_image)

        val url: String = intent.getStringExtra("url")

        Glide
                .with(this)
                .load(url)
                .into(image)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}

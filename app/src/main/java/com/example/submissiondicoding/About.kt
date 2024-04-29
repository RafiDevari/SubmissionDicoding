package com.example.submissiondicoding

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target


class About : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        val imageUrl = "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:7b6a8b844ec52ce1364914439361486e20230318144226.png"
        val imageme: ImageView =findViewById(R.id.imageme)

        Glide.with(this)
            .load(imageUrl)
            .into(imageme)
    }
}
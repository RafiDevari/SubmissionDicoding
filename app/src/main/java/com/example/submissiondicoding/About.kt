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


        val imageUrl = "https://media.licdn.com/dms/image/D5603AQHcVfxRwRndiw/profile-displayphoto-shrink_400_400/0/1709209186857?e=1720051200&v=beta&t=qmc_K6Eo6W0wHlnP__MtuWq92pOYP_MiMYP2B49s7Uc"
        val imageme: ImageView =findViewById(R.id.imageme)

        Glide.with(this)
            .load(imageUrl)
            .into(imageme)
    }
}
package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId", R.drawable.img1)
        val newsContent = intent.getStringExtra("newscontent")

        val headingTV = findViewById<TextView>(R.id.newsHeading)
        val headingIV = findViewById<ImageView>(R.id.newsImage)
        val newsContentTV = findViewById<TextView>(R.id.newsContent)

        headingTV.text = heading
        headingIV.setImageResource(imageId)
        newsContentTV.text = newsContent
    }
}
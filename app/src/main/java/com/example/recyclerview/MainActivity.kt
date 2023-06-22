package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView :RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
        )

        val newsHeadingArray = arrayOf(
            "Balasore Train accident: CBI Seals House Of Railway Signal JE Amir Khan After He Goes Missing With Family",
            "Rahul Gandhi to return to India today. BJP questions long trips ‘shrouded in mystery’",
            "'Has Given Me So Much' : Nandan Nilekani Donates ₹ 315 Crore To IIT Bombay",
            "US making special 'plant-based' dinner for Modi, Grammy Award-winning violinist for entertainment",
            "India deserves much higher, wider profile: PM Modi before flying to US",
            "Mukesh Khanna wonders why Saif Ali Khan played Raavan in Adipurush: ‘Isn’t there a better actor in the industry?'",
            "IIT Mandi to host G20-S20 meet from June 21-30",
            "Russia attacks Ukrainian cities in overnight air strikes",
            "International Yoga Day 2023: 5 Yoga exercises you should try from today for optimal mental health",
            "Rain lashes several parts of Tamil Nadu, schools to remain closed. Check other details",
        )

        val newsContent = arrayOf(
            getString(R.string.new_content),getString(R.string.new_content),
            getString(R.string.new_content),getString(R.string.new_content),
            getString(R.string.new_content),getString(R.string.new_content),
            getString(R.string.new_content),getString(R.string.new_content),
            getString(R.string.new_content),getString(R.string.new_content)
            )

        // to set hav bhav of items inside recyclerview, vertically scrolling, horizomtally, unoform grid
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for(index in newsImageArray.indices){
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }

        val myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                // on clicking each item, what action do you want to perform


                val intent = Intent(this@MainActivity, NewsDetailsActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newscontent", newsArrayList[position].newsContent)

                startActivity(intent)
            }

        })

    }
}
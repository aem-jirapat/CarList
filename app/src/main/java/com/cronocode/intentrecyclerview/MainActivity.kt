package com.cronocode.intentrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = listOf<Image>(
            Image(
                R.drawable.img_1,
                "Volk Swagen",
                "Name : Volk swagen \nYear : 1969 \nSeat : 4 \nGear : Manual \nPrice : 395,000 .-"
            ),
            Image(
                R.drawable.img_2,
                "Ford Mustang",
                "Name : Ford Mustang \nYear : 2020 \nSeat : 4 \nGear : Auto \nPrice : 2,459,000 .-"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, imageList){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}

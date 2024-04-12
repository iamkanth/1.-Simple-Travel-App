package com.example.travelapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    lateinit var image: ImageView
    var places = arrayOf(
        "INDIA GATE", "QUTUB MINAR", "GURUDWARA BANGLA SAHIB",
        "AKSHARDHAM TEMPLE", "CONNOUGHT PLACE", "Dilli HAAT"
    )
//    var descriptions = arrayOf(
//        getString(R.string.about_India), getString(R.string.about_Qutub),
//        getString(R.string.about_Guru), getString(R.string.about_Temple),
//        getString(R.string.about_place), getString(R.string.about_haat)
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val previous = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tvName)
//        val placeInfo = findViewById<TextView>(R.id.textView2)


        next.setOnClickListener{
//            I want to get the next image
            var idCurrentImageString = "pic$currentImage"
//            i have to get the integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (6+currentImage+1)%6
            var idImageShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
//            placeInfo.text = descriptions[currentImage]


        }
        previous.setOnClickListener{
//            I want to get the previous image
            var idCurrentImageString = "pic$currentImage"
//            i have to get the integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (6+currentImage-1)%6
            var idImageShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]
//            placeInfo.text = descriptions[currentImage]

        }

               ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
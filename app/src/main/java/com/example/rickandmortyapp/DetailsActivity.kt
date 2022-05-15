package com.example.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.rickandmortyapp.databinding.ActivityDetailsBinding
import com.example.rickandmortyapp.model.Character

class DetailsActivity : AppCompatActivity() {

lateinit var binding: ActivityDetailsBinding
    companion object{
        const val INTENT_PARCELABLE = "object_intent"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val image = intent.getParcelableExtra<Countries>(INTENT_PARCELABLE)
        val name = intent.getParcelableExtra<Character>(INTENT_PARCELABLE)


//        val imageSrc = findViewById<ImageView>(R.id.myIm)
//        val title = findViewById<TextView>(R.id.myCy)
//        val disc = findViewById<TextView>(R.id.myCi)

        if (name != null) {
            binding.image.load(name.image)
        }
        if (name != null) {
            binding.name.text = "Name: ${name.name}"
        }
        if (name != null) {
            binding.status.text = "Status: ${name.status}"
        }
        if (name != null) {
            binding.species.text = "Species: ${name.species}"
        }
        if (name != null) {
            binding.gender.text ="Gender: ${name.gender}"
        }


//        myCy.text = country.toString()
//        myCi.text = country.toString()



    }
}
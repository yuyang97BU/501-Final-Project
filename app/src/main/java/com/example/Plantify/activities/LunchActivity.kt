package com.example.Plantify.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.Plantify.R
import com.example.Plantify.firebaseDatabase.FirebaseDb
import com.example.Plantify.model.Product
import com.example.Plantify.util.Constants.Companion.COLORS
import com.example.Plantify.util.Constants.Companion.FURNITURE_CATEGORY
import com.example.Plantify.util.Constants.Companion.IMAGES
import com.example.Plantify.util.Constants.Companion.PRODUCTS_COLLECTION
import com.example.Plantify.util.Constants.Companion.SIZES
import com.example.Plantify.viewmodel.lunchapp.KleineViewModel
import com.example.Plantify.viewmodel.lunchapp.ViewModelProviderFactory
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LunchActivity : AppCompatActivity() {
    val viewModel by lazy {
        val firebaseDb = FirebaseDb()
        val viewModelFactory = ViewModelProviderFactory(firebaseDb)
        ViewModelProvider(this,viewModelFactory)[KleineViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)



        supportActionBar?.hide()


//        val random = Random.nextInt(from = 10000, until = 99999)

//        saveNewProduct()
    }

    private fun saveNewProduct() {

        val title = "Bedside tables"
        val description = "Your bedroom is a sanctuary where you unwind and create your own personal space." +
                " You deserve to have this space ornamented to help you stay organized, relaxed, and comfortable." +
                " Bedroom furniture creates utility and helps you be your functional best"




            val category = FURNITURE_CATEGORY
        val price = "300"
        val newPrice = "229"
        val seller = "ps mart"
        val orders = 3

        val images = HashMap<String,Any>()
        val imagesList = listOf(
            "https://wakefit-co.s3.ap-south-1.amazonaws.com/img/product-thumbnails/elara-double-drawer-bedside-table-lifestyle-rectangle-new.webp",
            "https://wakefit-co.s3.ap-south-1.amazonaws.com/img/product-thumbnails/elara-double-drawer-bedside-table-lifestyle-rectangle-new.webp",
            "https://wakefit-co.s3.ap-south-1.amazonaws.com/img/product-thumbnails/elara-double-drawer-bedside-table-lifestyle-rectangle-new.webp"

        )

        images.put(IMAGES,imagesList.toList())

        val colors = HashMap<String,Any>()
        val colorsList = listOf<String>(
            "#8D4E38"
        )

        colors.put(COLORS, colorsList.toList())

        val sizes = HashMap<String,Any>()
        val sizeUnit = "Space"
        val sizesList = listOf(
            "1*2",
        )

        sizes.put(SIZES,sizesList.toList())

        val prodcut = Product(1208025,title, description, category, newPrice,price, seller, images, colors, sizes,orders,null,sizeUnit)

        Firebase.firestore.collection(PRODUCTS_COLLECTION)
            .document()
            .set(prodcut)
    }

}
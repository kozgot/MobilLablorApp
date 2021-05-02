package com.example.mobillaborapp.ui.picturedetails

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.mobillaborapp.R
import com.example.mobillaborapp.injector
import com.example.mobillaborapp.model.network.Image
import com.example.mobillaborapp.ui.picturelist.ScrollingActivity
import kotlinx.android.synthetic.main.details_content.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


class PictureDetailsActivity : AppCompatActivity(), PictureDetailsScreen {
    private var displayedImage: Image? = null
    private var imageId: String? = null

    lateinit var imageView: ImageView

    @Inject
    lateinit var pictureDetailsPresenter: PictureDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_details)
        injector.inject(this)
        imageId = intent.getStringExtra("IMAGE_ID")!!
        if (imageId != null) {
            getImage(imageId!!)
        }

        title = "Picture Details"
    }

    private fun getImage(id: String) {
        if(isNetworkConnected()) {
            pictureDetailsPresenter.getImageDetails(id)
        }
        else {
            showToast(message = "No internet connection, loading details from DB")
            lifecycleScope.launch(Dispatchers.Main) {
                val imageList: List<Image> =
                    lifecycleScope.async(Dispatchers.IO) {
                        pictureDetailsPresenter.getImageFromDb(id)
                    }.await()

                if (imageList.isNotEmpty()) {
                    showImage(imageList[0])
                }
                else {
                    showToast(message = "Image not found in DB")
                }
            }

        }
    }

    var optionsMenu: Menu? = null

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        //  store the menu to var when creating options menu
        optionsMenu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_delete -> {
                deleteImage()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        pictureDetailsPresenter.attachScreen(this)
    }

    override fun onStop() {
        pictureDetailsPresenter.detachScreen()
        super.onStop()
    }

    override fun showImage(image: Image?) {
        if (image != null) {
            displayedImage = image
            imageView = findViewById(R.id.ivImage)

            Glide.with(this).load(image.url).into(imageView)
            if (image.breeds.isNotEmpty()) {
                val breed = image.breeds[0]
                tvBreed.text = breed.name
                tvDescription.text = breed.description
                tvIndoor.text = breed.indoor.toString()
                tvIntelligence.text = breed.intelligence.toString()
                tvOrigin.text = breed.origin
                tvLifespan.text = breed.lifeSpan
            }
        }
    }

    private fun deleteImage() {
        if (!isNetworkConnected()) {
            showToast(message = "No internet, cannot delete in offline mode!")
            return
        }
        if (imageId != null) {
            pictureDetailsPresenter.deleteImage(imageId!!)
        }
        if (displayedImage != null) {
            lifecycleScope.launch(Dispatchers.Main) {
                pictureDetailsPresenter.deleteImageFromDb(displayedImage!!)
            }
        }
    }

    override fun navigateToHomePage() {
        showToast(message = "Successfully deleted image!")
        val intent = Intent(this, ScrollingActivity::class.java)
        this.startActivity(intent)
    }

    override fun showError(message: String?) {
        showToast(message = message!!)
    }

    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }

    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}
package com.example.mobillaborapp.ui.picturelist

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobillaborapp.R
import com.example.mobillaborapp.injector
import com.example.mobillaborapp.model.database.DbImage
import com.example.mobillaborapp.model.network.Breed
import com.example.mobillaborapp.model.network.Image
import com.example.mobillaborapp.model.utils.convertFromDbBreed
import com.example.mobillaborapp.model.utils.convertFromDbImage
import com.example.mobillaborapp.ui.addpicture.AddPictureActivity
import com.example.mobillaborapp.ui.utils.show
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


class ScrollingActivity : AppCompatActivity(), PicListScreen{

    lateinit var imagesAdapter: ImagesAdapter

    private val displayedImages: MutableList<Image> = mutableListOf()

    @Inject
    lateinit var listPresenter: PicListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<Toolbar>(R.id.toolbar).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, AddPictureActivity::class.java)
            this.startActivity(intent)
        }
        initRecyclerView()
        listPresenter.queryBreeds()
    }

    override fun onStart() {
        super.onStart()
        listPresenter.attachScreen(this)
    }

    override fun onStop() {
        listPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        if (!isNetworkConnected()) {
            // try to get Images from the DB
            loadImagesFromDb()
            showToast(message = "No internet connection, loading images from DB")
        }
        else {
            listPresenter.loadImagesFromAPI()
        }
    }

    private fun initRecyclerView() {
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        cat_pic_list_view.layoutManager = llm
        imagesAdapter = ImagesAdapter(this, displayedImages)
        cat_pic_list_view.adapter = imagesAdapter
    }

    override fun showImages(images: List<Image>?) {
        displayedImages.clear()
        if (images != null) {
            displayedImages.addAll(images)
            imagesAdapter?.notifyDataSetChanged()
            cat_pic_list_view.show()
        }
    }

    override fun breedsDownLoaded(breeds: List<Breed>?) {
        lifecycleScope.launch(Dispatchers.IO) {
            listPresenter.saveBreeds(breeds!!)
        }
    }

    private fun loadImagesFromDb() {
        lifecycleScope.launch(Dispatchers.Main) {
            val list: List<DbImage> =
                lifecycleScope.async(Dispatchers.IO) {
                    listPresenter.queryImagesFromDb()
                }.await()

            if (list.isNotEmpty()) {
                var imageList = mutableListOf<Image>()
                list.forEach{
                    imageList.add(convertFromDbImage(it))
                }
                showImages(imageList)
            }
            else {
                showToast(message = "The DB is empty")
            }
        }
    }

    override fun showError(message: String) {
        showToast(message = message)
    }

    private fun showToast(
        context: Context = applicationContext,
        message: String,
        duration: Int = Toast.LENGTH_LONG
    ) {
        Toast.makeText(context, message, duration).show()
    }

    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}
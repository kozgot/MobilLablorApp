package com.example.mobillaborapp.ui.picturelist

import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobillaborapp.R
import com.example.mobillaborapp.injector
import com.example.mobillaborapp.model.Breed
import com.example.mobillaborapp.model.Image
import com.example.mobillaborapp.ui.addpicture.AddPictureActivity
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsActivity
import com.example.mobillaborapp.ui.utils.hide
import com.example.mobillaborapp.ui.utils.show
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.coroutines.Dispatchers
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
        listPresenter.queryImages()
        //listPresenter.queryBreeds()
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
}
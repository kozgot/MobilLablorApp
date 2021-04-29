package com.example.mobillaborapp.ui.picturelist

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobillaborapp.R
import com.example.mobillaborapp.injector
import com.example.mobillaborapp.model.Image
import com.example.mobillaborapp.ui.utils.show
import kotlinx.android.synthetic.main.content_scrolling.*
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
        /*
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            navigateToAddImage()
        }
         */
        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
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
}
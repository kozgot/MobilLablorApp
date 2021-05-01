package com.example.mobillaborapp.ui.picturelist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobillaborapp.R
import com.example.mobillaborapp.model.network.Image
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsActivity
import kotlinx.android.synthetic.main.card_image.view.*

class ImagesAdapter constructor(
        private val context: Context,
        private var images: List<Image>
) : RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_image, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        Glide.with(context).load(image.url).into(holder.ivImage)

        // todo other properties to show
        holder.tvName.text = image.id

        holder.cardView.setOnClickListener {
            val intent = Intent(context, PictureDetailsActivity::class.java)
            intent.putExtra("IMAGE_ID", image.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = images.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.ivImage
        var tvName: TextView = view.tvName
        val cardView = view.cardView
    }
}

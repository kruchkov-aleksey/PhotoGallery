package com.example.photogallery.presentation.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.photogallery.R
import com.example.photogallery.databinding.HolderPhotoBinding
import com.example.photogallery.domain.model.Photo
import com.example.photogallery.presentation.loadImage

class PhotosAdapter(val mListener: OnPhotosAdapterListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val photos: MutableList<Photo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPhotoBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_photo, parent, false
        )
        return PhotoViewHolder(holderPhotoBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Photo{
        return photos[position]
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun addData(list: List<Photo>){
        this.photos.clear()
        this.photos.addAll(list)
        notifyDataSetChanged()
    }
    inner class PhotoViewHolder(private val dataBinding: ViewDataBinding): RecyclerView.ViewHolder(dataBinding.root){

        fun onBind(photo: Photo){
            val holderPhotoBinding = dataBinding as HolderPhotoBinding
            holderPhotoBinding.photoViewModel = PhotoViewModel(photo)
            holderPhotoBinding.photoProgressBar.visibility = View.VISIBLE
            holderPhotoBinding.photoImageView.loadImage(photo.url,  holderPhotoBinding.photoProgressBar)

            itemView.setOnClickListener {
                mListener.gotoDetailPage(holderPhotoBinding.photoImageView, photo.id)
            }
        }
    }
}
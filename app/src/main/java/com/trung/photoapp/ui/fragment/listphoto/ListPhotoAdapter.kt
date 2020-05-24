package com.trung.photoapp.ui.fragment.listphoto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.trung.photoapp.PhotoApplication.Companion.context
import com.trung.photoapp.R
import com.trung.photoapp.core.BaseAdapter
import com.trung.photoapp.data.db.entity.PhotoDetailEntity
import com.trung.photoapp.databinding.ItemPhotolistBinding

class ListPhotoAdapter : BaseAdapter<PhotoDetailEntity, ListPhotoAdapter.ViewHolder>() {

    lateinit var binding: ItemPhotolistBinding

    private var onItemClickListener: ((Int, PhotoDetailEntity) -> Unit)? = null

    fun setOnItemClickListener(onItemClickListener: ((Int, PhotoDetailEntity) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemPhotolistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(items[position], onItemClickListener)
    }

    class ViewHolder(private val binding: ItemPhotolistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            photoDetailEntity: PhotoDetailEntity,
            onItemClickListener: ((Int, PhotoDetailEntity) -> Unit)?
        ) {
            context.let {
                Glide.with(it)
                    .applyDefaultRequestOptions(RequestOptions().placeholder(R.drawable.ic_default))
                    .load(photoDetailEntity.urlPhoto).into(binding.ivPhotoUrl)
            }

            binding.tvPhotoName.text = photoDetailEntity.name

            binding.root.setOnClickListener {
                onItemClickListener?.invoke(position, photoDetailEntity)
            }
        }
    }


//    companion object {
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PhotoDetailEntity>() {
//            override fun areItemsTheSame(oldItem: PhotoDetailEntity, newItem: PhotoDetailEntity) = oldItem.id == newItem.id
//            override fun areContentsTheSame(oldItem: PhotoDetailEntity, newItem: PhotoDetailEntity) = oldItem == newItem
//        }
//    }
}
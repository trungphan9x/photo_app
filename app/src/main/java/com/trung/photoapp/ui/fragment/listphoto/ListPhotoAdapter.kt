package com.trung.photoapp.ui.fragment.listphoto

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.trung.photoapp.core.BaseAdapter
import com.trung.photoapp.data.db.entity.PhotoDetailEntity
import com.trung.photoapp.databinding.ItemPhotolistBinding
import java.util.*
import kotlin.collections.ArrayList

class ListPhotoAdapter : BaseAdapter<PhotoDetailEntity, ListPhotoAdapter.ViewHolder>(), Filterable {

    lateinit var binding: ItemPhotolistBinding

    private var onItemClickListener: ((Int, PhotoDetailEntity) -> Unit)? = null

    var photoFilterList = ArrayList<PhotoDetailEntity>()

    init {
        photoFilterList = items
    }

    override fun getItemCount(): Int {
        return photoFilterList.size
    }

    fun setOnItemClickListener(onItemClickListener: ((Int, PhotoDetailEntity) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemPhotolistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(photoFilterList[position], onItemClickListener)
    }

    class ViewHolder(private val binding: ItemPhotolistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            photoDetailEntity: PhotoDetailEntity,
            onItemClickListener: ((Int, PhotoDetailEntity) -> Unit)?
        ) {

            binding.photoUrl = photoDetailEntity.urlPhoto

            binding.tvPhotoName.text = photoDetailEntity.name

            binding.root.setOnClickListener {
                onItemClickListener?.invoke(position, photoDetailEntity)
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    photoFilterList = items
                } else {
                    val resultList = ArrayList<PhotoDetailEntity>()
                    for (row in items) {
                        if (row.name?.toLowerCase(Locale.ROOT)
                                ?.contains(charSearch.toLowerCase(Locale.ROOT))!!
                        ) {
                            resultList.add(row)
                        }
                    }
                    photoFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = photoFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                photoFilterList = results?.values as ArrayList<PhotoDetailEntity>
                notifyDataSetChanged()
            }

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PhotoDetailEntity>() {
        //Use Kotlin's referential equality operator (===), which returns true if the object references for oldItem and newItem are the same.
        //override fun areItemsTheSame(oldItem: PhotoDetailEntity, newItem: PhotoDetailEntity) = oldItem === newItem
        override fun areItemsTheSame(oldItem: PhotoDetailEntity, newItem: PhotoDetailEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PhotoDetailEntity, newItem: PhotoDetailEntity) =
            oldItem == newItem
    }
}
package com.trung.photoapp.ui.fragment.listphoto

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trung.photoapp.data.db.entity.PhotoDetailEntity
import com.trung.photoapp.databinding.ItemPhotolistBinding
import java.util.*
import kotlin.collections.ArrayList

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class ListPhotoAdapterWithDiffCallback :
    ListAdapter<PhotoDetailEntity, ListPhotoAdapterWithDiffCallback.ViewHolder>(DiffCallback),
    Filterable {
    val items: ArrayList<PhotoDetailEntity> = arrayListOf()

    lateinit var binding: ItemPhotolistBinding

    private var onItemClickListener: ((Int, PhotoDetailEntity) -> Unit)? = null

    var photoFilterList = ArrayList<PhotoDetailEntity>()

    init {
        photoFilterList = items
    }

    fun setIetms(items: List<PhotoDetailEntity>?) {
        items?.let {
            this.items.clear()
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return photoFilterList.size
    }

    fun setOnItemClickListener(onItemClickListener: ((Int, PhotoDetailEntity) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemPhotolistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(photoFilterList[position], onItemClickListener)
    }

    /**
     * The ViewHolder constructor takes the binding variable from the associated
     * ItemPhotolist, which nicely gives it access to the full [photoDetailEntity] information.
     */
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

            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
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

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [MarsProperty]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<PhotoDetailEntity>() {
        //Use Kotlin's referential equality operator (===), which returns true if the object references for oldItem and newItem are the same.
        //override fun areItemsTheSame(oldItem: PhotoDetailEntity, newItem: PhotoDetailEntity) = oldItem === newItem
        override fun areItemsTheSame(oldItem: PhotoDetailEntity, newItem: PhotoDetailEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PhotoDetailEntity, newItem: PhotoDetailEntity) =
            oldItem == newItem
    }
}
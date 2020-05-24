package com.trung.photoapp.core

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    val items: ArrayList<T> = arrayListOf()

    override fun getItemCount() = items.size

    fun setIetms(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addAll(items: List<T>) {
        val startPosition = itemCount
        this.items.addAll(items)
        notifyItemRangeInserted(startPosition, items.size)
    }

    /**
     * add an item and notify
     */
    fun add(item: T) {
        this.items.add(item)
        notifyItemInserted(items.size)
    }

    /**
     * Return size of adpater
     */
    fun size(): Int {
        return itemCount
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }


}
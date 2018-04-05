package com.lpirro.flashadapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.support.annotation.LayoutRes
import android.view.View
import com.lpirro.flashadapter.interfaces.BaseListener

abstract class FlashAdapter<T, L: BaseListener, VH: BaseViewHolder<T, L>>(context: Context, listener: L) : RecyclerView.Adapter<VH>() {

    private val items: MutableList<T> = arrayListOf()
    private var listener: L? = listener

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.onBind(item)
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<T>, notifyChanges: Boolean = true){
        this.items.clear()
        this.items.addAll(items)

        if(notifyChanges)
            notifyDataSetChanged()
    }

    fun getItems(): List<T> = this.items

    fun getItem(position: Int) = this.items[position]

    fun setListener(listener: L) {
        this.listener = listener
    }

    fun getListener(): L? = this.listener

    fun clear(){
        items.clear()
        notifyDataSetChanged()
    }

    fun isEmpty() = itemCount == 0

    private fun inflate(@LayoutRes layout: Int, parent: ViewGroup?, attachToRoot: Boolean): View {
        return layoutInflater.inflate(layout, parent, attachToRoot)
    }

    protected fun inflate(@LayoutRes layout: Int, parent: ViewGroup?): View {
        return inflate(layout, parent, false)
    }
}
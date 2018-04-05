package com.lpirro.flashadapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.lpirro.flashadapter.interfaces.BaseListener


abstract class BaseViewHolder<T, L : BaseListener> : RecyclerView.ViewHolder {

    private var listener: L? = null

    constructor(itemView: View) : super(itemView)

    constructor(itemView: View, listener: L?) : super(itemView) {
        this.listener = listener
    }

    abstract fun onBind(item: T)

}
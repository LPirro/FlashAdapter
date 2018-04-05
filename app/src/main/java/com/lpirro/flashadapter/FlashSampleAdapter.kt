package com.lpirro.flashadapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lpirro.flashadapter.interfaces.OnRecyclerItemClickListener

class FlashSampleAdapter(context: Context, listener: OnRecyclerItemClickListener) :
        FlashAdapter<User, OnRecyclerItemClickListener, UserViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(inflate(R.layout.view_user, parent), getListener())
    }
}

class UserViewHolder(itemView: View, listener: OnRecyclerItemClickListener?) : BaseViewHolder<User, OnRecyclerItemClickListener>(itemView, listener) {

    private var tvUserName: TextView? = null

    init {
        tvUserName = itemView.findViewById(R.id.tvUserName)

        listener?.let {
            itemView.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    override fun onBind(item: User) {
        tvUserName?.text = item.name
    }
}
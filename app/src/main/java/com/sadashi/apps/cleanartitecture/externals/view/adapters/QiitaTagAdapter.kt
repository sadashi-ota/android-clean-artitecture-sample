package com.sadashi.apps.cleanartitecture.externals.view.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sadashi.apps.cleanartitecture.R
import com.sadashi.apps.cleanartitecture.databinding.ItemQiitaTagBinding
import com.sadashi.apps.cleanartitecture.entities.QiitaTag

class QiitaTagAdapter : RecyclerView.Adapter<QiitaTagAdapter.BindingHolder>() {

    var tags = ArrayList<QiitaTag>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemQiitaTagBinding>(inflater, R.layout.item_qiita_tag, parent, false)
        return BindingHolder(binding)
    }

    override fun getItemCount() = tags.count()

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val tag = tags.getOrNull(position) ?: return
        holder.binding.tag = tag
    }

    class BindingHolder(var binding: ItemQiitaTagBinding) : RecyclerView.ViewHolder(binding.root)
}
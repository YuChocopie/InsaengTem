package com.mashup.insaengtem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mashup.insaengtem.data.MainItemCard

class ClipRvAdapter(val context: Context, val itemList: ArrayList<MainItemCard>) :
        RecyclerView.Adapter<ClipRvAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clipImage = itemView.findViewById<ImageView>(R.id.iv_clip)
        val clipText = itemView.findViewById<TextView>(R.id.iv_text)

        fun bind(item: MainItemCard, context: Context) {
            if (item.image != "") {
                Glide.with(context).load(item.image).into(clipImage);
            } else {
                clipImage.setImageResource(R.mipmap.ic_launcher)
            }
            clipText.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(
                R.layout.item_clip, parent, false
        )
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(itemList[position], context)
    }
}
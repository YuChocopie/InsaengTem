package com.mashup.insaengtem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClipRvAdapter(val context: Context, val clipList: ArrayList<Clip>) :
    RecyclerView.Adapter<ClipRvAdapter.Holder>(){

    inner class Holder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val clipImage = itemView.findViewById<ImageView>(R.id.iv_clip)
        val iv_text = itemView.findViewById<TextView>(R.id.iv_text)

        fun bind(clip : Clip,context: Context) {
            if (clip.image != "") {
                val resourceId = context.resources
                    .getIdentifier(clip.image, "drawable", context.packageName)

                clipImage.setImageResource(resourceId)
            } else {
                clipImage.setImageResource(R.mipmap.ic_launcher)
            }
            iv_text.text= clip.text
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_clip,parent,false
        )
        return Holder(view)
    }
    override fun getItemCount(): Int {
        return clipList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(clipList[position], context)
    }
}
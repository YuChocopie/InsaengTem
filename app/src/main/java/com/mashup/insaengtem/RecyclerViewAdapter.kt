package com.mashup.insaengtem

import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_raw.view.*


class RecyclerViewAdapter(val userList: ArrayList<User>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    //아이템의 갯수
    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_raw, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindItems(data : User){
            //이미지표시
            Glide.with(itemView.context).load(data.photo)
                .into(itemView.imageView_photo)
            itemView.textView_name.text = data.name
            itemView.textView_email.text = data.email
            //itemView.imageView_photo.setImageBitmap(data.photo)

            //각각의 아이템 클릭시
            itemView.setOnClickListener({Toast.makeText(itemView.context,
                "인생item '${data.name}'을(를) 클릭했습니다.", Toast.LENGTH_LONG).show()
            })
        }
    }

}
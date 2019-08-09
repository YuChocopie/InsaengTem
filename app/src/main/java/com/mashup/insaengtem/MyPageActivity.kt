package com.mashup.insaengtem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageButton
import kotlinx.android.synthetic.main.item_global_buttom.*

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)


        btMypage.setBackgroundResource(R.color.HotPink)

        //홈버튼 클릭시 홈으로 가기
        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //게시물 올리기 버튼
        val btRegisterItem = findViewById<ImageButton>(R.id.btRegisterItem)
        btRegisterItem.setOnClickListener {
            val intent3 = Intent(this, RegisterActivity::class.java)
            startActivity(intent3)
        }


    }

}

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

        btMypage.setImageResource(R.drawable.ic_settings_red)
        //홈버튼 클릭시 홈으로 가기
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //게시물 올리기 버튼
        btRegisterItem.setOnClickListener {
            val intent= Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}

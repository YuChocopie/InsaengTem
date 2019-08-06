package com.mashup.insaengtem

import kotlinx.android.synthetic.main.activity_main.*
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout.HORIZONTAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.annotations.NotNull as NotNull1
import android.content.Intent
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.item_global_buttom.*

class MainActivity : AppCompatActivity() {
    val userList = arrayListOf<User>(
        User("알라딘", "hong@naver.com", ""),
        User("알라딘2", "hong@naver.com", ""),
        User("알라딘3", "hong@naver.com", ""),
        User("바나나1", "eulji@naver.com", ""),
        User("바나나3", "kwang@naver.com", "")
    )

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //임시 데이터 배열
        val cities = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line)
        etMainSearch!!.setAdapter(cities)
        etMainSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                runFirstComplete()
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
        //레이아웃매니저 설정
        recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        //어답터 설정
        recyclerView.adapter = RecyclerViewAdapter(userList)


       //아이템 추가 하자
        val btRegisterItem=findViewById<ImageButton>(R.id.btRegisterItem)
        btRegisterItem.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //mypage로 간당
        val btMypage = findViewById<ImageButton>(R.id.btMypage)
        btMypage.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        //**************************************************************************************
        //(로그인 구현한거 테스트 하기 위해서 만듬. 지울예정!!) 로그인하러 가는 버튼 만들어서 로그인 화면으로 이동하기
        val gotosignsign_test = findViewById<Button>(R.id.gotosignsign_test)
        gotosignsign_test.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        //****************************************************************************************

    }

    private fun runFirstComplete() {
        var rsList = ArrayList<String>()    // var rsList = ArrayList<String>()
        if (!etMainSearch.text.isEmpty()) {
            for (i in 0..userList.size-1) {
                Log.e("123123","여기야 "+i)
                var result: Boolean = SoundSearch.matchString(userList[i].name, etMainSearch.text.toString())
                if (result)
                    rsList.add(userList[i].name)
            }
            if (!rsList.isEmpty()) {
                var rsItem = kotlin.arrayOfNulls<String>(rsList.size)
                Log.e("123123","왜 " +rsItem.size + ",,,"+rsList.size)

                for (i in 0..rsList.size-1) {
                    System.out.println(rsList.size)
                    Log.e("123123","왜 문제일까?"+i)
                    rsItem[i] = rsList.get(i)
                }
                etMainSearch.setAdapter(ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line))
                etMainSearch.showDropDown()
            } else
                etMainSearch.dismissDropDown()
        } else
            etMainSearch.dismissDropDown()
    }
}

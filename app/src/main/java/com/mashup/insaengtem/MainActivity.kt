package com.mashup.insaengtem

import kotlinx.android.synthetic.main.activity_main.*
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout.HORIZONTAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.annotations.NotNull as NotNull1


class MainActivity : AppCompatActivity() {
    val userList = arrayListOf<User>(
        User("알라딘", "hong@naver.com", "https://www/photo/2016/04/10/21/34/woman-1320810_1280.jpg"),
        User("알라딘2", "hong@naver.com", "https://www/photo/2016/04/10/21/34/woman-1320810_1280.jpg"),
        User("알라딘3", "hong@naver.com", "https://www/photo/2016/04/10/21/34/woman-1320810_1280.jpg"),
        User("피난안내도", "lee@naver.com", "https://www/photo/2017/11/11/21/55/girl-2940655_1280.jpg"),
        User("피난안내도2", "lee@naver.com", "https://www/photo/2017/11/11/21/55/girl-2940655_1280.jpg"),
        User("피난안내도3", "lee@naver.com", "https://www/photo/2017/11/11/21/55/girl-2940655_1280.jpg"),
        User("피난안내도4", "kang@naver.com", "https://www/photo/2018/02/05/03/21/fantasy-3131323_1280.jpg"),
        User("바나나1", "eulji@naver.com", "https://www/photo/2018/01/01/23/38/ballerina-3055155_1280.jpg"),
        User("바나나3", "kwang@naver.com", "https://www/photo/2018/01/13/19/39/fashion-3080644__340.jpg"),
        User("바나나2", "im@naver.com", "https://www/photo/2017/11/11/21/55/girl-2940655_1280.jpg")
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

package com.mashup.insaengtem

import android.app.Activity
import android.widget.Toast


class MainBackPressCloseHandler(context: Activity){
    private var backKeyPressedTime:Long = 0

    private var toast : Toast? = null

    private val activity : Activity

    init{
        this.activity = context
    }

    fun onBackPressed(){
        if(System.currentTimeMillis() > backKeyPressedTime + 2000)
        {
            backKeyPressedTime = System.currentTimeMillis()
            showGuide()
            return
        }

        if(System.currentTimeMillis() <= backKeyPressedTime+2000)
        {
            activity.finish()
            android.os.Process.killProcess(android.os.Process.myPid())
            toast?.cancel()
        }
    }

    fun showGuide(){
        Toast.makeText(activity, "뒤로 버튼을 한번 눌렀습니다",Toast.LENGTH_SHORT).show()
    }


}
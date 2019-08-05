package com.mashup.insaengtem


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

/*여기서 첫  로그인 화면에서
회원가입하기 버튼을 누르면
SignUpActivity로 가게 합니다.*/

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)
        val btGoToSignUp = findViewById<TextView>(R.id.btGoToSignUp)

        btGoToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

           }
        }
    }

package com.mashup.insaengtem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.sign_up.*
import kotlinx.android.synthetic.main.sign_up.view.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        //회원가입하기 버튼을 눌렀을 때!
        val btSignUp = findViewById<Button>(R.id.btSignUp)
        btSignUp.setOnClickListener{

            //사용자가 입력한 비밀번호와 비밀번호 확인에 적힌 내용이 같은지 확인한다.
            val pw = findViewById<EditText>(R.id.etSignUpPw)
            val pwChk = findViewById<EditText>(R.id.etSignUpPwchk)

            if(pw.getText().toString().equals(pwChk.getText().toString()))  //비밀번호 일치하는지 확인
            {
                //DB안에 회원가입 정보 넘겨주기!
            }
            else
            {
                Toast.makeText(this@SignUpActivity, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //회원가입 안하고 다시 로그인화면으로 돌아간다.
        val btGoBackToSignIn = findViewById<TextView>(R.id.btGoBackToSignIn)
        btGoBackToSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}

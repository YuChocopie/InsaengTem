package com.mashup.insaengtem

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mashup.insaengtem.data.InsaengtemInterface
import com.mashup.insaengtem.data.User
import com.mashup.insaengtem.retrofit.InsaengtemAIP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sign_up.*
import kotlinx.android.synthetic.main.sign_up.view.*

class SignUpActivity : AppCompatActivity() {

    private var thisAIP = InsaengtemAIP()
    private var thisRetrofit = thisAIP.temRetrofit()
    private var thisInterface = thisRetrofit.create(InsaengtemInterface::class.java)
    var user = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        //회원가입하기 버튼을 눌렀을 때!
        val btSignUp = findViewById<Button>(R.id.btSignUp)
        btSignUp.setOnClickListener{

            //사용자가 입력한 비밀번호와 비밀번호 확인에 적힌 내용이 같은지 확인한다.
            if(etSignUpPw.text.toString() == etSignUpPwchk.text.toString())  //비밀번호 일치하는지 확인
            {
                user[0].username
                user[0].password1
                user[0].password2
                //DB안에 회원가입 정보 넘겨주기!
                signUp()
            }
            else
            {
                Toast.makeText(this@SignUpActivity, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            }

        }
        //회원가입 안하고 다시 로그인화면으로 돌아간다.
        btGoBackToSignIn.setOnClickListener {
            finish()
        }

    }

    @SuppressLint("CheckResult")
    private fun signUp() {
        thisInterface.signUp(user[0])
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                Log.e("123123123", "성공".toString())
                finish()
            }, { error ->
                error.printStackTrace()
                Log.e("123123123", "통신실패".toString())
                Toast.makeText(this, "통신실패", Toast.LENGTH_SHORT).show()
            }, {
                // 작업이 정상적으로 완료되지 않았을 때 호출됩니다.
                Log.d("Result", "complete")

            })    }
}

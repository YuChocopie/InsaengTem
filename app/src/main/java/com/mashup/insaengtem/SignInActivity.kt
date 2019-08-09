package com.mashup.insaengtem


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.mashup.insaengtem.data.InsaengtemInterface
import com.mashup.insaengtem.data.UserLogin
import com.mashup.insaengtem.retrofit.InsaengtemAIP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.sign_in.*

/*여기서 첫  로그인 화면에서
회원가입하기 버튼을 누르면
SignUpActivity로 가게 합니다.*/
class SignInActivity : AppCompatActivity() {

    private var thisAIP = InsaengtemAIP()
    private var thisRetrofit = thisAIP.temRetrofit()
    private var thisInterface = thisRetrofit.create(InsaengtemInterface::class.java)
    var user = arrayListOf<UserLogin>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)

        buttonLogin.setOnClickListener {
            user[0].username = textviewID.text.toString()
            user[0].password = textviewPassword.text.toString()
            signIn()
        }


        btGoToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("CheckResult")
    private fun signIn() {
        thisInterface.signIn(user[0])
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    Log.e("123123123", "성공".toString())
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }, { error ->
                    error.printStackTrace()
                    Log.e("123123123", "통신실패".toString())
                    Toast.makeText(this, "통신실패", Toast.LENGTH_SHORT).show()
                }, {
                    // 작업이 정상적으로 완료되지 않았을 때 호출됩니다.
                    Log.d("Result", "complete")

                })
    }

}


//
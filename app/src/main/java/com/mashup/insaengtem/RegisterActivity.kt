package com.mashup.insaengtem

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.item_global_buttom.*
import kotlinx.android.synthetic.main.item_register.*

/*아이템을 등록하는 것에 대해서 쓰기!!!*/
// Method to resize a bitmap programmatically

private fun resizeBitmap(bitmap: Bitmap, width:Int, height:Int):Bitmap{
    /*
        *** reference source developer.android.com ***
        Bitmap createScaledBitmap (Bitmap src, int dstWidth, int dstHeight, boolean filter)
            Creates a new bitmap, scaled from an existing bitmap, when possible. If the specified
            width and height are the same as the current width and height of the source bitmap,
            the source bitmap is returned and no new bitmap is created.

        Parameters
            src Bitmap : The source bitmap.
                This value must never be null.

        dstWidth int : The new bitmap's desired width.
        dstHeight int : The new bitmap's desired height.
        filter boolean : true if the source should be filtered.

        Returns
            Bitmap : The new scaled bitmap or the source bitmap if no scaling is required.

        Throws
            IllegalArgumentException : if width is <= 0, or height is <= 0
    */
    return Bitmap.createScaledBitmap(
        bitmap,
        width,
        height,
        false
    )
}

class RegisterActivity : AppCompatActivity(), LifecycleOwner {
    private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)

    private val PICK_IMAGE_REQUEST = 1
    private val PICK_CONTACT_REQUEST = 2  // The request code
    private fun pickContact() {
        Intent(Intent.ACTION_PICK, Uri.parse("content://contacts")).also { pickContactIntent ->
            pickContactIntent.type =
                ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE // Show user only contacts w/ phone numbers
            startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e("여기야", "여기된다고~~~~~~~~~~~~~~~~~~~~~~~~")
        // Check which request we're responding to
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            // Make sure the request was successful
            Log.e("여기야", "여기야33333333333333333")

                ///Uri에서 이미지 이름을 얻어온다.
                val uri = data?.data

                Log.e("여기야", "여기야4444444444444")
                //이미지 데이터를 비트맵으로 받아옴.
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)

                val itemPic = itemPic.findViewById<ImageView>(R.id.itemPic)

                Log.e("여기야", "여기야555555555555")
                // val nh = resizeBitmap(bitmap, 200, 200).toString().toInt()//createScaledBitmap(세번째 인자)가 nh인데 Int값으로 안넣어져서 일단 600으로 넣음.

                Log.e("여기야", "여기야666666666666666")
                itemPic.setImageURI(uri)

               //배치해놓은 imageView에 set
                itemPic.setImageBitmap(bitmap)

        }
    }

    @SuppressLint("WrongViewCast", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_register)


        val btRegisterItem = findViewById<ImageButton>(R.id.btRegisterItem)

        btRegisterItem.setBackgroundResource(R.color.HotPink)

        //마이페이지 클릭시 마이페이지 가기
        val btMyPage1= findViewById<ImageButton>(R.id.btMypage)
        btMyPage1.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        //홈버튼 클릭시 홈으로 가기
        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btItemDelete = findViewById<ImageView>(R.id.btItemDelete)
        btItemDelete.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //로드버튼 클릭시 실행
        val btLoadPic = findViewById<Button>(R.id.btLoadPic)
        Log.e("여기야", "버튼 실행")

        btLoadPic.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)  //ACTION_PIC과 차이점
            intent.type = "image/*"   //이미지만 보이게
            startActivity(intent)
            //Intent 시작 - 갤러리앱을 열어서 원하는 이미지를 선택할 수 있다.
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)

        }
    }
}
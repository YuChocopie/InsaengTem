package com.mashup.insaengtem

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.util.Rational
import android.util.Size
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraX
import androidx.camera.core.Preview
import androidx.camera.core.PreviewConfig
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.item_register.*

/*아이템을 등록하는 것에 대해서 쓰기!!!*/
// Method to resize a bitmap programmatically

private fun resizeBitmap(bitmap:Bitmap, width:Int, height:Int):Bitmap{
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
    private val REQUEST_CODE_PERMISSIONS = 10
    private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)

    public val PICK_IMAGE_REQUEST = 1
    public val PICK_CONTACT_REQUEST = 1  // The request code
    private fun pickContact() {
        Intent(Intent.ACTION_PICK, Uri.parse("content://contacts")).also { pickContactIntent ->
            pickContactIntent.type =
                ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE // Show user only contacts w/ phone numbers
            startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_register)

        //로드버튼 클릭시 실행
        val btLoadPic = findViewById<Button>(R.id.btLoadPic)
        btLoadPic.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)  //ACTION_PIC과 차이점
            intent.type = "image/*"   //이미지만 보이게
            startActivity(intent)
            //Intent 시작 - 갤러리앱을 열어서 원하는 이미지를 선택할 수 있다.
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
        }
    }

    //이미지 선택작업 후의 결과 처리
    internal fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful

            ///Uri에서 이미지 이름을 얻어온다.
            val uri = data?.data

            Log.e("1111","여기야 1")
            //이미지 데이터를 비트맵으로 받아옴.
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
            Log.e("1111","여기야 2")
            val itemPic = itemPic.findViewById<ImageView>(R.id.itemPic)
            Log.e("1111","여기야 3")
            val nh = resizeBitmap(bitmap, 200, 200)    //createScaledBitmap(세번째 인자)가 nh인데 Int값으로 안넣어져서 일단 600으로 넣음.
            Log.e("1111","여기야 4")
            val scaled = Bitmap.createScaledBitmap(bitmap, 200, 200, true)
            Log.e("1111","여기야 5")
            itemPic.setImageURI(uri)
            Log.e("1111","여기야 6")
            //배치해놓은 imageView에 set
            itemPic.setImageBitmap(scaled)
            Log.e("여기야","여기야 7")

            intent.putExtra("full", "${data}")
            startActivityForResult(intent, PICK_CONTACT_REQUEST)

            if (resultCode == Activity.RESULT_OK) {
                val itemView = itemPic.findViewById<ImageView>(R.id.itemPic)


                itemPic.setImageURI(uri)

                // itemPic.setImageBitmap(scaled)

                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }
}

//        viewFinder = findViewById(R.id.view_finder)  <-- 오류나서 일단 지웠음.

//        // Request camera permissions
//        if (allPermissionsGranted()) {
//            viewFinder.post { startCamera() }

//        } else {
//            ActivityCompat.requestPermissions(
//                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
//            )
//        }
//
//        // Every time the provided texture view changes, recompute layout
//        viewFinder.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
//            updateTransform()
//        }
//    }

// Add this after onCreate

//    private lateinit var viewFinder: TextureView


    /**
     * Process result from permission request dialog box, has the request
     * been granted? If yes, start Camera. Otherwise display a toast
     */
//    override fun onRequestPermissionsResult(
////        requestCode: Int, permissions: Array<String>, grantResults: IntArray
////    ) {
////        if (requestCode == REQUEST_CODE_PERMISSIONS) {
////            if (allPermissionsGranted()) {
////                viewFinder.post { startCamera() }
////            } else {
////                Toast.makeText(
////                    this,
////                    "Permissions not granted by the user.",
////                    Toast.LENGTH_SHORT
////                ).show()
////                finish()
////            }
////        }
////    }

//    /**
//     * Check if all permission specified in the manifest have been granted
//     */
//    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
//        ContextCompat.checkSelfPermission(
//            baseContext, it
//        ) == PackageManager.PERMISSION_GRANTED
//    }
//
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    private fun startCamera() {
//
//        // Create configuration object for the viewfinder use case
//        val previewConfig = PreviewConfig.Builder().apply {
//            setTargetAspectRatio(Rational(1, 1))
//            setTargetResolution(Size(640, 640))
//        }.build()
//
//        // Build the viewfinder use case
//        val preview = Preview(previewConfig)
//
//        // Every time the viewfinder is updated, recompute layout
//        preview.setOnPreviewOutputUpdateListener {
//
//            // To update the SurfaceTexture, we have to remove it and re-add it
//            val parent = viewFinder.parent as ViewGroup
//            parent.removeView(viewFinder)
//            parent.addView(viewFinder, 0)
//
//            viewFinder.surfaceTexture = it.surfaceTexture
//            updateTransform()
//        }
//        // Bind use cases to lifecycle
//        // If Android Studio complains about "this" being not a LifecycleOwner
//        // try rebuilding the project or updating the appcompat dependency to
//        // version 1.1.0 or higher.
//        CameraX.bindToLifecycle(this, preview)
//    }
//
//    private fun updateTransform() {
//        val matrix = Matrix()
//
//        // Compute the center of the view finder
//        val centerX = viewFinder.width / 2f
//        val centerY = viewFinder.height / 2f
//
//        // Correct preview output to account for display rotation
//        val rotationDegrees = when (viewFinder.display.rotation) {
//            Surface.ROTATION_0 -> 0
//            Surface.ROTATION_90 -> 90
//            Surface.ROTATION_180 -> 180
//            Surface.ROTATION_270 -> 270
//            else -> return
//        }
//        matrix.postRotate(-rotationDegrees.toFloat(), centerX, centerY)
//
//        // Finally, apply transformations to our TextureView
//        viewFinder.setTransform(matrix)
//    }
//
//}
//



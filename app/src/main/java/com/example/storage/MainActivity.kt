package com.example.storage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import android.content.ContentResolver
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private val REQUEST_GALLERY_TAKE = 2
    private val RECORD_REQUEST_CODE = 42
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)
        val imageView : ImageView = findViewById(R.id.imageView)

        button.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_GALLERY_TAKE)
        }

//        val image : ImageView = findViewById(R.id.image)
//        val storageRef = FirebaseStorage.getInstance().reference
//        val imageRef = storageRef.child("neet.png")
//        Glide.with(this).load(imageRef).into(image)


//        val test : TextView = findViewById(R.id.test)
//        val image : ImageView = findViewById(R.id.image)
//        Log.d("Test","1")
//        val storage = FirebaseStorage.getInstance()
//        val storageRef = storage.reference
//        val gsReference = storage.getReferenceFromUrl("gs://test02-4d86d.appspot.com/neet.png")
//
//        val dir = storageRef.child("neet.png")
//        Log.d("Test","2")
//        val byteLength=1024*1024L
//        dir.getBytes(byteLength).addOnSuccessListener{
//                bytes ->
//            Log.d("Test","3")
//            val data = String(bytes, Charsets.UTF_8)
//            val array=data.split("/n")
//            var res=""
//            val i=1;
//            Log.d("Test","4")
//            for(item in array){
//                res=i.toString().plus(item).plus("\n")
//            }
//            image.setImage
//            test.text=res
//        }.addOnFailureListener {  }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_GALLERY_TAKE && resultCode == Activity.RESULT_OK) {
            if (data != null){
                val uri = data.data
                imageView.setImageURI(uri)

                val fileName= UUID.randomUUID().toString() + ".jpg"
                val refStorage= FirebaseStorage.getInstance().reference.child("/images/$fileName")
                refStorage.putFile(uri!!)
                    .addOnSuccessListener {
                        Log.d("nakayama", "image uploaded")
                    }
                    .addOnFailureListener {
                        Log.d("RegisterActivity", "${it.message}")
                    }
            }
        }
    }
}
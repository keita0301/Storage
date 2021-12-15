package com.example.storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image : ImageView = findViewById(R.id.image)
        val storageRef = FirebaseStorage.getInstance().reference
        val imageRef = storageRef.child("neet.png")
            Glide.with(this)
            .load(imageRef)
            .into(image)


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
}
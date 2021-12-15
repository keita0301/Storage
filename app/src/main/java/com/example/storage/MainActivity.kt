package com.example.storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.storage.FirebaseStorage
import org.w3c.dom.Text

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test : TextView = findViewById(R.id.test)
        Log.d("Test","1")
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
        val gsReference = storage.getReferenceFromUrl("gs://test02-4d86d.appspot.com/neet.png")

//        val dir = storageRef.child("neet.png")
        Log.d("Test","2")
        val byteLength=1024*1024L
        gsReference.getBytes(byteLength).addOnSuccessListener{
                bytes ->
            Log.d("Test","3")
            val data = String(bytes, Charsets.UTF_8)
            val array=data.split("/n")
            var res=""
            val i=1;
            Log.d("Test","4")
            for(item in array){
                res=i.toString().plus(item).plus("\n")
            }
            test.text=res
        }.addOnFailureListener {  }
    }
}
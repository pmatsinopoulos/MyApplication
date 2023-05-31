package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MYTAG", "SecondActivity: onCreate")
        setContentView(R.layout.activity_second)
        val userName = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvOffer)
        val message = "$userName, ${getString(R.string.offer_1)}"
        textView.text = message
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "SecondActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "SecondActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "SecondActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", "SecondActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG", "SecondActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", "SecondActivity: onDestroy")
    }
}
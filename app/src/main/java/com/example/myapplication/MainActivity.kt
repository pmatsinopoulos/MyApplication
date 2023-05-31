package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MYTAG", "MainActivity: onCreate")
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        var submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""
        submitButton.setOnClickListener {
            enteredName = inputField.text.toString()
            if (enteredName == "") {
                offersButton.visibility = INVISIBLE
                val toast = Toast.makeText(
                    this@MainActivity,
                    R.string.toast_to_enter_name,
                    Toast.LENGTH_LONG
                )
                toast.show()
                greetingTextView.text = ""
            } else {
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = VISIBLE
            }
        }
        offersButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "MainActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "MainActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", "MainActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG", "MainActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", "MainActivity: onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

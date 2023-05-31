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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MYTAG", "MainActivity:OnCreate")
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
                Log.i("MYTAG", message)
                greetingTextView.text = message
                Log.i("MYTAG", "After displaying the message on the TextView")
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
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

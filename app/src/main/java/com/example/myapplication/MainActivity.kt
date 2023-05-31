package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
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
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        var submitButton = findViewById<Button>(R.id.btnSubmit)
        submitButton.setOnClickListener {
            val enteredName = inputField.text.toString()
            val message = "Welcome $enteredName"
            if (enteredName == "") {
                val toast = Toast.makeText(
                    this@MainActivity,
                    R.string.toast_to_enter_name,
                    Toast.LENGTH_LONG
                )
                toast.show()
                greetingTextView.text = ""
            }
            else {
                greetingTextView.text = message
                inputField.text.clear()
            }
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

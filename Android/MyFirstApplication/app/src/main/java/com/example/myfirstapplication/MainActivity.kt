package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        //val textView:TextView = findViewById(R.id.skillboxTextView)
        //textView.text = "Hello, Skillbox!"

        //val anotherTextView = findViewById<TextView>(R.id.anotherTextView)
        //anotherTextView.text = "I am setted too!"

        //binding.skillboxTextView.text = getText(R.string.testText)
        binding.skillboxTextView.text = binding.skillboxTextView.context.getText(R.string.testText)
        binding.anotherTextView.text = counter.toString()
        binding.plusOneButton.setOnClickListener {
            binding.anotherTextView.text = counter.toString()
            if (counter == 5) {
                counter = 0
                binding.button.visibility = View.VISIBLE
            } else counter++
        }
        binding.skillboxTextView.isAllCaps = false
        binding.button.setOnClickListener {
            binding.plusOneButton.isEnabled = false
            binding.anotherTextView.text = "Button is Clicked!"
        }
    }
}
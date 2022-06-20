package com.example.passengercounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.passengercounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter = 0
    val limitPassage = 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.minusButton.isEnabled = false
        binding.counterText.text = counter.toString()
        binding.informationText.text = getText(R.string.information)

        binding.plusButton.setOnClickListener {
            if (counter < limitPassage) {
                counter++
                binding.informationText.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.purple_700
                    )
                )
                binding.counterText.text = counter.toString()
                binding.minusButton.isEnabled = true
                binding.informationText.text = "Осталось мест: ${limitPassage - counter}"
            } else {
                binding.informationText.setTextColor(ContextCompat.getColor(this, R.color.red))
                binding.informationText.text = getText(R.string.max_limit)
                binding.passButton.visibility = View.VISIBLE
            }
        }

        binding.minusButton.setOnClickListener {
            if (counter > 0) {
                counter--
                binding.informationText.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.purple_700
                    )
                )
                binding.counterText.text = counter.toString()
                binding.informationText.text = "Осталось мест: ${-(counter - limitPassage)}"
                binding.passButton.visibility = View.INVISIBLE
            } else {
                binding.informationText.setTextColor(ContextCompat.getColor(this, R.color.green))
                binding.informationText.text = getText(R.string.information)
                binding.minusButton.isEnabled = false
            }
        }

        binding.passButton.setOnClickListener {
            binding.informationText.setTextColor(ContextCompat.getColor(this, R.color.green))
            binding.informationText.text = getText(R.string.information)
            binding.minusButton.isEnabled = false
            binding.passButton.visibility = View.INVISIBLE
            counter = 0
            binding.counterText.text = counter.toString()
        }
    }
}

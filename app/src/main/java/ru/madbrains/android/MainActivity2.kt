package ru.madbrains.android

import android.app.Activity
import android.app.Instrumentation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstButton.setOnClickListener() {
            intent.putExtra("imgId", 1)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.secondButton.setOnClickListener() {
            intent.putExtra("imgId", 2)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.thirdButton.setOnClickListener() {
            intent.putExtra("imgId", 3)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
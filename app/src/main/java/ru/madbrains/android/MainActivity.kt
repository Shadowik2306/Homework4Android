package ru.madbrains.android

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textId.text = "Hello World"
        binding.imageView.setImageResource(R.drawable.one)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->
                val data: Intent? = result.data
                setImage(data?.getIntExtra("imgId", 1), binding.imageView)
        }
        val intent = Intent(this, MainActivity2::class.java)
        binding.button.setOnClickListener() {
            resultLauncher.launch(intent)
        }
    }

    fun setImage(id: Int?, imageView: ImageView) {
        Log.d("test", id.toString())
        when (id) {
            1 -> imageView.setImageResource(R.drawable.one)
            2 -> imageView.setImageResource(R.drawable.two)
            3 -> imageView.setImageResource(R.drawable.three)
            else -> Log.d("test", "Error")
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
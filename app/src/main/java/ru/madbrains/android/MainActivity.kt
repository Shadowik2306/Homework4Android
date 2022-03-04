package ru.madbrains.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var id_image: Int = 1
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textId.text = "Hello World"

        imageView = binding.imageView

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->
                val data = result.data?.getIntExtra("imgId", 1) ?: 1
                setImage(data, binding.imageView)
        }
        val intent = Intent(this, MainActivity2::class.java)
        binding.button.setOnClickListener() {
            resultLauncher.launch(intent)
        }
    }

    fun setImage(id: Int, imageView: ImageView) {
        id_image = id
        Log.d("test", id.toString())
        when (id) {
            1 -> imageView.setImageResource(R.drawable.one)
            2 -> imageView.setImageResource(R.drawable.two)
            3 -> imageView.setImageResource(R.drawable.three)
            else -> Log.d("test", "Error")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("test", "IIIIIIIIIIIIIIIIIII")
        outState.putInt("ImageId", id_image)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setImage(savedInstanceState.getInt("ImageId"), imageView)
    }
}
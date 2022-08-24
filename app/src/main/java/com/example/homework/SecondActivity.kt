package com.example.homework

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    private fun initViews(){
        binding.textView2.text = intent.getParcelableExtra<User>("me").toString().trim()

        binding.btnFirst2.setOnClickListener {
            binding.textView2.text = intent.getStringExtra("string").toString().trim()
        }

        binding.btnSecond2.setOnClickListener {
            binding.textView2.text = intent.getParcelableExtra<User>("user").toString().trim()
        }

        binding.btnThird2.setOnClickListener {
            val friend = User("Nurillo", "Bozorboyev", "15")
            intent.putExtra("friend", friend)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
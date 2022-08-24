package com.example.homework

import android.accounts.AccountAuthenticatorResponse
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        first()
        second()
        third()
        fourth()
        fifth()
    }

    private fun first(){
        binding.btnFirst.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("string", "First function is working")
            startActivity(intent)
        }
    }

    private fun second(){
        binding.btnSecond.setOnClickListener {
            val user1 = User("Abdulloh", "Azimjonov", "15")
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user", user1)
            startActivity(intent)
        }
    }
    private val response = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
            binding.textView1.text = it.data?.getParcelableExtra<User>("friend").toString().trim()
        }
    }
    private fun third(){
        binding.btnThird.setOnClickListener {
            val user1 = User("Abdulloh", "Azimjonov", "15")
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("me", user1)

            response.launch(intent)
        }
    }

    private fun fourth(){
        binding.btnFourth.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://google.com")
            startActivity(intent)
        }
    }

    private fun fifth(){
        binding.btnFifth.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val data = "https://play.market.com"
            intent.putExtra(Intent.EXTRA_TEXT, data)
            startActivity(Intent.createChooser(intent, "Share"))
        }
    }
}
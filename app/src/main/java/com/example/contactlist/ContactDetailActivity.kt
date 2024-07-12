package com.example.contactlist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvImage: ImageView = findViewById(R.id.image)
        val tvNome: TextView = findViewById(R.id.tvName)
        val tvPhoneNumber: TextView = findViewById(R.id.tvPhoneNumber)
        val tvShare: TextView = findViewById(R.id.tvShare)

        val icon = intent.getIntExtra("icon", R.drawable.sample8)
        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phoneNumber")

        tvImage.setImageResource(icon)
        tvNome.text = name
        tvPhoneNumber.text = phoneNumber

        tvShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name $phoneNumber")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}
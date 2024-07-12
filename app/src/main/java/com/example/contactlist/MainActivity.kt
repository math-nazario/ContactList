package com.example.contactlist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList: RecyclerView = findViewById(R.id.rvList)
        val ivList: ImageView = findViewById(R.id.ivList)
        val ivGrid: ImageView = findViewById(R.id.ivGrid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("icon", contact.icon)
            intent.putExtra("name", contact.name)
            intent.putExtra("phoneNumber", contact.phoneNumber)
            startActivity(intent)
        }
    }
}

val contacts = listOf(
    Contact(
        "Alison", "(55) 61 92177-5169", R.drawable.sample1
    ),
    Contact(
        "Bruno", "(55) 24 93745-9737", R.drawable.sample2
    ),
    Contact(
        "Francisco", "(55) 19 93673-2876", R.drawable.sample3
    ),
    Contact(
        "Gabriel", "(55) 48 93832-8235", R.drawable.sample4
    ),
    Contact(
        "Helena", "(55) 61 92311-2462", R.drawable.sample5
    ),
    Contact(
        "Joaquim", "(55) 12 93351-1621", R.drawable.sample6
    ),
    Contact(
        "Juliana", "(55) 32 92257-3621", R.drawable.sample7
    ),
    Contact(
        "Mariana", "(55) 92 92867-5578", R.drawable.sample8
    ),
    Contact(
        "Mateus", "(55) 17 92436-6394", R.drawable.sample9
    ),
    Contact(
        "Natalia", "(55) 18 92386-9718", R.drawable.sample10
    ),
    Contact(
        "Victória", "(55) 24 92593-2480", R.drawable.sample11
    )
)
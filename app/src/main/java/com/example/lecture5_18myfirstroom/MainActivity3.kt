package com.example.lecture5_18myfirstroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val repo: StudentRepository by lazy {
            StudentRepository(this)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var id: TextView = findViewById(R.id.id_t)
        var fname: EditText = findViewById(R.id.fname_t)
        var lname: EditText = findViewById(R.id.lname_t)
        var update: Button = findViewById(R.id.update)

        id.setText(intent.getIntExtra("Id", 0))
        fname.setText(intent.getStringExtra("Fname"))
        lname.setText(intent.getStringExtra("Lname"))

        update.setOnClickListener {
            repo.updateStudent(Students(id.toString().toInt(), lname.text.toString(), fname.text.toString()))
            val myintent = Intent(this, MainActivity::class.java)
            startActivity(myintent)
        }
    }
}
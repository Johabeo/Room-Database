package com.example.lecture5_18myfirstroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    val repo: StudentRepository by lazy {
        StudentRepository(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var fname: EditText = findViewById(R.id.fname)
        var lname: EditText = findViewById(R.id.lname)
        var save: Button = findViewById(R.id.save)


        save.setOnClickListener {
            repo.insertStudent(Students(null, fname.text.toString(), lname.text.toString()))
            val myintent = Intent(this, MainActivity::class.java)
            startActivity(myintent)
        }
    }


}
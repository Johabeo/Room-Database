package com.example.lecture5_18myfirstroom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var studentList: List<Students>

    val repo: StudentRepository by lazy {
        StudentRepository(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //     var fname: EditText = findViewById(R.id.finput)
        //var studentcard: CardView = findViewById(R.id.studentcard)
        //I am adding 10 Students to Room DB
        // for (i in 0..10){
//            var stu = Students(null, fname.text.toString(), lname.text.toString())
//            repo.insertStudent(stu)
        //repo.updateStudent(stu)
        //}

        //repo.deleteAllWithName("%Bob%")
        studentList = repo.getAllStudents()

        //init the data source


        //Got reference to the view to populate
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        //assigned the layout manager of the view
        recyclerView.layoutManager = LinearLayoutManager(this)

        //create an adapter with data source
        var adapter = StudentAdapter({ position -> onCardClick(position) }, studentList)

        //Take the views adapter and then assign it to the custom adapter we created

        recyclerView.adapter = adapter
        //assign the adapter

//        studentcard.setOnClickListener {
//            println("inside card click")
//        }
        var floating: FloatingActionButton = findViewById(R.id.floating)
        floating.setOnClickListener {
            val myIntent = Intent(this, MainActivity2::class.java)
            startActivity(myIntent)
        }

        //1. This will not work
        var studentcard: CardView = findViewById(R.id.studentcard)
        studentcard.setOnClickListener {

        }


    }

    //Why you need this
    fun onCardClick(position: Int) {
        println("position:::$position")
        val myIntent = Intent(this, MainActivity3::class.java)
        myIntent.putExtra("Id", studentList[position].studentsId)
        myIntent.putExtra("Fname", studentList[position].firstName)
        myIntent.putExtra("Lname", studentList[position].lastName)
        startActivity(myIntent)
    }
}
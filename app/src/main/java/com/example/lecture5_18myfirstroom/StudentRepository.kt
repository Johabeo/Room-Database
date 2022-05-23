package com.example.lecture5_18myfirstroom

import android.content.Context
//this repository helps us interact with the data from the local and remote data sources
//we mostly use CRUD but we can do tons of things with the data tables
class StudentRepository(context: Context) {
    //we start by acquiring an instance of the database
    var db: StudentsDao? = AppDatabase.getInstance(context)?.studentDao()

    fun getAllStudents(): List<Students> {
        return db?.selectStudent() ?: listOf<Students>() //returns an empty list if null
    }

    fun insertStudent(students: Students) {
        db?.insertStudent(students)
    }

    fun updateStudent(students: Students) {
        db?.updateStudent(students)
    }

    fun deleteStudent(students: Students) {
        db?.deleteStudent(students)
    }

    fun deleteAllWithName(fname: String){
        db?.deleteAll(fname)
    }

    // Insert things in an Async way
    //Async Task
    //Do in Background
}
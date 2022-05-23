package com.example.lecture5_18myfirstroom

import androidx.room.*

//DAO's are either interfaces or abstract classes
//Data Access Objects, provide a set of methods, an API, to access the database
@Dao
interface StudentsDao {

    //CRUD

    //create
    @Insert //function comes with annotation
    fun insertStudent(student : Students)
    //read
    @Query("select * from students")
    fun selectStudent(): List<Students>
    //update
    @Update
    fun updateStudent(student: Students)
    //delete
    @Delete
    fun deleteStudent(student: Students)

    @Query("delete from students where firstname like :fname")
    fun deleteAll(fname: String)

}
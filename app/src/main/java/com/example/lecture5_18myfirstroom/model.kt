package com.example.lecture5_18myfirstroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entities are all data classes
@Entity(tableName = "students") //named after the database because it has a different one than the class
//added the same fields from the database, class starts with capital letter for best practice
data class Students(@PrimaryKey(autoGenerate = true)var studentsId: Int?, //annotations provide metadata
                    @ColumnInfo(name = "firstname")var firstName: String?,
                    @ColumnInfo(name = "lastname")var lastName: String?)


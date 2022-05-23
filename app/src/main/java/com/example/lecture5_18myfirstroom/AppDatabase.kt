package com.example.lecture5_18myfirstroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//all of these pieces, Main Activity, XML, JSON, ViewModel and Database are all necessary to make a
//real world app

//all room DBs come with @Entity, @Dao, and @Database, 3 files
//1 - annotation       //2 - entities
@Database(entities = [Students::class], version = 1, exportSchema = false)
//Database classes are always abstract
//3 - abstract and extend
abstract class AppDatabase : RoomDatabase(){ //Databases extend from module RoomDatabase
    //Databases need an abstract class that returns the Dao
    //4 - abstract and return Dao
    abstract fun studentDao(): StudentsDao
    //5 - Singleton
    companion object {
        //getting an instance of the database
        //AppDatabase.getInstance() we call the methods with the class name because its a singleton
        //and there is only one instance
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if(INSTANCE == null){ //checks if an instance already exists or not
                //6 - aquiring an instance of RoomDB builder
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "students.db")
                        .allowMainThreadQueries().build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}


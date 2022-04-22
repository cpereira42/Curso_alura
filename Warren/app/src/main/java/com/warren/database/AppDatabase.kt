package com.warren.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.warren.database.dao.UserDao
import com.warren.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = true
)



abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var db : AppDatabase?= null
        fun instancia(context: Context) : AppDatabase {
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "warren.db"
            ).build().also {
                    db = it
            }
        }
    }
}
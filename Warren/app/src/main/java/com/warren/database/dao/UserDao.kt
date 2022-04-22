package com.warren.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.warren.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun save(user: User)

    @Query("SELECT * FROM User WHERE id = '0'")
    suspend fun loadInfo () : User?

}
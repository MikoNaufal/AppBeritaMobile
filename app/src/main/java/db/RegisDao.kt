package db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RegisDao {
        @Query("SELECT * FROM user")
        suspend fun getAll(): List<Regis>

        @Query("SELECT * FROM user WHERE uid IN (:userIds)")
        suspend fun loadAllByIds(userIds: Int): List<Regis>

        @Query("SELECT * FROM user WHERE name=:name")
        suspend fun findByName(name:String): Regis

        @Insert
        suspend fun insertAll( users: Regis)

        @Delete
        suspend fun delete(user: Regis)

        @Query("SELECT EXISTS(SELECT*FROM user where email=:email AND password=:password)")
        suspend fun login(email: String, password: String): Boolean
        @Query("SELECT email from user where email=:email")
        suspend fun getEmail(email: String): String

        @Query("SELECT password from user where password=:password")
        suspend fun getPassword(password: String): String
}
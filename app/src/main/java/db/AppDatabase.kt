package db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Regis::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "user_database"
                    )
                        .build()
                }
            }
            return INSTANCE

        }
    }

        abstract fun RegisDao(): RegisDao

    }


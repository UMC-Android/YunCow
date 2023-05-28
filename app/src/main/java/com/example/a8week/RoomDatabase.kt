package com.example.a8week

import android.content.Context
import androidx.room.*

@Database(entities = [Memo::class], version = 2)
abstract class RoomDatabase : RoomDatabase() {

    abstract fun memoDao(): MemoDao

    companion object {
        private var INSTANCE: RoomDatabase? = null

        fun getInstance(context: Context): RoomDatabase? {
            if (INSTANCE == null) {
                synchronized(RoomDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        RoomDatabase::class.java, "memo.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}


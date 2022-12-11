package com.example.beadando_joiad3.model

import android.content.Context
import android.graphics.ColorSpace
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [ColorSpace.Model::class], version = 5)
abstract class DogDatabase : RoomDatabase() {
    abstract fun imgDao(): imgDAO
    internal class PopulateDbAsyn(dogDatabase: DogDatabase?) :
        AsyncTask<Void?, Void?, Void?>() {
        private var imgDAO: imgDAO

        init {
            imgDAO = dogDatabase!!.imgDao()
        }
        override fun doInBackground(vararg voids: Void?): Void? {
            imgDAO.deleteAll()
            return null
        }


    }

    companion object {
        private const val DATABASE_NAME = "Dog"

        @Volatile
        var INSTANCE: DogDatabase? = null
        fun getInstance(context: Context?): DogDatabase? {
            if (INSTANCE == null) {
                synchronized(DogDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context!!,
                            DogDatabase::class.java, DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .addCallback(callback)
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        var callback: Callback = object : Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsyn(INSTANCE)
            }
        }
    }
}
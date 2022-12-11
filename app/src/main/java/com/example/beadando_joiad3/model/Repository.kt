package com.example.beadando_joiad3.model
import android.app.Application
import android.graphics.ColorSpace.Model
import android.os.AsyncTask
import androidx.lifecycle.LiveData


class Repository(application: Application?) {
    var imgDAO: imgDAO? = null
    var getAllDogs: LiveData<List<apiModel?>?>? = null
    private var database: DogDatabase? = null

    fun Repository(application: Application?) {
        database = DogDatabase.getInstance(application)
        imgDAO = database?.imgDao()
        getAllDogs = imgDAO?.getdogs()
    }

    fun insert(dogs: List<apiModel?>?) {
        InsertAsyncTask(imgDAO).execute(dogs)
    }

    fun getAllDogs(): LiveData<List<apiModel?>?>? {
        return getAllDogs
    }

     class InsertAsyncTask(dogDao: imgDAO?) :
        AsyncTask<List<apiModel?>?, Void?, Void?>() {
        private var imgDAO: imgDAO? = null

        init {
            imgDAO = dogDao
        }

         override fun doInBackground(vararg lists: List<apiModel?>?): Void? {
            imgDAO?.insert(lists[0])
            return null
        }
    }
}
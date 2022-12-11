package com.example.beadando_joiad3.model

import android.graphics.ColorSpace.Model
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface imgDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dogs: List<apiModel?>?)

    @Query("SELECT * FROM dogimg")
    fun getdogs(): LiveData<List<apiModel?>?>?

    @Query("DELETE FROM dogimg")
    fun deleteAll()
}
package com.example.beadando_joiad3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dogimg")
class apiModel(@SerializedName("message") @ColumnInfo(name = "message") var url: String = "")  {






}
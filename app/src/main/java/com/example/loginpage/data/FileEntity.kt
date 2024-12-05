package com.example.loginpage.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "files")
data class FileEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, @ColumnInfo(name = "fileName") val fileName: String,
    @ColumnInfo(name = "fileType") val fileType: String)
package com.example.loginpage.data
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFile(file: FileEntity)

    @Delete
    suspend fun deleteFile(file: FileEntity)

    @Query("SELECT * FROM files WHERE fileType = :type")
    suspend fun getFilesByType(type: String): List<FileEntity>

    @Query("SELECT * FROM files")
    suspend fun getAllFiles(): List<FileEntity>
}
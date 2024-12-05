package com.example.loginpage.data

class FileRepository(private val fileDao: FileDao) {
    suspend fun addFile(file: FileEntity) = fileDao.insertFile(file)
    suspend fun deleteFile(file: FileEntity) = fileDao.deleteFile(file)
    suspend fun getFilesByType(type: String) = fileDao.getFilesByType(type)
    suspend fun getAllFiles() = fileDao.getAllFiles()
}
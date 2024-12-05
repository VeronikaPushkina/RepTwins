package com.example.loginpage.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FileViewModel(private val repository: FileRepository) : ViewModel() {
    fun addFile(file: FileEntity) {
        viewModelScope.launch {
            repository.addFile(file)
        }
    }

    fun getFiles(type: String, callback: (List<FileEntity>) -> Unit) {
        viewModelScope.launch {
            val files = repository.getFilesByType(type)
            callback(files)
        }
    }
}
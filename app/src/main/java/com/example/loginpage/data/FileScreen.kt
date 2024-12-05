package com.example.loginpage.data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun FileScreen(viewModel: FileViewModel) {
    val fileList = remember { mutableStateListOf<FileEntity>() }
    val fileType = remember { mutableStateOf("") }

    Column {
        // Поле для ввода типа файла
        TextField(
            value = fileType.value,
            onValueChange = { fileType.value = it },
            label = { Text("Введите тип файла") }
        )

        // Кнопка для получения файлов по типу
        Button(onClick = {
            viewModel.getFiles(fileType.value) { files ->
                fileList.clear()
                fileList.addAll(files)
            }
        }) {
            Text("Получить файлы")
        }

        // Список файлов
        LazyColumn {
            items(fileList) { file ->
                Text(text = file.fileName)
            }
        }

        // Кнопка для добавления тестового файла
        Button(onClick = {
            val newFile = FileEntity(
                id = 0,
                fileName = "Новый файл",
                fileType = "тест")
            viewModel.addFile(newFile)
        }) {
            Text("Добавить файл")
        }
    }
}
@Composable
fun FileScreenWithViewModel() {
    val repository = FileRepository(DatabaseProvider.getDatabase(LocalContext.current).fileDao())
    val viewModel = FileViewModel(repository)
    FileScreen(viewModel = viewModel)}
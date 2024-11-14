// CourseCardData.kt
package com.example.loginpage

enum class CourseStatus {
    IN_PROGRESS,
    COMPLETED
}

data class CourseCardData(
    val id: String,
    val courseName: String,
    val creatorName: String,
    val courseDescription: String,
    val lessonsCount: Int,
    val profileImageRes: Int,
    val likesCount: Int,
    val isLiked: Boolean,
    val enrolledCount: Int,
    val completedCount: Int,
    val lastUpdated: String,
    val status: CourseStatus,




    )

// Sample data with adjusted lessonsCount and lessons
val courseCards = listOf(
    CourseCardData(
        id = "1",
        courseName = "ДЗ Теория графов",
        creatorName = "Задание 1",
        courseDescription = "Соотнесение весовых/матриц смежности с взвешанными/невзвешанными графами. Усложнение: Симметричные и ориентированные графы",
        lessonsCount = 3,
        profileImageRes = R.drawable.dz,
        likesCount = 123,
        isLiked = false,
        enrolledCount = 3 ,
        completedCount = 15,
        lastUpdated= "Легко",
        status = CourseStatus.IN_PROGRESS
    ),
    // Existing courses 2 through 8 (not shown here for brevity)
    // Course ID 9
    CourseCardData(
        id = "9",
        courseName = "Презентация Теория графов",
        creatorName = "Задание 1",
        courseDescription = "Изучите виды графов и матриц",
        lessonsCount = 2,
        profileImageRes = R.drawable.present,
        likesCount = 95,
        isLiked = true,
        enrolledCount = 3,
        completedCount = 20,
        lastUpdated = "Легко",
        status = CourseStatus.IN_PROGRESS

    ),
    // Course ID 10
    CourseCardData(
        id = "10",
        courseName = "ДЗ Алгебра Логики",
        creatorName = "Задание 2",
        courseDescription = "Изучите логические операции, их приоритет и булевый тип данных",
        lessonsCount = 3,
        profileImageRes = R.drawable.dz,
        likesCount = 130,
        isLiked = true,
        enrolledCount = 2,
        completedCount = 15,
        lastUpdated = "Легко",
        status = CourseStatus.COMPLETED,

    )
)

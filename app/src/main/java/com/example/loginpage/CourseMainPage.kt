// CourseMainPage.kt
package com.example.loginpage

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun YourComposable() {
    val context =LocalContext.current
    IconButton(onClick = {
        // Здесь вы можете получить ссылку на кнопку с помощью `findViewById`
        val url = "https://docs.google.com/presentation/d/14bDrnyJIQvienvAP6BlVK4ImmCA3v4pl/edit?usp=sharing&ouid=117138899159069154763&rtpof=true&sd=true"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent) // Используем контекст
    }) {
        Icon(
            painter = painterResource(id = R.drawable.nav_arrow_right),
            contentDescription = "Start Course"
        )
    }
}

fun startActivity(intent: Intent) {

}

@Composable
fun CourseMainPage(
    courseCardData: CourseCardData,
    navController: NavController
) {
    // Remember the list of lessons to manage state
   
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Scrollable content
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Course Title
            Text(
                text = courseCardData.courseName,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Author's Photo and Name
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = courseCardData.profileImageRes),
                    contentDescription = "Author's Photo",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(25.dp))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = courseCardData.creatorName)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Course Description
            Text(
                text = courseCardData.courseDescription,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Course Statistics Card
            CourseStatisticsCard(
                courseStatisticsData = CourseStatisticsData(
                    enrolledCount = courseCardData.enrolledCount,
                    completedCount = courseCardData.completedCount,
                    lastUpdated = courseCardData.lastUpdated
                )
            )



            Spacer(modifier = Modifier.height(16.dp))

            // Scrollable Area with Lesson Cards


            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Fixed Navigation Hints at the Bottom
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.surface),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Column 1: Go Back
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.nav_arrow_left),
                        contentDescription = "Go Back"
                    )
                }
                Text(text = "Вернуться")
            }

            // Column 2: Likes
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { /* Handle like action */ }) {
                    Icon(
                        painter = painterResource(
                            id = if (courseCardData.isLiked) R.drawable.icom_liked else R.drawable.icom_not_liked
                        ),
                        contentDescription = "Like"
                    )
                }
                Text(text = courseCardData.likesCount.toString())
            }

            // Column 3: Start
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                YourComposable()
                }
                Text(text = "Приступить")
            }
        }
    

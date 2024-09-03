package com.rakarguntara.mangasource.widgets.details.manga

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rakarguntara.mangasource.R
import com.rakarguntara.mangasource.models.MangaDetailResponse

@Composable
fun MangaDetailContent(manga: MangaDetailResponse) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        AsyncImage(model = manga.pictureUrl, contentDescription = "Picture",
            modifier = Modifier.fillMaxWidth().height(200.dp))
        Box(modifier = Modifier.height(16.dp))
        Text(manga.titleEn, style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = colorResource(R.color.teal)
        ))
        Box(modifier = Modifier.height(16.dp))
        Text("Synopsis:", style = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.Black.copy(0.9f)
        ))
        Box(modifier = Modifier.height(8.dp))
        Text(manga.synopsis, style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify
        ), modifier = Modifier.fillMaxWidth())
        Box(modifier = Modifier.height(16.dp))
        Text("Published:", style = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.Black.copy(0.9f)
        ))
        Box(modifier = Modifier.height(8.dp))
        Text(manga.information.published, style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        ))
        Box(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Score:", style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color.Black.copy(0.9f)
            ))

            Text(manga.statistics.score.toString(), style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ))
        }
    }
}
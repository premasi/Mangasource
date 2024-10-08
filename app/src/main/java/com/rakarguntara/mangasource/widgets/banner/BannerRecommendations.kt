package com.rakarguntara.mangasource.widgets.banner

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rakarguntara.mangasource.R
import com.rakarguntara.mangasource.models.RecommendationsItem

@Composable
fun BannerRecommendations(manga: RecommendationsItem){
    Surface(
        modifier = Modifier
            .padding(end = 8.dp)
            .shadow(10.dp, shape = RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp)),
        color = colorResource(R.color.teal),
    ){
        AsyncImage(model = manga.recommendation.pictureUrl, contentDescription = stringResource(R.string.picture),
            modifier = Modifier.width(100.dp).height(150.dp),
            contentScale = ContentScale.Fit,
            placeholder = painterResource(R.drawable.ic_launcher_background)
        )
    }
}
package com.rakarguntara.mangasource.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rakarguntara.mangasource.R
import com.rakarguntara.mangasource.navigations.NavigationScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scaleAnimationState = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true, block = {
        scaleAnimationState.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                }
            )
        )

        delay(1000)
        navController.navigate(NavigationScreens.MainScreen.name){
            popUpTo(NavigationScreens.MainScreen.name){
                inclusive = true
            }
        }
    })

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
            .scale(scaleAnimationState.value),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Text(stringResource(R.string.mangasource), style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = colorResource(R.color.teal)
        ))
    }
}
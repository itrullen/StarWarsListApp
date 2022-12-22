package com.example.starwarslistapp.presentation.utils

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import com.airbnb.lottie.compose.*
import com.example.starwarslistapp.R

private const val ANIMATION_SPEED = 1f

class LoadingAnimation {
    private val file
        get() = R.raw.lottie_loader_dark

    private fun Modifier.applySize(): Modifier = this.scale(1.5f)

    // Elvis operator is a temporary fix for this issue: https://issuetracker.google.com/issues/201556419
    @Composable
    operator fun invoke(
        isLoading: Boolean? = true,
        modifier: Modifier
    ) = LoadingAnimation(file, isLoading ?: true, modifier.applySize())
}


@Composable
private fun LoadingAnimation(
    @RawRes file: Int,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(file)
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isLoading,
        speed = ANIMATION_SPEED,
        restartOnPlay = true
    )

    LottieAnimation(composition, progress, modifier)
}
package com.lebaillyapp.blaze_agsl.ui.composition

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.lebaillyapp.blaze_agsl.R
import com.lebaillyapp.blaze_agsl.ui.component.ExplodableBox

@Composable
fun ExplodableBoxDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000)),
        contentAlignment = Alignment.Center
    ) {
        ExplodableBox(
            modifier = Modifier.fillMaxSize(),
            shaderResId = R.raw.explodingshader
        ) {
            Image(
                painter = painterResource(id = R.drawable.demopic1),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

        }
    }
}
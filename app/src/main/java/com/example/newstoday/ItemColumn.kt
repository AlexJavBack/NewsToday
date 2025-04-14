package com.example.newstoday

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun items(item: ItemColumModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.White)
            .padding(3.dp)) {
        Image(painter = painterResource(id = item.image), contentDescription = "i",
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(3.dp)
                .clip(CircleShape)
                .size(50.dp)
        )
        Text(text = item.description)
    }
}
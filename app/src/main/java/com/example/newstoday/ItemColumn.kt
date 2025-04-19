package com.example.newstoday

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.newstoday.retrofit.GlobalNewsViewModel

@Composable
fun CardNew(item: ItemColumModel, viewModel: GlobalNewsViewModel, index : Int) {
    val newsList = viewModel.arrayNews
    val ctx = LocalContext.current
    Card(modifier = Modifier
        .padding(1.dp)
        .fillMaxWidth()
        .offset(1.dp),
        shape = RoundedCornerShape(15.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(Color.White)
                .padding(3.dp)) {
            AsyncImage(
                model = newsList.getOrNull(index)?.imageUrl ?: "",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(5.dp)
                    .clip(CircleShape)
                    .size(64.dp)
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(newsList.getOrNull(0)?.title ?: "")
                }
                Row(horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxSize()) {
                    Text(newsList.getOrNull(index)?.description ?: "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)
                }
                Row(horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxSize()) {
                    TextButton(onClick = {
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(newsList.getOrNull(index)?.link ?: "")
                        )
                        ctx.startActivity(urlIntent)
                    }
                    ) {
                        Text("Show more")
                    }
                }
            }
        }
    }

}

package com.murerwa.composecards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.murerwa.composecards.ui.theme.ComposeCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityBody()
        }
    }
}

@Composable
fun ActivityBody(){
    val imageId = R.drawable.kermit_in_snow
    val contentDescription = "Kermit playing in the snow"
    val title = "Kermit playing in the snow"

    val images = listOf(
        ImageItem(
            title = title,
            description = contentDescription,
            drawable = imageId
        ),
        ImageItem(
            title = title,
            description = contentDescription,
            drawable = imageId
        ),
        ImageItem(
            title = title,
            description = contentDescription,
            drawable = imageId
        ),
        ImageItem(
            title = title,
            description = contentDescription,
            drawable = imageId
        ),
        ImageItem(
            title = title,
            description = contentDescription,
            drawable = imageId
        )
    )


    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(
            items = images,
            itemContent = {
                Box (
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 10.dp, bottom = 4.dp, end = 6.dp, start = 6.dp)
                ) {
                    ImageCard(imageItem = it)
                }

            }
        )
    }
}

@Composable
fun ImageCard(
    imageItem: ImageItem
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painterResource(id = imageItem.drawable),
                contentDescription = imageItem.description,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = imageItem.title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ActivityBody()
}

data class ImageItem(
    val title: String,
    val description: String,
    val drawable: Int = R.drawable.kermit_in_snow
)
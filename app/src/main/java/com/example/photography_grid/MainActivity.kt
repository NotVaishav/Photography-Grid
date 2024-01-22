package com.example.photography_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.photography_grid.data.DataSource
import com.example.photography_grid.topic.Topic
import com.example.photography_grid.ui.theme.PhotographyGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotographyGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtGrid()
                }
            }
        }
    }
}

@Composable
fun ArtGrid(modifier: Modifier = Modifier) {
    val photosList = DataSource.topics
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(photosList) { photo ->
            GridItem(photo)
        }
    }
}

@Composable
fun GridItem(photoItem: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(photoItem.imageResourceId),
                contentDescription = null,
                modifier = modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),

                ) {
                Text(
                    text = LocalContext.current.getString(photoItem.stringFileResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(bottom = 8.dp),
                    textAlign = TextAlign.Center
                )
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = photoItem.intQuantityResourceId.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center,
                        modifier = modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview()
@Composable
fun GreetingPreview() {
    PhotographyGridTheme {
        GridItem(Topic(R.string.architecture, 58, R.drawable.architecture))
    }
}
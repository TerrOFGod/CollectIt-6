package com.example.collectit.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

class BasicVideoComponent {
    companion object {
        @ExperimentalMaterial3Api
        @Composable
        fun BasicVideoComponent(
            onClick: () -> Unit,
            modifier: Modifier,
            url: String,
            title: String,
            date: String
        ){
            Card(
                modifier = modifier,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,

                    ),
                shape = MaterialTheme.shapes.large
            ){
                Image(
                    painter = rememberAsyncImagePainter(
                        model = url
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.large)
                        .fillMaxWidth()
                        .aspectRatio(3f / 2f)
                )
                FlowRow(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    mainAxisSpacing = 90.dp,
                    mainAxisSize = SizeMode.Wrap
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = date,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
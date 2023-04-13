package com.example.collectit.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red

class CustomTagComponent {
    companion object {
        @ExperimentalMaterial3Api
        @Composable
        fun CustomTagComponent(
            onClick: () -> Unit,
            text: String
        ) {
            AssistChip(
                onClick = onClick,
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                label = {
                    Text(
                        text = text,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            )
        }
    }
}

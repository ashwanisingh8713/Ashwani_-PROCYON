package com.procyon.assesement.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Created by Ashwani Kumar Singh on 02,April,2024.
 */


@Composable
fun UserCard(text1: String, text2: String, text3: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
        ),
        border = BorderStroke(0.5.dp, Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = text1,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight(650),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = text2,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight(900),
                )
            }

            Box(
                modifier = Modifier
                    .background(Color.LightGray, RoundedCornerShape(28.dp))
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = text3,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight(900),
                    modifier = Modifier
                        .padding(start = 4.dp, end = 4.dp)
                )
            }
        }
    }
}
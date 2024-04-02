package com.procyon.assesement.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by Ashwani Kumar Singh on 02,April,2024.
 */

@Composable
fun Stepper() {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Button(
            onClick = {  },
            modifier = Modifier.weight(1f).height(6.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.primary
            )
        ){}

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = {  },
            modifier = Modifier.weight(1f).height(6.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.primary
            )
        ){}
    }
}
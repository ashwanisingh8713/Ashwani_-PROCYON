package com.procyon.assesement.presentation.userinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import com.mohamedrejeb.calf.ui.datepicker.AdaptiveDatePicker
import com.mohamedrejeb.calf.ui.datepicker.UIKitDisplayMode
import com.mohamedrejeb.calf.ui.datepicker.rememberAdaptiveDatePickerState
import com.procyon.assesement.util.getSelectedDate

@OptIn(ExperimentalMaterial3Api::class)
internal class DatePickerScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val viewModel = getScreenModel<UserInfoViewModel>()

        val state = rememberAdaptiveDatePickerState(yearRange = 2024..2025,
            initialUIKitDisplayMode = UIKitDisplayMode.Wheels)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .windowInsetsPadding(WindowInsets.systemBars)
                .windowInsetsPadding(WindowInsets.ime)
                .scrollable(
                    rememberScrollState(),
                    orientation = Orientation.Vertical
                )
        ) {
            IconButton(
                onClick = {
                    navigator?.pop()
                },
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp)
            ) {
                Icon(
                    Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onBackground,
                )
            }

            Text(
                text = "Kindly select a date",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(16.dp)
            )

            state.selectedDateMillis?.run {
                val selectedDate = getSelectedDate(this)
                Text(
                    text = "Selected date: $selectedDate",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(16.dp)
                )
                viewModel.updateSelectedDate(selectedDate)
            }

            AdaptiveDatePicker(
                state = state,
                modifier = Modifier,
                showModeToggle = false,
            )
        }
    }
}
package com.procyon.assesement.presentation.userinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.mohamedrejeb.calf.ui.timepicker.AdaptiveTimePicker
import com.mohamedrejeb.calf.ui.timepicker.rememberAdaptiveTimePickerState
import com.procyon.assesement.presentation.userinfo.UserInfoViewModel
import com.procyon.assesement.util.format
import com.procyon.assesement.util.timeFormatter
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
internal class TimePickerScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current
        val viewModel = getScreenModel<UserInfoViewModel>()
        val userInfoDto by viewModel.uiState.collectAsState()

        val initTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).time
        val state = rememberAdaptiveTimePickerState(is24Hour = false, initialHour = initTime.hour,
            initialMinute = initTime.minute)

        val timeStart = LocalTime(state.hour, state.minute)
        val timeEnd = LocalTime.parse("${(timeStart.hour + 1).format()}:${timeStart.minute.format()}")

        viewModel.updateSelectedTimeStart(timeFormatter(timeStart.hour, timeStart.minute),
            timeFormatter(timeEnd.hour, timeEnd.minute))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .windowInsetsPadding(WindowInsets.systemBars)
                .windowInsetsPadding(WindowInsets.ime)
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
                text = "Kindly select time",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(16.dp)
            )

            Text(
//                text = "Selected time: ${state.hour.format()}:${state.minute.format()}",
                text = "Selected time: ${userInfoDto.userInfo.timeStart}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(16.dp)
            )

            AdaptiveTimePicker(
                state = state,
                modifier = Modifier,

            )
        }


    }
}
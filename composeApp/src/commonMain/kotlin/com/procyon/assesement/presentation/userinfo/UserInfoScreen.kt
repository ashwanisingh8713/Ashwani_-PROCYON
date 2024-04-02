package com.procyon.assesement.presentation.userinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import com.procyon.assesement.presentation.component.UserCard
import com.procyon.assesement.presentation.component.CustomDefaultBtn
import com.procyon.assesement.presentation.component.DateCard
import com.procyon.assesement.presentation.component.HeadlineTextField
import com.procyon.assesement.presentation.component.Loading
import com.procyon.assesement.presentation.component.Stepper
import com.procyon.assesement.presentation.component.TimeCard
import com.procyon.assesement.presentation.component.UserTextFieldInput
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */

class UserInfoScreen : Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current
        val viewModel = getScreenModel<UserInfoViewModel>()
        val userInfoDto by viewModel.uiState.collectAsState()

        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collectLatest { effect ->
                when (effect) {
                    is UserInfoContract.Effect.NavigateToDateScreen ->
                        navigator?.push(DatePickerScreen())

                    is UserInfoContract.Effect.NavigateToTimeScreen ->
                        navigator?.push(TimePickerScreen())
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .windowInsetsPadding(WindowInsets.statusBars)
        ) {
            Scaffold(modifier = Modifier.fillMaxSize(),
                topBar = {
                    IconButton(
                        onClick = {
                            navigator?.pop()
                        },
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                },
                bottomBar = {
                    CustomDefaultBtn(shapeSize = 0.01f, btnText = "Next") {
                    }
                },
                content = { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Column(
                            modifier = Modifier.padding(8.dp).verticalScroll(rememberScrollState())
                        ) {

                            if(userInfoDto.userInfo.id == -1) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Loading()
                                }
                            } else {
                                val userInfo = userInfoDto.userInfo
                                // Screen Text Headline
                                HeadlineTextField(
                                    text = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                fontStyle = FontStyle.Italic,
                                                fontFamily = FontFamily.Serif,
                                                fontSize = 40.sp
                                            )
                                        ) {
                                            append("Book a trial shift")
                                        }
                                    }
                                )

                                // Stepper
                                Stepper()

                                // Text Headline
                                HeadlineTextField(
                                    text = buildAnnotatedString {
                                        append("Please complete all required fields")
                                    }
                                )

                                // User Card
                                UserCard(
                                    text1 = userInfo.source,
                                    text2 = userInfo.name,
                                    text3 = userInfo.price
                                )

                                // Divider
                                HorizontalDivider(
                                    modifier = Modifier.fillMaxWidth()
                                        .padding(top = 8.dp, bottom = 16.dp)
                                        .background(Color.LightGray)
                                )

                                // Text Headline
                                HeadlineTextField(
                                    text = buildAnnotatedString {
                                        append("When would you like the shift?")
                                        withStyle(style = SpanStyle(Color.Red)) {
                                            append(" *")
                                        }
                                        append("\n")
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                                            append("Trial shifts are 1 hour")
                                        }
                                    }
                                )

                                // Date Card
                                DateCard(userInfo.date) {
                                    viewModel.setEvent(UserInfoContract.Event.OnDateCardClick)
                                }

                                // Time Card
                                TimeCard(userInfo.timeStart, userInfo.timeEnd) {
                                    viewModel.setEvent(UserInfoContract.Event.OnTimeCardClick)
                                }

                                // Divider
                                HorizontalDivider(
                                    modifier = Modifier.fillMaxWidth()
                                        .padding(top = 8.dp, bottom = 16.dp)
                                        .background(Color.LightGray)
                                )

                                // Text Headline
                                HeadlineTextField(
                                    text = buildAnnotatedString {
                                        append("What do you need help with?")
                                        withStyle(style = SpanStyle(Color.Red)) {
                                            append("*")
                                        }
                                    }
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                // TextField Input
                                UserTextFieldInput {

                                }

                            }
                        }
                    }

                }
            )
        }

    }

}
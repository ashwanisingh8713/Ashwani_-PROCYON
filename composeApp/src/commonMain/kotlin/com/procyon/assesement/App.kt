package com.procyon.assesement

import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import com.procyon.assesement.presentation.userinfo.UserInfoScreen
import com.procyon.assesement.presentation.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    Navigator(UserInfoScreen())
}

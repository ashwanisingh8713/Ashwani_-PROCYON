package com.procyon.assesement.presentation.userinfo

import com.procyon.assesement.domain.model.UserInfoDto
import com.procyon.assesement.presentation.mvi.UiEffect
import com.procyon.assesement.presentation.mvi.UiEvent
import com.procyon.assesement.presentation.mvi.UiState

/**
 * Created by Ashwani Kumar Singh on 02,April,2024.
 */
interface UserInfoContract {
    sealed interface Event : UiEvent {
        object OnDateCardClick : Event
        object OnTimeCardClick : Event
    }

    data class State(
        val userInfo: UserInfoDto
    ) : UiState

    sealed interface Effect : UiEffect {
        object NavigateToDateScreen : Effect
        object NavigateToTimeScreen : Effect
    }
}
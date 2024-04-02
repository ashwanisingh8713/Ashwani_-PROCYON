package com.procyon.assesement.presentation.userinfo

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.procyon.assesement.domain.model.UserInfoDto
import com.procyon.assesement.domain.usecase.UserInfoUseCase
import com.procyon.assesement.presentation.mvi.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */
class UserInfoViewModel(private val userInfoUseCase: UserInfoUseCase):
    BaseViewModel<UserInfoContract.Event, UserInfoContract.State, UserInfoContract.Effect>() {

//    val _selectedDate = MutableStateFlow(UserInfoDto())
//    val selectedDate = _selectedDate.asStateFlow()

    init{
        getUserInfo()
    }

    private fun getUserInfo() {
        screenModelScope.launch {
            userInfoUseCase("1")
                .onSuccess {
                    setState {
                        copy(
                            userInfo = it
                        )
                    }

                }.onFailure { error ->
                    println(error.message)
                }
        }
    }

    fun updateSelectedDate(date: String) {
        setState {
            copy(
                userInfo = currentState.userInfo.copy(date = date)
            )
        }
    }

    fun updateSelectedTimeStart(timeStart: String, timeEnd: String) {
        setState {
            copy(
                userInfo = currentState.userInfo.copy(timeStart = timeStart, timeEnd = timeEnd)
            )
        }
    }

    override fun createInitialState(): UserInfoContract.State {
        return UserInfoContract.State(userInfo = UserInfoDto())
    }

    override fun handleEvent(event: UserInfoContract.Event) {
        when(event) {
            is UserInfoContract.Event.OnDateCardClick -> setEffect { UserInfoContract.Effect.NavigateToDateScreen }
            is UserInfoContract.Event.OnTimeCardClick -> setEffect { UserInfoContract.Effect.NavigateToTimeScreen }
        }
    }

}
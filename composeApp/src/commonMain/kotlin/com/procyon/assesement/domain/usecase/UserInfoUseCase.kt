package com.procyon.assesement.domain.usecase

import com.procyon.assesement.domain.model.UserInfoDto
import com.procyon.assesement.domain.repo.IUserInfoRepo
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */
class UserInfoUseCase(private val repo: IUserInfoRepo,
                      dispatcher: CoroutineDispatcher):
    BaseUseCase<String, UserInfoDto>(dispatcher) {
    override suspend fun block(param: String): UserInfoDto {
        return repo.getUserInfo(param)
    }
}
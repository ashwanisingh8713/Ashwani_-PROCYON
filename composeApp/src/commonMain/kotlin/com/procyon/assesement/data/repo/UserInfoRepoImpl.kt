package com.procyon.assesement.data.repo

import com.procyon.assesement.data.model.UserInfoInput
import com.procyon.assesement.domain.model.UserInfoDto
import com.procyon.assesement.domain.repo.IUserInfoRepo

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */
class UserInfoRepoImpl(private val inputSource: UserInfoInput): IUserInfoRepo {
    override suspend fun getUserInfo(id: String): UserInfoDto {
        return inputSource.toDto()
    }
}
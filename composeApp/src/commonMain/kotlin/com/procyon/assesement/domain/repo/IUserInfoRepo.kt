package com.procyon.assesement.domain.repo

import com.procyon.assesement.domain.model.UserInfoDto

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */
interface IUserInfoRepo {
    suspend fun getUserInfo(id: String): UserInfoDto
}
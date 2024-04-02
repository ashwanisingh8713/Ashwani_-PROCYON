package com.procyon.assesement.domain.model

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */
data class UserInfoDto(
    val id: Int = -1,
    val name: String = "",
    val price: String = "",
    val source: String = "",
    val date: String = "",
    val timeStart: String = "",
    val timeEnd: String = "",
)

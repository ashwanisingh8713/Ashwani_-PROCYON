package com.procyon.assesement.data.model

import com.procyon.assesement.domain.model.UserInfoDto
import com.procyon.assesement.util.getSelectedDate
import com.procyon.assesement.util.timeFormatter
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */
class UserInfoInput(
    val id: Int,
    val name: String,
    val price: String,
    val source: String,
) {

    fun toDto(): UserInfoDto {
        val instant = Clock.System.now()
        val timeStart = instant.toLocalDateTime(TimeZone.currentSystemDefault()).time
        val duration = 60.toDuration(DurationUnit.MINUTES)
        val timeEnd = instant.plus(duration).toLocalDateTime(TimeZone.currentSystemDefault()).time

        val startTimeFormate = timeFormatter(timeStart.hour, timeStart.minute)
        val endTimeFormate = timeFormatter(timeEnd.hour, timeEnd.minute)

        return UserInfoDto(
            id = id,
            name = name,
            price = price,
            source = source,
            date = getSelectedDate(instant.toEpochMilliseconds()),
            timeStart = startTimeFormate,
            timeEnd = endTimeFormate
        )
    }
}

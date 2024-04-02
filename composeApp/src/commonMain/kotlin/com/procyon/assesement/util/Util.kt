package com.procyon.assesement.util

/**
 * Created by Ashwani Kumar Singh on 02,April,2024.
 */

expect fun getSelectedDate(millis: Long): String

fun timeFormatter(hour: Int, minute: Int): String {
    return convertHourMinuteToAmPm(hour, minute)
}

fun convertHourMinuteToAmPm(hour: Int, minute: Int): String {
    val amPm = if (hour < 12) "AM" else "PM"
    val hourIn12HourFormat = if (hour == 0) 12 else hour % 12
    return "$hourIn12HourFormat:${minute.format()} $amPm"
}

fun Int.format(): String{
    return if(this in 0..9) "0" + this.toString() else this.toString()
}
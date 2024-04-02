package com.procyon.assesement.util

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by Ashwani Kumar Singh on 02,April,2024.
 */

val dateFormat = SimpleDateFormat("MMM dd")

actual fun getSelectedDate(millis: Long): String {
    val date = Date(millis)
    return dateFormat.format(date)
}
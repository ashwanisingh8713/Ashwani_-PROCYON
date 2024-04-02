package com.procyon.assesement.util

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter

/**
 * Created by Ashwani Kumar Singh on 02,April,2024.
 */


val dateFormatter = NSDateFormatter()

fun dateFromMilliseconds(milliseconds: Long) : NSDate {
    return NSDate(milliseconds / 1000.0)
}

actual fun getSelectedDate(millis: Long): String {
    val date = dateFromMilliseconds(millis)
    dateFormatter.dateFormat = "MMM dd"
    return dateFormatter.stringFromDate(date)
}
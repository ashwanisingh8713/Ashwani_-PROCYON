package com.procyon.assesement.util

import platform.Foundation.NSCalendar
import platform.Foundation.NSDate
import platform.Foundation.NSDateComponents
import platform.Foundation.NSDateFormatter

/**
 * Created by Ashwani Kumar Singh on 02,April,2024.
 */


val dateFormatter = NSDateFormatter()

fun dateFromMilliseconds(milliseconds: Long) : NSDate {
    return NSDate(milliseconds / 1000.0)
}

actual fun getSelectedDate(millis: Long): String {
    val currentDate = dateFromMilliseconds(millis)
    dateFormatter.dateFormat = "MMM dd"
    val dateComponents = NSDateComponents()
    // Set the day component to -1 to subtract one day
    dateComponents.day = -1
    // Create a calendar
    val calendar = NSCalendar.currentCalendar
    // Get the new date by adding the date components to the current date
    val newDate = calendar.dateByAddingComponents(dateComponents, currentDate, 0u)!!
    return dateFormatter.stringFromDate(newDate)
}
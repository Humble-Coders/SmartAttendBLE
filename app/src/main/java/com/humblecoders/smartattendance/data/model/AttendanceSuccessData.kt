package com.humblecoders.smartattendance.data.model


data class AttendanceSuccessData(
    val rollNumber: String,
    val studentName: String,
    val subject: String,
    val room: String,
    val type: String, // "lect", "lab", "tut"
    val deviceRoom: String = "", // Full BLE device name with digits
    val attendanceId: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
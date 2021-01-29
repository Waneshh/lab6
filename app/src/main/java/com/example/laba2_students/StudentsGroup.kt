package com.example.laba2_students

class StudentsGroup(val number: String, val facultyName: String, val educationLevel: Int, val contractExists: Boolean, val isPrivileged: Boolean) {
    companion object {
        val groups = listOf(StudentsGroup("301", "Комп'ютерних наук", 0, true, false),
            StudentsGroup("302", "Комп'ютерних наук", 0, true, false),
            StudentsGroup("303", "Комп'ютерних наук", 0, true, true),
            StudentsGroup("304", "Комп'ютерних наук", 0, true, false),
            StudentsGroup("405", "Комп'ютерних наук", 1, false, true))

        fun getGroup(number: String): StudentsGroup? {
            return groups.find { it.number == number }
        }
    }
}
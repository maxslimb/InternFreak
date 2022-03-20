package com.example.internfreak.data

import com.google.firebase.database.Exclude

class data_application_internship
    (var name: String? = "",
    var email: String? = "",
    var mobile: String?="",
    var location: String?= "",
    var education: String?="",
    var job_internships: String?="",
    var skills: String? = "",
    var linkcv: String? ="")
{
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "name" to name,
            "email" to email,
            "mobile" to mobile,
            "location" to location,
            "education" to education,
            "job_internships" to job_internships,
            "skills" to skills,
            "linkcv" to linkcv
        )
    }
}
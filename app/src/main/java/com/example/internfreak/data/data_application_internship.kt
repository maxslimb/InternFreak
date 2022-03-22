package com.example.internfreak.data

import com.google.firebase.database.Exclude

class data_application_internship
    (var name: String? = "",
    var email: String? = "",
    var mobile: String?="",
    var education: String?="",
    var job_internships: String?="",
    var skills: String? = "",
     var job_role :String? = "",
    var linkcv: String? ="")
{
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "name" to name,
            "email" to email,
            "mobile" to mobile,
            "education" to education,
            "job_internships" to job_internships,
            "skills" to skills,
            "job_role" to job_role,
            "linkcv" to linkcv,
            "job_role" to job_role
        )
    }
}
package com.example.internfreak.fragment


import com.google.firebase.database.Exclude

class studentdata(
    var name_student: String? = "",
    var email_student: String? = "",
    var address: String? = "",
    var mobile_no_student: String? = "",
    var name_of_college_student: String? = "",
    var year_student: String? = "",
    var dept_student: String? = "",
    var skills_student: String? = ""

)
{
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Name " to name_student,
            "Email" to email_student,
            "Address" to address,
            "Mobile No" to mobile_no_student,
            "College Name" to name_of_college_student,
            "Current Year" to year_student,
            "Department" to dept_student,
            "Skills" to skills_student

            )
    }

}
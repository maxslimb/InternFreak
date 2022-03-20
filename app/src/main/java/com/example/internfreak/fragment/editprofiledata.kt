package com.example.internfreak.fragment


import com.google.firebase.database.Exclude

class editprofiledata(
    var Name: String? = "",
    var Email: String? = "",
    var Address: String? = "",
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
            "Name " to Name,
            "Email" to Email,
            "Address" to Address,
            "Mobile No" to mobile_no_student,
            "College Name" to name_of_college_student,
            "Current Year" to year_student,
            "Department" to dept_student,
            "Skills" to skills_student
            )
    }

}
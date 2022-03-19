package com.example.internfreak.fragment

import com.google.firebase.database.Exclude

class companydata(

    var name_company: String? = "",
    var email_company: String? = "",
    var address_company: String? = "",
    var mobile_no_company: String? = "",
    var job_role_company: String? = "",
    var AbouUs: String? = ""


) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Name " to name_company,
            "Email" to email_company,
            "Address" to address_company,
            "Mobile No" to mobile_no_company,
            "Job Roles" to job_role_company,
            "AboutUs" to AbouUs

        )
    }
}
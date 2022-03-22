package com.example.internfreak.data

import com.google.firebase.database.Exclude

class data_host_internship
    (var job_role: String? = "",
     var description: String? = "",
     var company_name: String?="",
     var openings: String?= "",
     var start_date: String?="",
     var duration: String?="",
     var perks: String? = "",
     var stipend: String? = "",
     var location_lat: String? = "",
     var location_long: String? = "",
     var uid: String? = ""

     ) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Job_Role" to job_role,
            "Description" to description,
            "Company_Name" to company_name,
            "Openings" to openings,
            "Start_Date" to start_date,
            "Duration" to duration,
            "Perks" to perks,
            "Stipend" to stipend,
            "Location_lat" to location_lat,
            "Location_long" to location_long,
            "uid" to uid
        )
    }
}
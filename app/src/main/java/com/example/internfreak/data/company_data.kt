package com.example.internfreak.data

import com.google.firebase.database.Exclude

data class company_data (val Job_Role: String,val Description:String,
                         val Company_Name:String,val Stipend:String,val Start_Date:String,
                         val Openings:String,var Perks: String,
                         val Duration:String,var location_lat: String,
                         var location_long: String,
                         val uid: String
                         )
{

    constructor():this("","","","","","","","","","","")
    @Exclude

    fun toMap():Map<String,Any?> {

        return mapOf(
            "Job_Role" to Job_Role,
            "Description" to Description,
            "Company_Name" to Company_Name,
            "Openings" to Openings,
            "Start_Date" to Start_Date,
            "Duration" to Duration,
            "Perks" to Perks,
            "Stipend" to Stipend,
            "Location_lat" to location_lat,
            "Location_long" to location_long,
            "uid" to uid
        )
    }

}
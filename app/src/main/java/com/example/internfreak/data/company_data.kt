package com.example.internfreak.data

import com.google.firebase.database.Exclude

data class company_data (val company_name: String,val start_date:String,
                         val duration:String,val stipend:String,val Company_image:String,
                         val location_lat:String,val location_long:String)


{

    constructor():this("","","","","","","")
    @Exclude

    fun toMap():Map<String,Any?> {

        return mapOf(
            "Company Name" to company_name,
            "Start Date" to start_date,
            "Duration" to duration,
            "Stipend" to stipend,
            "Image" to Company_image,
            "Locaion_Lat" to location_lat,
            "Location_long" to location_long
        )
    }

}
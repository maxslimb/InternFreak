package com.example.internfreak.data

import com.google.firebase.database.Exclude

class intern_applied_data(val Uid_applicant: String,
                          val Name_applicant:String,
                          val status:String) {



constructor():this("","","",)

@Exclude

fun toMap():Map<String,Any?> {

    return mapOf(
        "Uid_applicant" to Uid_applicant,
        "Name_applicant" to Name_applicant,
        "Status" to status
    )
}


}
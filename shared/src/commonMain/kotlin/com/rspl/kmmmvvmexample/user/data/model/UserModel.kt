package com.rspl.kmmmvvmexample.user.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("employee_code")
    val employeeCode: String,
    @SerialName("division")
    val division: String,
    @SerialName("department")
    val department: String,
    @SerialName("designation")
    val designation: String,
    @SerialName("is_admin")
    val isAdmin: Boolean

)

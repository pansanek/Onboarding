package ru.thekodingklowns.onboarding.data.remote.model


import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val email: String,
    val fullName: String,
    val password: String,
    val phoneNumber: String,
    val rating: Int,
    val tgLink: String?,
    val vkLink: String?
)
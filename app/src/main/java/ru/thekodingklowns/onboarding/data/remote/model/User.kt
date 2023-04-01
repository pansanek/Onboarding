package ru.thekodingklowns.onboarding.data.remote.model


import kotlinx.serialization.Serializable
import ru.thekodingklowns.onboarding.core.toMd5

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
) {
    fun avatarOfSize(size: Int) = "https://www.gravatar.com/avatar/${email.toMd5()}?s=$size"
}
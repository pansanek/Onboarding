package ru.thekodingklowns.onboarding.data.remote

import retrofit2.http.GET
import ru.thekodingklowns.onboarding.data.remote.model.User

interface OnboardingApi {
    @GET("get-users")
    suspend fun getUsers(): List<User>
}
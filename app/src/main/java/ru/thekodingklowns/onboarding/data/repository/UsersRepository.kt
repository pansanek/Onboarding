package ru.thekodingklowns.onboarding.data.repository

import ru.thekodingklowns.onboarding.core.ResponseHandler
import ru.thekodingklowns.onboarding.data.remote.OnboardingApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(
    private val api: OnboardingApi,
    private val handler: ResponseHandler
) {

    suspend fun getUsers() = handler {
        api.getUsers()
    }
}
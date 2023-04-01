package ru.thekodingklowns.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.thekodingklowns.onboarding.core.Resource
import ru.thekodingklowns.onboarding.data.remote.model.User
import ru.thekodingklowns.onboarding.data.repository.UsersRepository
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repo: UsersRepository
): ViewModel() {
    private val _users = MutableStateFlow<Resource<List<User>>>(Resource.Loading)
    val users = _users.asStateFlow()

    init {
        fetchUsers()
    }

    fun fetchUsers() = viewModelScope.launch(Dispatchers.IO) {
        _users.update {
            repo.getUsers()
        }
    }
}
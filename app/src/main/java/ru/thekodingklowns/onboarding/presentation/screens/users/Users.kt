package ru.thekodingklowns.onboarding.presentation.screens.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ru.thekodingklowns.onboarding.core.Resource
import ru.thekodingklowns.onboarding.data.remote.model.User
import ru.thekodingklowns.onboarding.presentation.theme.OnboardingTheme
import ru.thekodingklowns.onboarding.presentation.viewmodel.UsersViewModel

@Composable
fun Users(
    usersViewModel: UsersViewModel
) {
    val users by usersViewModel.users.collectAsState()

    UsersContent(
        users = users,
        onRefresh = usersViewModel::fetchUsers
    )
}

@Composable
private fun UsersContent(
    users: Resource<List<User>>,
    onRefresh: () -> Unit
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(users == Resource.Loading),
        onRefresh = onRefresh
    ) {
        users.handle(
            onSuccess = {
                UsersList(it)
            },
            onError = {

            }
        )
    }
}

@Composable
private fun UsersList(users: List<User>) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp)
    ) {
        items(
            items = users,
            key = { it.id }
        ) {
            UserCard(it)
        }
    }
}

@Composable
private fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
    ) {
        user.run {
            Row(
                modifier = Modifier
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.extraLarge)
                        .width(40.dp)
                        .height(40.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(avatarOfSize(80))
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Avatar"
                )

                Spacer(Modifier.width(16.dp))

                Text(
                    modifier = Modifier.weight(1f),
                    text = fullName,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.width(16.dp))

                Text(
                    text = rating.toString(),
                    fontSize = 36.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(.5f)
                )
                /*email?.let {
                    EmailButton(it)
                }

                phoneNumber?.let {
                    PhoneButton(user)
                }*/
            }

        }
    }
}

@Preview
@Composable
fun UsersPreview() {
    OnboardingTheme {
        Surface {
            UsersContent(
                users = Resource.Success(listOf(
                    User(
                        id = 0,
                        email = "",
                        fullName = "Пьянков Семён Александрович",
                        password = "",
                        phoneNumber = "+799965675359",
                        rating = 123,
                        tgLink = null,
                        vkLink = null
                    ),
                    User(
                        id = 1,
                        email = "",
                        fullName = "Пьянков Семён Александрович",
                        password = "",
                        phoneNumber = "+799965675359",
                        rating = 123,
                        tgLink = null,
                        vkLink = null
                    ),
                    User(
                        id = 2,
                        email = "",
                        fullName = "Пьянков Семён Александрович",
                        password = "",
                        phoneNumber = "+799965675359",
                        rating = 123,
                        tgLink = null,
                        vkLink = null
                    ),
                    User(
                        id = 3,
                        email = "",
                        fullName = "Пьянков Семён Александрович",
                        password = "",
                        phoneNumber = "+799965675359",
                        rating = 123,
                        tgLink = null,
                        vkLink = null
                    ),
                )
            )) {

            }
        }
    }
}
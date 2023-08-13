package ru.serzh272.nfp.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, viewModel: ProfileViewModel = viewModel()) {
    val uiState by viewModel.profileUiState.collectAsState()

    ProfileScreenContent(modifier, uiState, viewModel::handleCommand)
}

@Composable
fun ProfileScreenContent(modifier: Modifier = Modifier, uiState: ProfileScreenUiState, command: (ProfileViewModel.ProfileScreenCommand) -> Unit) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = uiState.userInfo.toString())
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun NProfileScreenPreview() {
    ru.serzh272.theme.NFPTheme {
        ProfileScreenContent(
            modifier = Modifier
                .fillMaxSize(),
            uiState = ProfileScreenUiState(),
            command = {},
        )
    }
}

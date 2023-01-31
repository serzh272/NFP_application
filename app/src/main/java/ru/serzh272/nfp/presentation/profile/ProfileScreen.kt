package ru.serzh272.nfp.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.serzh272.nfp.ui.theme.NFPTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, viewModel: ProfileViewModel = viewModel()) {
    val uiState by viewModel.profileUiState.collectAsState()

    ProfileScreenContent(modifier, uiState, viewModel::handleCommand)
}

@Composable
fun ProfileScreenContent(modifier: Modifier = Modifier, uiState: ProfileScreenUiState, command: (ProfileViewModel.ProfileScreenCommand) -> Unit) {
    Column {
        Text(text = uiState.userInfo.toString())
        SwipableController(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }
}

@Composable
fun SwipableController(modifier: Modifier) {
    //TODO not implemented
}

@Preview(device = Devices.PIXEL_4, showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun NProfileScreenPreview() {
    NFPTheme {
        ProfileScreenContent(
            modifier = Modifier
                .fillMaxSize(),
            uiState = ProfileScreenUiState(),
            command = {},
        )
    }
}

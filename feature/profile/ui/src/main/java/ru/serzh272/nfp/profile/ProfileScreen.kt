package ru.serzh272.nfp.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import ru.serzh272.nfp.theme.NFPTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    uiState: ProfileViewModel.ViewState = ProfileViewModel.ViewState(),
    onAction: (ProfileViewModel.Action) -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = uiState.userInfo.toString())
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun NProfileScreenPreview() {
    NFPTheme {
        ProfileScreen(
            modifier = Modifier
                .fillMaxSize(),
            uiState = ProfileViewModel.ViewState(),
            onAction = { },
        )
    }
}

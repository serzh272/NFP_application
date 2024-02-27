package ru.serzh272.nfp.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.serzh272.nfp.norms.NormsScreen
import ru.serzh272.nfp.norms.NormsViewModel
import ru.serzh272.nfp.presentation.component.RootNavigation.Companion.HELP_ROUTE
import ru.serzh272.nfp.presentation.component.RootNavigation.Companion.NORMS_ROUTE
import ru.serzh272.nfp.presentation.component.RootNavigation.Companion.PROFILE_ROUTE
import ru.serzh272.nfp.presentation.component.RootNavigation.Companion.RESULTS_ROUTE
import ru.serzh272.nfp.presentation.model.RootEvent
import ru.serzh272.nfp.presentation.results.ResultsViewModel
import ru.serzh272.nfp.profile.ProfileScreen
import ru.serzh272.nfp.profile.ProfileViewModel
import ru.serzh272.nfp.results.ResultsScreen
import ru.serzh272.nfp.sideeffect.SingleEventEffect

@Composable
fun RootNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NORMS_ROUTE,
    onEvent: suspend (RootEvent) -> Unit
) {
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination) {
        composable(NORMS_ROUTE) {
            val viewModel: NormsViewModel = hiltViewModel()
            val uiState by viewModel.normsUiState.collectAsState()
            NormsScreen(
                modifier = Modifier.fillMaxSize(),
                uiState = uiState,
                command = viewModel::handleCommand
            )
        }
        composable(RESULTS_ROUTE) {
            val viewModel: ResultsViewModel = hiltViewModel()
            val uiState by viewModel.resultsUiState.collectAsState()
            ResultsScreen(
                modifier = Modifier.fillMaxSize(),
                uiState = uiState,
                command = viewModel::handleCommand
            )
        }
        composable(PROFILE_ROUTE) {
            val viewModel: ProfileViewModel = hiltViewModel()
            val uiState: ProfileViewModel.ViewState by viewModel.stateFlow.collectAsState()
            ProfileScreen(modifier = Modifier.fillMaxSize(), uiState, viewModel::sendAction)
            SingleEventEffect(flow = viewModel.eventFlow, lifecycleState = Lifecycle.State.STARTED) { event ->
                when(event) {
                    ProfileViewModel.Event.DataLoaded -> onEvent(RootEvent.ShowMessage.Success("Data Loaded"))
                }
            }
        }
        composable(HELP_ROUTE) {
            Text(text = "help")
        }
    }
}

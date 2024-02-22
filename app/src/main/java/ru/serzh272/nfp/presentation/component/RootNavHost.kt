package ru.serzh272.nfp.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.serzh272.nfp.norms.NormsScreen
import ru.serzh272.nfp.presentation.component.RootNavigation.Companion.HELP_ROUTE
import ru.serzh272.nfp.presentation.component.RootNavigation.Companion.NORMS_ROUTE
import ru.serzh272.nfp.presentation.component.RootNavigation.Companion.PROFILE_ROUTE
import ru.serzh272.nfp.presentation.component.RootNavigation.Companion.RESULTS_ROUTE
import ru.serzh272.nfp.profile.ProfileScreen
import ru.serzh272.nfp.results.ResultsScreen

@Composable
fun RootNavHost(modifier: Modifier = Modifier, navController: NavHostController, startDestination: String = NORMS_ROUTE) {
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination) {
        composable(NORMS_ROUTE) {
            NormsScreen(modifier = Modifier.fillMaxSize(), hiltViewModel())
        }
        composable(RESULTS_ROUTE) {
            ResultsScreen(modifier = Modifier.fillMaxSize(), hiltViewModel())
        }
        composable(PROFILE_ROUTE) {
            ProfileScreen(modifier = Modifier.fillMaxSize(), hiltViewModel())
        }
        composable(HELP_ROUTE) {
            Text(text = "help")
        }
    }
}

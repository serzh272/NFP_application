package ru.serzh272.nfp.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.serzh272.nfp.presentation.results.ResultsScreen
import ru.serzh272.norms.NormsScreen
import ru.serzh272.norms.ProfileScreen

@Composable
fun RootNavHost(modifier: Modifier = Modifier, navController: NavHostController, startDestination: String = "norms"){
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination){
        composable("norms"){
            NormsScreen(modifier = Modifier.fillMaxSize(), hiltViewModel())
        }
        composable("results"){
            ResultsScreen(modifier = Modifier.fillMaxSize(), hiltViewModel())
        }
        composable("profile"){
            ProfileScreen(modifier = Modifier.fillMaxSize(), hiltViewModel())
        }
        composable("help"){
            Text(text = "help")
        }
    }
}

package ru.serzh272.nfp.presentation

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.serzh272.nfp.presentation.component.IMainViewModel
import ru.serzh272.nfp.presentation.component.MainViewModel
import ru.serzh272.nfp.presentation.component.RootNavHost
import ru.serzh272.nfp.presentation.component.RootNavigation
import ru.serzh272.nfp.presentation.model.RootEvent
import ru.serzh272.nfp.theme.NFPTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    private val navigationItems = listOf(
        RootNavigation.Norms,
        RootNavigation.Results,
        RootNavigation.Profile,
        RootNavigation.Help
    )


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            NFPTheme {
                MainScreen(viewModel = mainViewModel, navigationItems)
            }
        }
        requestPermissions(arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
    }

    @Composable
    fun MainScreen(viewModel: IMainViewModel, navigationItems: List<RootNavigation>) {
        val navController = rememberNavController()
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    navigationItems.forEach { screen ->
                        NavigationBarItem(
                            selected = if (LocalInspectionMode.current) navigationItems.indexOf(screen) == 0 else currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                handleTopLevelNavigation(navController, screen)
                            },
                            icon = {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = screen.iconRes),
                                    contentDescription = stringResource(id = screen.resourceId)
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(id = screen.resourceId),
                                    fontSize = 10.sp
                                )
                            },
                            colors = NavigationBarItemDefaults.colors().copy(
                                selectedIndicatorColor = Color.Transparent,
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState
                ) {
                    Snackbar(snackbarData = it)
                }
            },
        ) {
            RootNavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                onEvent = { rootEvent ->
                    when(rootEvent) {
                        is RootEvent.ShowDialog -> TODO()
                        is RootEvent.ShowMessage -> snackbarHostState.showSnackbar(rootEvent.message)
                    }
                }
            )
        }
    }

    private fun handleTopLevelNavigation(navController: NavHostController, screen: RootNavigation) {
        navController.navigate(screen.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        NFPTheme {
            MainScreen(viewModel = object : IMainViewModel {}, navigationItems)
        }
    }
}

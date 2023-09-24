package ru.serzh272.nfp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.colorResource
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
import ru.serzh272.nfp.theme.NFPTheme
import ru.serzh272.nfp.core.theme.R as ThemeR

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    private val navigationItems = listOf(
        RootNavigation.Norms,
        RootNavigation.Results,
        RootNavigation.Profile,
        RootNavigation.Help
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFPTheme {
                MainScreen(viewModel = mainViewModel, navigationItems)
            }
        }
    }

    @Composable
    fun MainScreen(viewModel: IMainViewModel, navigationItems: List<RootNavigation>) {
        val scaffoldState = rememberScaffoldState()
        val navController = rememberNavController()
        Scaffold(scaffoldState = scaffoldState,
            bottomBar = {
                BottomNavigation(backgroundColor = Color.White) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    navigationItems.forEach { screen ->
                        BottomNavigationItem(
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
                            selectedContentColor = MaterialTheme.colors.primary,
                            unselectedContentColor = colorResource(
                                id = ThemeR.color.silver_sand
                            )
                        )
                    }
                }
            }
        ) {
            RootNavHost(Modifier.padding(it), navController = navController)
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

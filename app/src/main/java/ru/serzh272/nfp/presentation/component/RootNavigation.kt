package ru.serzh272.nfp.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.serzh272.core.ui.R as CoreUiR

sealed class RootNavigation(val route: String, @DrawableRes val iconRes: Int, @StringRes val resourceId: Int) {
    object Norms: RootNavigation(NORMS_ROUTE, CoreUiR.drawable.ic_norms, CoreUiR.string.norms)
    object Results: RootNavigation(RESULTS_ROUTE, CoreUiR.drawable.ic_results, CoreUiR.string.results)
    object Profile: RootNavigation(PROFILE_ROUTE, CoreUiR.drawable.ic_military, CoreUiR.string.profile)
    object Help: RootNavigation(HELP_ROUTE, CoreUiR.drawable.ic_help, CoreUiR.string.help)

    companion object {

        const val NORMS_ROUTE = "norms"
        const val RESULTS_ROUTE = "results"
        const val PROFILE_ROUTE = "profile"
        const val HELP_ROUTE = "help"
    }
}

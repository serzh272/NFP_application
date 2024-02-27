package ru.serzh272.nfp.sideeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

@Composable
fun <T, F : Flow<T>> SingleEventEffect(
    flow: F,
    lifecycleState: Lifecycle.State,
    collector: FlowCollector<T>
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = flow) {
        lifecycleOwner.repeatOnLifecycle(lifecycleState) {
            flow.collect(collector)
        }
    }
}

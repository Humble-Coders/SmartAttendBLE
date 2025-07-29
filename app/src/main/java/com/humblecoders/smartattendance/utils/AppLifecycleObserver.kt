package com.humblecoders.smartattendance.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import timber.log.Timber

/**
 * Composable that observes app lifecycle events
 */
@Composable
fun AppLifecycleObserver(
    onAppResumed: () -> Unit,
    onAppPaused: () -> Unit = {}
) {
    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    Timber.d("🔄 App resumed - checking permissions")
                    onAppResumed()
                }
                Lifecycle.Event.ON_PAUSE -> {
                    Timber.d("⏸️ App paused")
                    onAppPaused()
                }
                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}
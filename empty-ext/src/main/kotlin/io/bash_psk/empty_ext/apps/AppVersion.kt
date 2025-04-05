package io.bash_psk.empty_ext.apps

import androidx.compose.runtime.Immutable

@Immutable
data class AppVersion(val name: String = "", val number: Long = 0L)
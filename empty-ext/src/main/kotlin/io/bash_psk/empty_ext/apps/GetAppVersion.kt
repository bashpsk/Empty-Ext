package io.bash_psk.empty_ext.apps

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.pm.PackageInfoCompat
import io.bash_psk.empty_ext.log.SetLog

fun getAppVersion(context: Context): AppVersion {

    return try {

        val packageManager = context.packageManager
        val packageName = context.packageName

        val packageInfo = when {

            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> packageManager.getPackageInfo(
                packageName,
                PackageManager.PackageInfoFlags.of(0)
            )

            else -> packageManager.getPackageInfo(packageName, 0)
        }

        AppVersion(
            name = packageInfo.versionName ?: "",
            number = PackageInfoCompat.getLongVersionCode(packageInfo),
        )
    } catch (exception: Exception) {

        SetLog.error(tag = "EMPTY-EXT", throwable = exception)
        AppVersion()
    }
}
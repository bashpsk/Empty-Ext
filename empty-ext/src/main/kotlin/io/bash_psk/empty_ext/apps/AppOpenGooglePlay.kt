package io.bash_psk.empty_ext.apps

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import io.bash_psk.empty_ext.log.SetLog

fun appOpenGooglePlay(context: Context, appPackage: String) {

    try {

        Intent(Intent.ACTION_VIEW, "market://details?id=$appPackage".toUri()).apply {

            setPackage("com.android.vending")
        }.also { intent ->

            context.startActivity(intent)
        }
    } catch (_: ActivityNotFoundException) {

        Intent(
            Intent.ACTION_VIEW,
            "https://play.google.com/store/apps/details?id=$appPackage".toUri()
        ).also { intent ->

            context.startActivity(intent)
        }
    } catch (exception: Exception) {

        SetLog.error(tag = "EMPTY-EXT", throwable = exception)
    }
}
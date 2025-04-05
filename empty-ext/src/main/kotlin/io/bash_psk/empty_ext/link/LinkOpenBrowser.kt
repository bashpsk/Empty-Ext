package io.bash_psk.empty_ext.link

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import io.bash_psk.empty_ext.log.SetLog

fun linkOpenBrowser(context: Context, link: String) {

    try {

        val intent = Intent(Intent.ACTION_VIEW, link.toUri())

        context.startActivity(Intent.createChooser(intent, "Open link with..."))
    } catch (exception: Exception) {

        SetLog.error(tag = "EMPTY-EXT", throwable = exception)
    }
}
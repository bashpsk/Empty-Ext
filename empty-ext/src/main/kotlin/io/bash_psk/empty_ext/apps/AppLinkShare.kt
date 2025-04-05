package io.bash_psk.empty_ext.apps

import android.content.Context
import android.content.Intent

fun appLinkShare(context: Context, appPackage: String, message: String = "") {

    val appLink = "$message https://play.google.com/store/apps/details?id=$appPackage"

    val shareIntent = Intent(Intent.ACTION_SEND).apply {

        setType("text/plain")
        putExtra(Intent.EXTRA_TEXT, appLink)
    }

    context.startActivity(Intent.createChooser(shareIntent, "App Share with..."))
}
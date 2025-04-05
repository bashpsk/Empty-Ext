package io.bash_psk.empty_ext.toast

import android.content.Context
import android.widget.Toast

fun String.toastShort(context: Context) {

    this.toastCustomDuration(context = context, duration = Toast.LENGTH_SHORT)
}

fun String.toastLong(context: Context) {

    this.toastCustomDuration(context = context, duration = Toast.LENGTH_LONG)
}

fun String.toastCustomDuration(context: Context, duration: Int) {

    Toast.makeText(context, this, duration).show()
}
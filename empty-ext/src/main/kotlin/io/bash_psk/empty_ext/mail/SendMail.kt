package io.bash_psk.empty_ext.mail

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

fun sendEmail(context: Context, email: String, subject: String, body: String) {

    Intent(Intent.ACTION_SENDTO).apply {

        setData("mailto:".toUri())
        putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, body)
    }.also { intent ->

        context.startActivity(intent)
    }
}
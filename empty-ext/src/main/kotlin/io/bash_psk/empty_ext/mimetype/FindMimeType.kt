package io.bash_psk.empty_ext.mimetype

import android.webkit.MimeTypeMap

fun findMimeType(extension: String) : String {

    return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension) ?: "*/*"
}
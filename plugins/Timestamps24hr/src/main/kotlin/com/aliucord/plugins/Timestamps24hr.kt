package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import java.text.SimpleDateFormat
import java.util.Locale

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class Timestamps24hr : Plugin() {
    private val format = SimpleDateFormat("HH:mm", Locale.getDefault())

    override fun start(context: Context) {
        Utils.showToast("Timestamps24hr loaded")
        // TODO (needs your own APK): find the message-timestamp formatter
        // in the chat ViewHolder and patch it to use `format` above.
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}

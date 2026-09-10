package com.aliucord.plugins

import android.content.Context
import com.aliucord.Utils
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

@AliucordPlugin(requiresRestart = false)
@Suppress("unused")
class MessageLogger : Plugin() {
    private val cache = LinkedHashMap<String, String>()

    override fun start(context: Context) {
        Utils.showToast("MessageLogger loaded")
        // TODO (needs your own APK): hook the MESSAGE_DELETE/MESSAGE_UPDATE
        // gateway dispatch handler to cache and re-display removed content.
        // Search jadx for the "MESSAGE_DELETE" string constant.
    }

    override fun stop(context: Context) {
        cache.clear()
        patcher.unpatchAll()
    }
}
